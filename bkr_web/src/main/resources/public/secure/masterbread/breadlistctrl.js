app.controller("breadListCtrl",function($scope,BreadService,$timeout){

	$scope.breadList=[];
	
	$scope.toastUtil={};
	$scope.modalSave=function(){
		BreadService.save($scope.breadModel,function(){
			fetch(function(response){
				$scope.breadList=response;
				$scope.toastUtil.success("Save Successful!");
			});
			
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
				fetch(function(response){
					$scope.breadList=response;
					$scope.toastUtil.success("Delete Successful!");
				});
				
				
			},function(response){
				$scope.toastUtil.fail(response);
			});
		}
		
	}
	
	$scope.listSize=function(){
		return $scope.breadList.length;
	}
	
	function fetch(successCall,failCall){
		BreadService.listAll(successCall,failCall);
	}
	
	fetch(function(response){
		$scope.breadList=response;
	},function(response){
		$scope.toastUtility.fail("There was an error while loading data");
	});

});