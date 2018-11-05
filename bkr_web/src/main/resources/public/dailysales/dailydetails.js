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
	
	$scope.header=
	{
		    "id": 1,
		    "date": "2018-11-05T09:17:00.000+0000",
		    "total": 30,
		    "expenses": 200,
		    "grandTotal": -170,
		    "remittance": 20000,
		    "difference": 20170,
		    "amRemittance": 10000,
		    "pmRemittance": 10000,
		    "amExpenses": 100,
		    "pmExpenses": 100,
		    "amList": [
		        {
		            "id": 2,
		            "dailyHeaderId": 1,
		            "beginningInv": 5,
		            "production": 5,
		            "endingInv": 5,
		            "tgafs": 10,
		            "sales": 5,
		            "amount": 10,
		            "category": "AM",
		            "templateDetail": {
		                "id": 2,
		                "templateId": 1,
		                "masterBreadId": 2,
		                "breadName": "monay",
		                "price": 2,
		                "head": null
		            }
		        },
		        {
		            "id": 4,
		            "dailyHeaderId": 1,
		            "beginningInv": 5,
		            "production": 5,
		            "endingInv": 5,
		            "tgafs": 10,
		            "sales": 5,
		            "amount": 5,
		            "category": "AM",
		            "templateDetail": {
		                "id": 1,
		                "templateId": 1,
		                "masterBreadId": 1,
		                "breadName": "pandesal",
		                "price": 1,
		                "head": null
		            }
		        }
		    ],
		    "pmList": [
		        {
		            "id": 1,
		            "dailyHeaderId": 1,
		            "beginningInv": 5,
		            "production": 5,
		            "endingInv": 5,
		            "tgafs": 10,
		            "sales": 5,
		            "amount": 10,
		            "category": "PM",
		            "templateDetail": {
		                "id": 2,
		                "templateId": 1,
		                "masterBreadId": 2,
		                "breadName": "haha",
		                "price": 2,
		                "head": null
		            }
		        },
		        {
		            "id": 3,
		            "dailyHeaderId": 1,
		            "beginningInv": 5,
		            "production": 5,
		            "endingInv": 5,
		            "tgafs": 10,
		            "sales": 5,
		            "amount": 5,
		            "category": "PM",
		            "templateDetail": {
		                "id": 1,
		                "templateId": 1,
		                "masterBreadId": 1,
		                "breadName": "pandesal",
		                "price": 1,
		                "head": null
		            }
		        }
		    ]
		};
	
	
	$scope.amHeader={
			total:0,
			expenses:100,
			grandTotal:0,
			remittance:10000,
			difference:0,
			list:[]
				
	};
	
	$scope.pmHeader={
			total:0,
			expenses:0,
			grandTotal:0,
			remittance:0,
			difference:0,
			list:[]
	};

	
	function here(mainHeader,header,category)
	{
		header.remittance= mainHeader[category+"Remittance"]
		header.expenses=mainHeader[category+"Expenses"];
		header.list=mainHeader[category+"List"];
	}
	
	function there(mainHeader,amHeader,pmHeader)
	{
		mainHeader.amExpenses=amHeader.expenses;
		mainHeader.pmExpenses=pmHeader.expenses;
		mainHeader.amRemittance=amHeader.remittance;
		mainHeader.pmRemittance=pmHeader.remittance;
		mainHeader.amList=amHeader.list;
		mainHeader.pmList=pmHeader.list;
	}
	
	here($scope.header,$scope.amHeader,"am");
	here($scope.header,$scope.pmHeader,"pm");
	
	$scope.click=function(){
		there($scope.header,$scope.amHeader,$scope.pmHeader);
		console.log($scope.header);
	}
	
	
})