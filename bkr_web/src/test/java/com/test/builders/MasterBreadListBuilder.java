package com.test.builders;

import java.math.BigDecimal;

import org.bkr.models.MasterBreadList;
import org.bkr.models.TemplateDetail;

public class MasterBreadListBuilder {

	public MasterBreadList create(Long id,String breadName,BigDecimal price)
	{
		return new MasterBreadList(breadName, price);
	}
	
}
