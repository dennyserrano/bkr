app.controller("dailyDetailsCtrl",function($timeout,$location,$routeParams,$scope,BreadService,DailyHeaderService){
	

	var _dictionary={};
	$scope.date=new Date().getTime();
	$scope.toastUtility={};
	
//	$scope.i=  	{  		    "id": 1,  		    "date": "2018-11-05T09:17:00.000+0000",  		    "total": 30,  		    "expenses": 200,  		    "grandTotal": -170,  		    "remittance": 20000,  		    "difference": 20170,  		    "amRemittance": 10000,  		    "pmRemittance": 10000,  		    "amExpenses": 100,  		    "pmExpenses": 100,  		    "amList": [  		        {  		            "id": 2,  		            "dailyHeaderId": 1,  		            "beginningInv": 5,  		            "production": 5,  		            "endingInv": 5,  		            "tgafs": 10,  		            "sales": 5,  		            "amount": 10,  		            "category": "AM",  		            "templateDetail": {  		                "id": 2,  		                "templateId": 1,  		                "masterBreadId": 2,  		                "breadName": "monay",  		                "price": 2.3,  		                "head": null  		            }  		        },  		        {  		            "id": 4,  		            "dailyHeaderId": 1,  		            "beginningInv": 5,  		            "production": 5,  		            "endingInv": 5,  		            "tgafs": 10,  		            "sales": 5,  		            "amount": 5,  		            "category": "AM",  		            "templateDetail": {  		                "id": 1,  		                "templateId": 1,  		                "masterBreadId": 1,  		                "breadName": "pandesal",  		                "price": 1,  		                "head": null  		            }  		        }  		    ],  		    "pmList": [  		        {  		            "id": 1,  		            "dailyHeaderId": 1,  		            "beginningInv": 5,  		            "production": 5,  		            "endingInv": 5,  		            "tgafs": 10,  		            "sales": 5,  		            "amount": 10,  		            "category": "PM",  		            "templateDetail": {  		                "id": 2,  		                "templateId": 1,  		                "masterBreadId": 2,  		                "breadName": "haha",  		                "price": 2,  		                "head": null  		            }  		        },  		        {  		            "id": 3,  		            "dailyHeaderId": 1,  		            "beginningInv": 5,  		            "production": 5,  		            "endingInv": 5,  		            "tgafs": 10,  		            "sales": 5,  		            "amount": 5,  		            "category": "PM",  		            "templateDetail": {  		                "id": 1,  		                "templateId": 1,  		                "masterBreadId": 1,  		                "breadName": "pandesal",  		                "price": 1,  		                "head": null  		            }  		        }  		    ]  		};
	$scope.header={};
	
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
	
	$scope.tabChange=function(amHeader)
	{

		for(x=0;x<amHeader.list.length;x++)
		{
			var e=amHeader.list[x];
			_dictionary[e.templateDetail.masterBreadId].beginningInv=e.endingInv;
		}
		
	}
	
	$scope.save=function()
	{
		there($scope.header,$scope.amHeader,$scope.pmHeader);
		DailyHeaderService.save($scope.header,function(response){
			$location.path("/dailylist/0");
		},function(response){
			
		})
		
	}
	
	
	function here(mainHeader,header,category)
	{
		header.remittance= mainHeader[category+"Remittance"]
		header.expenses=mainHeader[category+"Expenses"];
		header.list=transformList(mainHeader[category+"List"]);
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
	
	function transformList(sourceList)
	{
		for(var x=0;x<sourceList.length;x++)
			sourceList[x].order= sourceList[x].templateDetail.order;
		
		return sourceList;
	}
	
	function initializeDictionary(pmHeader)
	{
		for(x=0;x<pmHeader.list.length;x++)
		{
			var e=pmHeader.list[x];
			_dictionary[e.templateDetail.masterBreadId]=e;
		}
	}
	
	function init()
	{
		here($scope.header,$scope.amHeader,"am");
		here($scope.header,$scope.pmHeader,"pm");
		initializeDictionary($scope.pmHeader);
	}
	
	if($routeParams.id==="0")
	{
		DailyHeaderService.createNew(function(response){
			if(response==="")
				$scope.toastUtility.fail("There was no active template detected. Probably create a new one?");
			else
			{
				$scope.header=response;
				init();
			}
		},function(response){});
		
	}else
	{
		DailyHeaderService.get($routeParams.id,function(response){
			$scope.header=response;
			init();
		},function(response){
			$scope.toastUtility.fail("An error has occurred while trying to fetch the details");
		});
	}
	
	
	$timeout(function(){
		$( "#tabs" ).tabs();
	});
	
	
})