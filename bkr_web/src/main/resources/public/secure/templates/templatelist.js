
app.controller("templateListCtrl",function($scope,$routeParams,$timeout,TemplateService){

	$scope.templates=[];
	$scope.toastUtility={};
	$scope.listSize=function()
	{
		return $scope.templates.length;
	}
	
	$scope.delete=function(template){
		
		TemplateService.delete(template,function(response){
			fetchAll(function(response){
				$scope.templates=response;
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
	
	fetchAll(function(response){
		$scope.templates=response;
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