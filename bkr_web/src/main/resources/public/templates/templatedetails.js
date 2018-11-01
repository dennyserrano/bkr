app.controller("templateDetailCtrl",function($scope,$routeParams,$timeout,$location){
	
	
	$scope.template=
	{
		id:$routeParams.templateId	,
		name:"t1"
	};
	
	$scope.breads=[];
	
	$scope.templateSelectSave=function()
	{
		console.log($scope.selectedTemplate);
	}
	
	$scope.templateNameSave=function()
	{
		
	}
	
	$scope.templateNameCancel=function()
	{
		$location.path("/templates");
	}
	
	$scope.selectedBreadSave=function()
	{
		console.log(angular.toJson($scope.breads));
	}
	
	if($scope.template.id==0)
	{
		$timeout(function () {
			$("#templatename").modal('show');
		});
	}
	
	
	
});