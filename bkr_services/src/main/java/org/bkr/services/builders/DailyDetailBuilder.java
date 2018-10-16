package org.bkr.services.builders;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.DDetail;

public class DailyDetailBuilder{

	private Convertable<DailyDetail, DDetail> basicConverter;
	public DailyDetailBuilder(Convertable<DailyDetail, DDetail> converter)
	{
		basicConverter=converter;
	}
	
	
	public DailyDetailBuilder setHeader(DailyHeader head)
	{
		return this;
	}
	
	public DailyDetailBuilder setDetail(DDetail detail)
	{
		return this;
	}
	
	public DailyDetail build()
	{
		return null;
	}
	
}
