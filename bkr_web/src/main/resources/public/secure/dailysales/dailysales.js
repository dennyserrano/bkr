app.controller("dailyListCtrl",function($scope,$routeParams,$location,$timeout,DailyHeaderService,LoadingModalService){
	
	$scope.headerList=[];
	$scope.toastUtility={};
	$scope.listSize=function(){
		return $scope.headerList.length;
	};
	
	$scope.delete=function(header){
		
		var ans=confirm("Are you sure you want to delete this record?");
		
		if(ans)
		{
			LoadingModalService.show();
			DailyHeaderService.delete(header,function(response){
				doFetch(function(response){
					$scope.headerList=response;
					$scope.toastUtility.success("Delete Successful");
					LoadingModalService.hide();
				},function(response){
					$scope.toastUtility.fail("An error has occurred while trying to delete this item");
					LoadingModalService.hide();
				})
			},function(response){
				
			})
		}
		
	}
	
	function doFetch(successCall,failCall)
	{
		DailyHeaderService.listAll(successCall,failCall);
	}
	
	LoadingModalService.show();
	doFetch(function(response){
		$scope.headerList=response;
		LoadingModalService.hide();
	},function(response){
		$scope.toastUtility.fail("An error has occurred while trying to fetch daily sales summary");
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