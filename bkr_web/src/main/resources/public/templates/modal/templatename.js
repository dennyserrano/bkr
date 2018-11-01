app.directive("templateName",function(){
	
	return{
		restrict:"E",
		scope:{
			model:"=",
			save:"&",
			cancel:"&"
		},
		templateUrl:"../../../templates/modal/templatename.html"
	}
	
})