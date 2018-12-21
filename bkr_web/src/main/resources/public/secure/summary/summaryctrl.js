app.controller("summaryCtrl",function($scope,ReportService,LoadingModalService){
	
	$scope.data=[
//		{
//			date:new Date(),
//			total:5000,
//			expenses:3000,
//			grandTotal:4000,
//			remittance:9000,
//			difference:8000,
//			amExpenses:2000,
//			pmExpenses:7000,
//			amRemittance:7500,
//			pmRemittance:2000
//		},
//		{
//			date:new Date(),
//			total:5000,
//			expenses:3000,
//			grandTotal:4000,
//			remittance:9000,
//			difference:8000,
//			amExpenses:2000,
//			pmExpenses:7000,
//			amRemittance:7500,
//			pmRemittance:2000
//		}
	];
	
	
	$scope.yearChange=function(){
		var year=$scope.ddlYear;
		LoadingModalService.show();
		ReportService.headerByYear(year,function(data){
			$scope.data=data;
			LoadingModalService.hide();
		},function(){});
	}
	LoadingModalService.show();
	ReportService.allYear(function(data){
		$scope.yearList=data
		LoadingModalService.hide();
	},function(){})
	
})