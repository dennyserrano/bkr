app.service("DailyHeaderService",function($http,ConfigService){
	var url=ConfigService.getBaseUrl()+"/dhead";
	
	this.get=function(id,successCallBack,failCallBack)
	{
		$http.get(url+"/find",{
			params:{"y":id}
		})
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
	this.listAll=function(successCallBack,failCallBack){
		$http.get(url+"/all")
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
	this.save=function(data,successCallBack,failCallBack){
		$http.post(url+"/save",data)
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
	this.delete=function(data,successCallBack,failCallBack){
		$http.delete(url+"/delete",{
			params:{"y":data.id}
		})
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
	this.createNew=function(successCallBack,failCallBack)
	{
		$http.get(url+"/createnew")
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
})