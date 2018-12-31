app.directive("numberInput",function(){
	return{
		restrict:'A',
		link:function link(scope, element, attrs){
			
			//id attribute is vital since it will determine the next input text to focus on enter key
			
			element.on('focus',function(){
				this.select();
			});
			
			element.on("keydown", (function(e) {
							var valid = false;
				
							valid |= (e.keyCode >= 48 && e.keyCode <= 57)
							valid |= (e.keyCode >= 96 && e.keyCode <= 105)
							valid |= (e.keyCode>=37 && e.keyCode<=40)
							valid |=e.keyCode===8;
							
							if (!valid)
								e.preventDefault();
				
							if (e.keyCode === 13) {
								var id = $(this).attr("id");
								if (id === undefined)
									return;
								var spl = id.split("_");
								var prefix = spl[0] + "_" + spl[1] + "_";
								var index = parseInt(spl[2]);
				
								$("#" + prefix + (++index)).focus();
							}
				
						}));
			
			element.on("blur", function(e) {
				
	
				var val = element.val();
				if (val === '')
					element.val(0);
				
				element.val(replaceNumberWithCommas(element.val()));
				
				function replaceNumberWithCommas(yourNumber) {
				    //Seperates the components of the number
				    var components = yourNumber.toString().split(".");
				    //Comma-fies the first part
				    components [0] = components [0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
				    //Combines the two sections
				    return components.join(".");
				}
	
			});
			
			
			
		}
	}
})