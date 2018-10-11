package com.test.builders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.bkr.models.MasterBreadList;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.models.TemplateDetailsId;

public class TemplateBuilder {

	private Template t;
	private Set<TemplateDetail> al=new HashSet<>();
	
	public TemplateBuilder create(String name)
	{
		t=new Template(name,new HashSet<>());
		return this;
	}
	
	public TemplateBuilder addDetail(TemplateDetailsId id,MasterBreadList mbl)
	{
		al.add(new TemplateDetail(id,mbl,t));
		return this;
	}
	
	public Template build()
	{
		t.setTemplateDetails(al);
		return t;
	}
	
}
