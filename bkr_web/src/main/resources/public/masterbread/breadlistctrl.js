app.controller("breadListCtrl",function($scope,BreadService,$timeout){

	$scope.breadList=[];
	$scope.doFade = false;
	
	$scope.modalSave=function(){
		BreadService.save($scope.breadModel,function(){
			fetch();
			$scope.breadModel=null;
		},function(response){
			$scope.doFade=false;
			$scope.errorMsg=response;
			errorTimeout();
		});
	}
	
	$scope.edit=function(model)
	{
		$scope.breadModel=angular.copy(model);
	}
	
	$scope.delete=function(model){
		var ans=confirm("Are you sure you want to delete this item?");
		if(ans)
		{
			BreadService.delete(model,function(){
				fetch();
			},function(response){
				$scope.doFade=false;
				$scope.errorMsg=response;
				errorTimeout();
			});
		}
		
	}
	
	$scope.listSize=function(){
		return $scope.breadList.length;
	}
	
	function fetch(){
		BreadService.listAll(function(response){
			$scope.breadList=response;
		});
	}
	
	function errorTimeout(){
		$timeout(function(){
		      $scope.doFade = true;
		      $scope.errorMsg=null;
		    }, 2500);
	}
	
	fetch();

});