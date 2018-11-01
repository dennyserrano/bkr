app.directive("copyTemp",function(){
	
	return{
		controller:function($scope){
			$scope.templateList=[
				{
					id:1,
					name:"t1"
				},
				{
					id:2,
					name:"t2"
				}
			];
		},
		restrict:"E",
		scope:{
			model:"=",
			save:"&"
		},
		templateUrl:"../../../templates/modal/copytemp.html"
		
	};
	
})