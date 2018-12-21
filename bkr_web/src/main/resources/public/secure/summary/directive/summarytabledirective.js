app.directive("summaryTable",function(){
	
	return{
		restrict:"E",
		controller:function($scope){
			
			$scope.getTotal=function(){
				
				return sum('total');
				
			}
			
			$scope.getTotalExpenses=function(){
				return sum('expenses');
			}
			
			$scope.getTotalGrandTotal=function(){
				return sum('grandTotal');
			}
			
			$scope.getTotalRemittance=function()
			{
				return sum('remittance');
			}
			
			$scope.getTotalDifference=function(){
				return sum('difference');
			}
			
			$scope.getTotalAmExpenses=function(){
				return sum('amExpenses');
			}
			
			$scope.getTotalPmExpenses=function(){
				return sum('pmExpenses');
			}
			
			$scope.getTotalAmRemittance=function(){
				return sum('amRemittance');
			}
			
			$scope.getTotalPmRemittance=function(){
				return sum('pmRemittance');
			}
			
			$scope.listSize=function(){
				return $scope.data.length;
			}
			
			function sum(field)
			{
				var sum=0;
				for(var x=0;x<$scope.data.length;x++)
				{
					sum+=$scope.data[x][field];
				}
				
				return sum;
			}
			
			
			
		},
		scope:{
			data:"="
		},
		templateUrl:"../../../../secure/summary/directive/summarytable.html"
	};
})
