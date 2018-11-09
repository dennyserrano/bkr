
app.directive("detailTable",function(){
	
	return{
		controller:function($scope){
			
			$scope.getTotal=function(){
				return sum($scope.head.list,"amount");
			}
			
			function sum(list,varb)
			{
				var sum=0;
				angular.forEach(list,function(item){
					sum+=item[varb];
				});
				
				return sum;
			}
			
		},
		restrict:"E",
		scope:{
			head:"="
		},
		templateUrl:"../../../../secure/dailysales/directive/detailtable.html"
	}
})