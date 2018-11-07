app.directive("toast",function($timeout){
	return{
		restrict:"E",
		scope:
		{
			utility:"="
		},
		link:function($scope){
			var utility=$scope.utility;
			$scope.doFade = false;
			
			utility.success=function(message){
				$scope.doFade=false;
				$scope.msg=message;
				$scope.clazz="alert alert-success";
				reset();
			};
			
			utility.fail=function(message){
				$scope.doFade=false;
				$scope.msg=message;
				$scope.clazz="alert alert-danger";
				reset();
			}
			
			function reset()
			{
				$timeout(function(){
				      $scope.doFade = true;
				      $scope.msg=null;
				    }, 2500);
				
			}
		},
		templateUrl:"../../../directives/toast/toast.html"
	}
});