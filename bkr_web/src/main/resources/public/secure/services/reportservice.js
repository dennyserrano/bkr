app.service("ReportService",function($http,ConfigService){
	var url=ConfigService.getBaseUrl()+"/reports";
	
	this.allYear=function(successCallBack,failCallBack)
	{
		$http.get(url+"/allyear")
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
	this.headerByYear=function(year,successCallBack,failCallBack)
	{
		$http.get(url+"/year",{
			params:{"year":year}
		})
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
});