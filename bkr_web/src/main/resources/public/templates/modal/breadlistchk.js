app.directive("breadListCheckList",function(){

return{
	controller:function($scope){
		$scope.breadList=[
			{
				id:1,
				breadName:"pandesal",
				price:100
			},
			{
				id:2,
				breadName:"monay",
				price:200
			},
			{
				id:3,
				breadName:"hopia",
				price:200
			}
			
		];
		
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
		
		init();
	},
	restrict:"E",
	
	
	scope:{
		breads:"=",
		save:"&"
	},
	templateUrl:'../../../templates/modal/breadlistchk.html'
}


});