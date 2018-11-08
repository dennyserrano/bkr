app.service("TemplateDetailService",function($http,ConfigService){
	var url=ConfigService.getBaseUrl()+"/tdetail";
	
	this.countByBreadId=function(id,successCallBack,failCallBack)
	{
		$http.get(url+"/countB",{
			params:{"y":id}
		})
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
	this.countByTemplateIdAndBreadId=function(data,successCallBack,failCallBack)
	{
		$http.get(url+"/countB",{
			params:
			{
				"y":data.templateId,
				"z":data.breadId
			}
		})
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response);});
	}
	
	this.delete=function(data,successCallBack,failCallBack){
		
		
		$http.delete(url+"/delete",{
			params:{"y":data.id}
		})
		.then(function(response){successCallBack(response.data);})
		.catch(function(response){failCallBack(response.data.message);});
			
		
		
	}
	
})