app.service("BreadService",function($http,ConfigService,TemplateDetailService){
	var url=ConfigService.getBaseUrl()+"/masterbreadlist";
	
	
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
		
		TemplateDetailService.countByBreadId(data.id,function(response){
			
			if(response>0)
				failCallBack("Unable to make changes to this item because it has been assigned to a template");
			else
				{
					$http.post(url+"/save",data)
					.then(function(response){successCallBack(response.data);})
					.catch(function(response){failCallBack(response);});
				}
			
		},function(response){
			failCallBack(response);
		});
		
		
		
	}
	
	this.delete=function(data,successCallBack,failCallBack){
		
		TemplateDetailService.countByBreadId(data.id,function(response){
			if(response>0)
				failCallBack("Unable to delete this item because it has been assigned to a template");
			else{
				$http.delete(url+"/delete",{
					params:{"y":data.id}
				})
				.then(function(response){successCallBack(response.data);})
				.catch(function(response){failCallBack(response);});
			}
		},function(response){failCallBack(response);});
		
		
	}
	
})