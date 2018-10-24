package org.bkr.services.builders;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.conversions.TemplateDetailConvert;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.DDetail;
import org.bkr.web.TDetail;

public class DailyDetailBuilder{

	private Convertable<DailyDetail, DDetail> basicConverter;
	private static final Convertable<TemplateDetail,TDetail> templateDetailConverter=new TemplateDetailConvert();
	
	private DailyHeader head;
	private DDetail detail;
	public DailyDetailBuilder(Convertable<DailyDetail, DDetail> converter)
	{
		basicConverter=converter;
	}
	
	
	public DailyDetailBuilder setHeader(DailyHeader head)
	{
		this.head=head;
		return this;
	}
	
	public DailyDetailBuilder setDetail(DDetail detail)
	{
		this.detail=detail;
		return this;
	}
	
	public DailyDetail build()
	{
		DailyDetail dd=basicConverter.trevnoc(detail);
		TemplateDetailBuilder tdb=new TemplateDetailBuilder(templateDetailConverter);
		dd.setTemplateDetails(
								 tdb.setDetail(detail.getTemplateDetail())
								 .setHead(new Template(detail.getTemplateDetail().getTemplateId()))
								 .build()
								 );
		
		return dd;
	}
	
}
