
app.controller("templateListCtrl",function($scope,$routeParams,$timeout,TemplateService,LoadingModalService){

	$scope.templates=[];
	$scope.toastUtility={};
	$scope.listSize=function()
	{
		return $scope.templates.length;
	}
	
	$scope.delete=function(template){
		
		LoadingModalService.show();
		TemplateService.delete(template,function(response){
			fetchAll(function(response){
				$scope.templates=response;
				LoadingModalService.hide();
			},function(response){
				$scope.toastUtility.fail(response);
			})
		},function(response){
			$scope.toastUtility.fail(response);
		});
	}
	
	function fetchAll(successCall,failCall)
	{
		TemplateService.listAll(successCall,failCall);
	}
	
	LoadingModalService.show();
	fetchAll(function(response){
		$scope.templates=response;
		LoadingModalService.hide();
	},function(response){
		$scope.toastUtility.fail(response);
	})
	
	$timeout(function () {
		if(angular.isDefined($routeParams.msgId))
		{
			if($routeParams.msgId==='0')
				$scope.toastUtility.success("Save Successful");
			else if($routeParams.msgId==='1')
				$scope.toastUtility.fail("Save Failed");
			else
				{
					
				}
		}
	});
	

});