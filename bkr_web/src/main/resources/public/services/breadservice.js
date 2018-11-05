app.service("BreadService",function($http){
	var url="http://localhost:8080/masterbreadlist";
	this.get=function(id,successCallBack,failCallBack)
	{
		$http.get(url+"/find",{
			params:{"y":id}
		}).then(function(response){
			successCallBack(response.data);
		})
		.catch(function(response){
			console.log(response);
		});
	}
	
})