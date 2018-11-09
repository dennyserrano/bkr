app.directive("copyTemp",function(TemplateService){
	
	return{
		controller:function($scope){
			$scope.templateList=[];
			
			TemplateService.listAll(function(response){
				$scope.templateList=response;
				$scope.model=response[0];
			},function(response){})
			
		},
		restrict:"E",
		scope:{
			model:"=",
			save:"&"
		},
		templateUrl:"../../../../secure/templates/modal/copytemp.html"
		
	};
	
})