package org.bkr.services.builders;

import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.TDetail;

public class TemplateDetailBuilder 
{
	private Convertable<TemplateDetail, TDetail> basicConverter;
	private TDetail detail;
	private Template head;
	public TemplateDetailBuilder(Convertable<TemplateDetail, TDetail> converter)
	{
		basicConverter=converter;
	}
	
	public TemplateDetailBuilder setDetail(TDetail detail)
	{
		this.detail=detail;
		return this;
	}
	
	public TemplateDetailBuilder setHead(Template head)
	{
		this.head=head;
		return this;
	}
	
	public TemplateDetail build()
	{
		TemplateDetail td= basicConverter.trevnoc(detail);
		td.setTemplate(head);
		return td;
	}
}
