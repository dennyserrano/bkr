package org.bkr.services.factories;

import java.util.ArrayList;
import java.util.HashSet;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.TemplateDetail;
import org.bkr.services.builders.DDetailBuilder;
import org.bkr.services.builders.DailyDetailBuilder;
import org.bkr.services.conversions.BreadConvert;
import org.bkr.services.conversions.DailyDetailConvert;
import org.bkr.services.conversions.DailyHeaderConvert;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.services.factories.exc.DependencyException;
import org.bkr.web.DDetail;
import org.bkr.web.DHeader;

public class DailyHeaderFactory {

	private static Convertable<DailyHeader, DHeader> dailyHeaderConverter=new DailyHeaderConvert();
	private static Convertable<DailyDetail, DDetail> dailyDetailConverter=new DailyDetailConvert();
	
	public static DailyHeader generate(DHeader dh) throws DependencyException
	{
		DailyHeader dailyHeader= dailyHeaderConverter.trevnoc(dh);
		dailyHeader.setDailyDetailses(new HashSet<>());
		DailyDetailBuilder dailyDetailBuilder= new DailyDetailBuilder(dailyDetailConverter);
		ArrayList<DDetail> al=new ArrayList<>(dh.getAmList());
		al.addAll(dh.getPmList());
		
		if(al.size()!=0)
			for(DDetail detail:al)
			{
				DailyDetail dailyDetail=dailyDetailBuilder.setDetail(detail).setHeader(dailyHeader).build();
				
				if(detail.getTemplateDetail()==null)
					throw new DependencyException("No Template Specified");
					
				if(detail.getTemplateDetail().getMasterBreadId()==0)
					throw new DependencyException(String.format("detail id[%s] bread id should not be 0 at this point", detail.getId()));
				
				dailyHeader.getDailyDetailses().add(dailyDetail);
			}
		
		return dailyHeader;
	}
	
	
	
}
