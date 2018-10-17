package org.bkr.services.factories;

import java.util.HashSet;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.TemplateDetail;
import org.bkr.models.TemplateDetailsId;
import org.bkr.services.builders.DDetailBuilder;
import org.bkr.services.conversions.BreadConvert;
import org.bkr.services.conversions.DailyDetailConvert;
import org.bkr.services.conversions.DailyHeaderConvert;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.DDetail;
import org.bkr.web.DHeader;

public class DailyHeaderFactory {

	private static Convertable<DailyHeader, DHeader> dailyHeaderConverter=new DailyHeaderConvert();
	private static Convertable<DailyDetail, DDetail> dailyDetailConverter=new DailyDetailConvert();
	
	public static DailyHeader generate(DHeader dh)
	{
		DailyHeader dailyHeader= dailyHeaderConverter.trevnoc(dh);
		dailyHeader.setDailyDetailses(new HashSet<>());
		if(dh.getDetails()!=null && dh.getDetails().size()!=0)
			for(DDetail detail:dh.getDetails())
			{
				DailyDetail dailyDetail=dailyDetailConverter.trevnoc(detail);
				dailyDetail.setDailyHeader(dailyHeader);
				
				if(detail.getBread().getId()==null)
					throw new RuntimeException(String.format("detail id[%s] bread id should not be null at this point", detail.getId()));
					
				dailyDetail.setTemplateDetails(new TemplateDetail(new TemplateDetailsId(detail.getTemplateId(), detail.getBread().getId())));
				dailyHeader.getDailyDetailses().add(dailyDetail);
			}
		
		return dailyHeader;
	}
	
	
	
}
