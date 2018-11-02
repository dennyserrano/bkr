app.controller("dailyDetailsCtrl",function($timeout,$scope){
	$timeout(function(){
		$( "#tabs" ).tabs();
	});
	
	$scope.amList=
	[
		{
			id:1,
			dailyHeaderId:1,
			breadName:"Pandesal",
			price:1.00,
			beginningInv:0,
			production:0,
			endingInv:0,
			tgafs:0,
			sales:0,
			amount:0
		},
		{
			id:2,
			dailyHeaderId:1,
			breadName:"Monay",
			price:5.00,
			beginningInv:0,
			production:0,
			endingInv:0,
			tgafs:0,
			sales:0,
			amount:0
		}
	]

})