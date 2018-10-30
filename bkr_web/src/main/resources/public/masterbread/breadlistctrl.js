app.controller("breadListCtrl",function($scope){

	$scope.test=function(){
		console.log($scope.breadModel);
	}
	
	$scope.modalSave=function(){
		console.log("save invoked");
	}
	
	$scope.breadList=[
		{
			breadName:"Pandesal",
			price:"1.00"
		},
		{
			breadName:"Monay",
			price:"5.00"
		},
		{
			breadName:"Cheese Roll",
			price:"6.00"
		},
		]

});