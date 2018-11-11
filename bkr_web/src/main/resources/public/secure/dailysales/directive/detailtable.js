
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
			
			$(document).ready(function(){

				
//				$(".number").on("blur",function(e){
//					$(this).val(function(index, value) {
////					    return value
////					    .replace(/\D/g, "")
////					    .replace(/\B(?=(\d{3})+(?!\d))/g, ",");
//					    
//						return ReplaceNumberWithCommas(value);
//						
//					  });
//					
//					function ReplaceNumberWithCommas(yourNumber) {
//					    //Seperates the components of the number
//					    var components = yourNumber.toString().split(".");
//					    //Comma-fies the first part
//					    components [0] = components [0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
//					    //Combines the two sections
//					    return components.join(".");
//					}
					
				
				
					$(".number").keyup(function(e){
						if(e.keyCode===13)
						{
						($(".number")[1]).select();
						}
					});
				
				
				});
				
				
			
			
			
		},
		restrict:"E",
		scope:{
			head:"="
		},
		templateUrl:"../../../../secure/dailysales/directive/detailtable.html"
	}
})