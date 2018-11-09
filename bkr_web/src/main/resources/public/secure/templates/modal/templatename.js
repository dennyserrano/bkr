app.directive("templateName",function(){
	
	return{
		restrict:"E",
		scope:{
			model:"=",
			save:"&",
			cancel:"&"
		},
		templateUrl:"../../../../secure/templates/modal/templatename.html"
	}
	
})