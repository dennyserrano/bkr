app.controller("dailyListCtrl",function($scope){
	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	today = mm + '/' + dd + '/' + yyyy;
	
	$scope.headerList=
		[
			{
				id:1,
				date: today,
				total:100000,
				expenses:500,
				grandTotal:100000,
				remittance:100000,
				difference:500
			}
		]
	
//	private Date date;
//	private BigDecimal total;
//	private BigDecimal expenses;
//	private BigDecimal grandTotal;
//	private BigDecimal remittance;
//	private BigDecimal difference;
})