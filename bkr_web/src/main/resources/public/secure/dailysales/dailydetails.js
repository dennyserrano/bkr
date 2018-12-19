app.controller("dailyDetailsCtrl",function($timeout, $location, $routeParams, $scope,BreadService, DailyHeaderService,LoadingModalService) {

		var _dictionary = {};
		$scope.date = new Date().getTime();
		$scope.toastUtility = {};
		$scope.header = {};
		$scope.amHeader = {};
		$scope.pmHeader = {};

		$scope.tabChange = function(amHeader) {

			for (x = 0; x < amHeader.list.length; x++) {
				var e = amHeader.list[x];
				_dictionary[e.templateDetail.masterBreadId].beginningInv = e.endingInv;
			}

		}

		$scope.save = function() {
			there($scope.header, $scope.amHeader, $scope.pmHeader);
			DailyHeaderService.save($scope.header, function(
					response) {
				$location.path("/dailylist/0");
			}, function(response) {

			})

		}

		function here(mainHeader, header, category) {
			header.category = category.toUpperCase();
			header.remittance = mainHeader[category + "Remittance"]
			header.expenses = mainHeader[category + "Expenses"];
			header.list = transformList(mainHeader[category
					+ "List"]);
		}

		function there(mainHeader, amHeader, pmHeader) {
			mainHeader.amExpenses = amHeader.expenses;
			mainHeader.pmExpenses = pmHeader.expenses;
			mainHeader.amRemittance = amHeader.remittance;
			mainHeader.pmRemittance = pmHeader.remittance;
			mainHeader.amList = amHeader.list;
			mainHeader.pmList = pmHeader.list;
		}

		function transformList(sourceList) {
			for (var x = 0; x < sourceList.length; x++)
				sourceList[x].order = sourceList[x].templateDetail.order;

			return sourceList;
		}

		function initializeDictionary(pmHeader) {
			for (x = 0; x < pmHeader.list.length; x++) {
				var e = pmHeader.list[x];
				_dictionary[e.templateDetail.masterBreadId] = e;
			}
		}

		function init() {
			here($scope.header, $scope.amHeader, "am");
			here($scope.header, $scope.pmHeader, "pm");
			initializeDictionary($scope.pmHeader);
		}

		LoadingModalService.show();
		if ($routeParams.id === "0") {
			
			DailyHeaderService.createNew(function(response) {
								if (response === "")
									$scope.toastUtility
											.fail("There was no active template detected. Probably create a new one?");
								else {
									$scope.header = response;
									init();
								}
								LoadingModalService.hide();
							}, function(response) {
								LoadingModalService.hide();
							});

		} else {
			DailyHeaderService.get($routeParams.id,function(response) {
								$scope.header = response;
								init();
								LoadingModalService.hide();
							},
							function(response) {
								LoadingModalService.hide();
								$scope.toastUtility
										.fail("An error has occurred while trying to fetch the details");
							});
		}

		$timeout(function() {

			$("#tabs").tabs();
			$(document).ready(function(){
				
//							([1-9](,\d{3})*|[1-9]\d{2}(,\d{3})*)
				$(".number").on("keydown", (function(e) {

					var valid = false;

					valid |= (e.keyCode >= 48 && e.keyCode <= 57)
					valid |= (e.keyCode >= 96 && e.keyCode <= 105)
					valid |= (e.keyCode>=37 && e.keyCode<=40)
					valid |=e.keyCode===8;
					
					if (!valid)
						e.preventDefault();

					if (e.keyCode === 13) {
						var id = $(this).attr("id");
						if (id === undefined)
							return;
						var spl = id.split("_");
						var prefix = spl[0] + "_" + spl[1] + "_";
						var index = parseInt(spl[2]);

						$("#" + prefix + (++index)).focus();
					}

				}));

				$(".number").focus(function(e) {
					$(this).select();
				});

				$(".number").on("blur", function(e) {
					$(this).val(function(index, value) {
						// return value
						// .replace(/\D/g, "")
						// .replace(/\B(?=(\d{3})+(?!\d))/g, ",");

						return ReplaceNumberWithCommas(value);

					});

					var val = $(this).val();
					if (val === '')
						$(this).val(0);
					
					
					function ReplaceNumberWithCommas(yourNumber) {
					    //Seperates the components of the number
					    var components = yourNumber.toString().split(".");
					    //Comma-fies the first part
					    components [0] = components [0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
					    //Combines the two sections
					    return components.join(".");
					}

				});
				
			})

		});
		
		
		

	})