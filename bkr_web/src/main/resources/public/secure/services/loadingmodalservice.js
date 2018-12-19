app.service("LoadingModalService",function(){
	
	this.show=function(){
		$('body').waitMe({

			effect : 'roundBounce',

			bg : 'rgba(255,255,255,0.7)'

			});
	}
	
	this.hide=function(){
		$('body').waitMe('hide');
	}
	
})