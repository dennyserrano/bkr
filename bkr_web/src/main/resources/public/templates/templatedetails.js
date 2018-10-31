app.controller("templateDetailCtrl",function($scope,$routeParams){
	
	console.log($routeParams.templateId);

	$scope.breads=[];
	
	$scope.selectedBreadSave=function()
	{
		console.log(angular.toJson($scope.breads));
	}
	
});