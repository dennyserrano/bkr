package org.bkr.services.builders;

import java.math.BigDecimal;

import org.bkr.models.DailyDetail;
import org.bkr.models.MasterBreadList;
import org.bkr.models.TemplateDetail;
import org.bkr.services.conversions.BreadConvert;
import org.bkr.services.conversions.DailyDetailConvert;
import org.bkr.services.conversions.TemplateDetailConvert;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.Bread;
import org.bkr.web.DDetail;
import org.bkr.web.DHeader;
import org.bkr.web.TDetail;

public class DDetailBuilder {

	private DHeader parent;
	private TemplateDetail templateDetail;
	private Convertable<TemplateDetail, TDetail> converter;
	private static final Convertable<DailyDetail,DDetail> dailyDetailConverter=new DailyDetailConvert();
	private DailyDetail dailyDetail;
	
	public DDetailBuilder(Convertable<TemplateDetail, TDetail> converter) {
		this.converter=converter;
	}
	
	public DDetailBuilder setDetail(DailyDetail dd)
	{
		dailyDetail=dd;
		return this;
	}
	
	public DDetailBuilder setTemplateDetail(TemplateDetail td)
	{
		templateDetail=td;
		return this;
	}
	
	public DDetailBuilder setParent(DHeader p)
	{
		parent=p;
		return this;
	}
	
	public DDetail build()
	{
		DDetail detail = new DDetail();
		
		if(dailyDetail!=null)
			detail=dailyDetailConverter.convert(dailyDetail);
		
		detail.setDailyHeaderId(parent.getId());
		detail.setTemplateDetail(converter.convert(templateDetail));
		
		return detail;
	}
	
	
	
}
