package org.bkr.services.factories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bkr.constants.DailyHeaderCategories;
import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.builders.DDetailBuilder;
import org.bkr.services.conversions.BreadConvert;
import org.bkr.services.conversions.DailyDetailConvert;
import org.bkr.services.conversions.DailyHeaderConvert;
import org.bkr.services.conversions.TemplateDetailConvert;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.DDetail;
import org.bkr.web.DHeader;
import org.bkr.web.TDetail;

public class DHeaderFactory {

	private static Convertable<DailyHeader, DHeader> dailyHeaderConverter=new DailyHeaderConvert();
	private static Convertable<TemplateDetail,TDetail> templateDetailConverter=new TemplateDetailConvert();
	public static DHeader createNew(Template template)
	{
		
		DHeader head=new DHeader(null, new Date());
		
		DDetailBuilder detailBuilder=new DDetailBuilder(templateDetailConverter);
		
		if(template.getTemplateDetails()!=null && template.getTemplateDetails().size()!=0)
			for(TemplateDetail td:template.getTemplateDetails())
			{
				
				DDetail am=detailBuilder.setTemplateDetail(td).setParent(head).build();
				am.setCategory(DailyHeaderCategories.AM);
				DDetail pm=detailBuilder.setTemplateDetail(td).setParent(head).build();
				pm.setCategory(DailyHeaderCategories.PM);
				head.getAmList().add(am);
				head.getPmList().add(pm);
			}
		
		
		return head;
	}
	
	public static DHeader generate(DailyHeader dh)
	{
		DHeader e=dailyHeaderConverter.convert(dh);
		DDetailBuilder detailBuilder=new DDetailBuilder(templateDetailConverter);
		
		if(dh.getDailyDetailses()!=null && dh.getDailyDetailses().size()!=0)
			for(DailyDetail d:dh.getDailyDetailses())
			{
				DDetail ddetail=detailBuilder.setDetail(d).setParent(e).setTemplateDetail(d.getTemplateDetail()).build();
				if(ddetail.getCategory().equals(DailyHeaderCategories.AM))
					e.getAmList().add(ddetail);
				else
					e.getPmList().add(ddetail);
			}
				
		return e;	
	}
	
	public static List<DHeader> generate(List<DailyHeader> list)
	{
		ArrayList<DHeader> al=new ArrayList<>();
		list.forEach(i->{al.add(generate(i));});
		
		return al;
	}
	
	public static List<DHeader> generateHead(List<DailyHeader> list)
	{
		ArrayList<DHeader> al=new ArrayList<>();
		list.forEach(i->{al.add(dailyHeaderConverter.convert(i));});
		
		return al;
	}
	
}
