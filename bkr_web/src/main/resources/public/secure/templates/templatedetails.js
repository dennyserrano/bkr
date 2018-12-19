app.controller("templateDetailCtrl",function($scope,$routeParams,$timeout,$location,TemplateService,TemplateDetailService,LoadingModalService){
	
	$scope.toastUtility={};
	$scope.template=
	{
		id:$routeParams.templateId==0?null:$routeParams.templateId	,
		name:"t1",
		details:[]
	};
	
	$scope.breads=[];
	
	$scope.templateSelectSave=function()
	{
		LoadingModalService.show();
		TemplateService.get($scope.selectedTemplate.id,function(response){
			$scope.template.details=angular.fromJson(angular.toJson(response.details));
			indexed($scope.template.details);
			LoadingModalService.hide();
		},function(response){
			$scope.toastUtility.fail(response);
		});
	}
	
	$scope.templateNameCancel=function()
	{
		$location.path("/templates/3");
	}
	
	$scope.selectedBreadSave=function()
	{
		selectList=toTDetails(angular.fromJson(angular.toJson($scope.breads)),$scope.template.id);
		console.log(selectList);
		for(var i=0;i<selectList.length;i++)
		{
			var item= findItem($scope.template.details,selectList[i].masterBreadId);
			if(item!==null)
				{
					$scope.toastUtility.fail("The item "+item.breadName+" is already in the list");
					return;
				}
		}
		
		for(i=0;i<selectList.length;i++)
		{
			
			$scope.template.details.push(selectList[i]);
		}
		
		indexed($scope.template.details);
		
	}
	
	$scope.listSize=function()
	{
		return $scope.template.details.length;
	}
	
	$scope.delete=function(detail)
	{
		$scope.template.details.splice(detail.index,1);
		indexed($scope.template.details);
	}
	
	$scope.save=function()
	{
		TemplateService.save($scope.template,function(response){
			$location.path("/templates/0");
		},function(response){
			$scope.toastUtility.fail(response);
		});
		
	}
	$scope.setActive=function()
	{
		TemplateService.activate($scope.template.id,function(response){
			$scope.template.active=true;
			$scope.toastUtility.success("Template is now set to active");
		},function(response){
			$scope.toastUtility.fail("There was an error while trying to activate this template")
		})
	}
	
	
	if($scope.template.id===null)
	{
		$scope.template.name=prompt("Enter Template Name");
		
		if($scope.template.name=="" || $scope.template.name==null)
			$scope.templateNameCancel();
	}else
	{
		TemplateService.getWReadOnly($scope.template.id,function(response){
			$scope.template=response;
			indexed($scope.template.details);
		},function(response){
			$scope.toastUtility.fail(response);
		});
	}
	
	function toTDetail(item,templateId)
	{
			item.masterBreadId=item.id;
			delete item.id;
			item.templateId=templateId;
			return item;
	}
	
	function toTDetails(list,templateId)
	{
		var tempList=[];
		for(i=0;i<list.length;i++)
			tempList.push(toTDetail(list[i],templateId));
		
		return tempList;
	}
	
	function indexed(list)
	{
		for(i=0;i<list.length;i++)
			list[i].index=i;
	}
	
	function findItem(list,id)
	{
		for(i=0;i<list.length;i++)
			if(list[i].masterBreadId===id)
				return list[i]
		
		return null;
	}
	
});