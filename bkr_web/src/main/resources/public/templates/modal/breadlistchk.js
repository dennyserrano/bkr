app.directive("breadListCheckList",function(BreadService){

return{
	controller:function($scope){
		$scope.breadList=[];
		
		$scope.isAll=true;
		
		
		
		$scope.selectAll=function()
		{
			$scope.isAll=!$scope.isAll;
			
			if($scope.isAll)
				init();
			else
				{
					while($scope.breads.length!=0)
						$scope.breads.splice(0,1);
				}
					
			
			
		}
		
		function init()
		{
			for(var x=0;x<$scope.breadList.length;x++)
				$scope.breads.push($scope.breadList[x]);
		}
		
		BreadService.listAll(function(response){
			$scope.breadList=response;
			init();
		},function(response){})
		
		
	},
	restrict:"E",
	
	
	scope:{
		breads:"=",
		save:"&"
	},
	templateUrl:'../../../templates/modal/breadlistchk.html'
}


});