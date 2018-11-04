app.controller("dailyDetailsCtrl",function($timeout,$scope){
	$timeout(function(){
		$( "#tabs" ).tabs();
	});
	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	today = mm + '/' + dd + '/' + yyyy;
	$scope.date=today;
	
	$scope.amHeader={
			total:0,
			expenses:0,
			grandTotal:0,
			remittance:0,
			difference:0,
			list:
				[
					{
						id:1,
						dailyHeaderId:1,
						breadName:"Pandesal",
						price:1.00,
						beginningInv:0,
						production:0,
						endingInv:0,
						tgafs:0,
						sales:0,
						amount:0
					},
					{
						id:2,
						dailyHeaderId:1,
						breadName:"Monay",
						price:5.00,
						beginningInv:0,
						production:0,
						endingInv:0,
						tgafs:0,
						sales:0,
						amount:0
					}
				]
	};
	
	$scope.pmHeader={
			total:0,
			expenses:0,
			grandTotal:0,
			remittance:0,
			difference:0,
			list:
				[
					{
						id:1,
						dailyHeaderId:1,
						breadName:"Pandesal",
						price:1.00,
						beginningInv:0,
						production:0,
						endingInv:0,
						tgafs:0,
						sales:0,
						amount:0
					},
					{
						id:2,
						dailyHeaderId:1,
						breadName:"Monay",
						price:5.00,
						beginningInv:0,
						production:0,
						endingInv:0,
						tgafs:0,
						sales:0,
						amount:0
					}
				]
	};

})