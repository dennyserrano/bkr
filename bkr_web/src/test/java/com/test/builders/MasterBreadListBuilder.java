package com.test.builders;

import org.bkr.models.MasterBreadList;
import org.bkr.models.TemplateDetail;

public class MasterBreadListBuilder {

	public MasterBreadList create(Long id,String breadName,Long price)
	{
		return new MasterBreadList(breadName, price);
	}
	
}