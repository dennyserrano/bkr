app.controller("breadListCtrl",function($scope,BreadService,$timeout){

	$scope.breadList=[];
	
	$scope.toastUtil={};
	$scope.modalSave=function(){
		BreadService.save($scope.breadModel,function(){
			fetch();
			$scope.toastUtil.success("Save Successful!");
			$scope.breadModel=null;
		},function(response){
			$scope.toastUtil.fail(response);
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
				$scope.toastUtil.success("Delete Successful!");
				fetch();
			},function(response){
				$scope.toastUtil.fail(response);
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
	
	fetch();

});