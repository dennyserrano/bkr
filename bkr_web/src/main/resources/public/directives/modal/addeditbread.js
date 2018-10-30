app.directive("addEditBread",function(){



return {


	controller:function($scope)
	{
		$scope.cancel=function()
		{
			delete $scope.model;
		}
	},
    restrict: 'E',
    scope:{
    	model:"=",
    	save:"&"
    },
    templateUrl: '../../../directives/modal/addeditbread.html'
  };

});