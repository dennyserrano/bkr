app.service("DailyDetailService",function($http,ConfigService){
	var url=ConfigService.getBaseUrl()+"/ddetail";
	
	
//	this.save=function(data,successCallBack,failCallBack){
//		$http.post(url+"/save",data)
//		.then(function(response){successCallBack(response.data);})
//		.catch(function(response){failCallBack(response);});
//	}
	
	this.countByBreadId=function(id,successCallBack,failCallBack)
	{
		$http.get(url+"/countByBreadId",{
			params:{"y":id}
		})
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
})