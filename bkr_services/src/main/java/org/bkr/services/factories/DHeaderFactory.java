package org.bkr.services.factories;

import java.util.Date;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.builders.DDetailBuilder;
import org.bkr.services.conversions.BreadConvert;
import org.bkr.services.conversions.DailyDetailConvert;
import org.bkr.services.conversions.DailyHeaderConvert;
import org.bkr.services.conversions.TemplateDetailConvert;
import org.bkr.web.DDetail;
import org.bkr.web.DHeader;
import org.bkr.web.TDetail;

public class DHeaderFactory {

	
	
	public static DHeader createNew(Template template)
	{
		
		DHeader head=new DHeader(null, new Date());
		DDetailBuilder detailBuilder=new DDetailBuilder(new BreadConvert());
		
		if(template.getTemplateDetails()!=null && template.getTemplateDetails().size()!=0)
			for(TemplateDetail td:template.getTemplateDetails())
			{
				
				DDetail am=detailBuilder.setTemplateDetail(td).setParent(head).build();
				am.setCategory("AM");
				DDetail pm=detailBuilder.setTemplateDetail(td).setParent(head).build();
				pm.setCategory("PM");
				head.getDetails().add(am);
				head.getDetails().add(pm);
			}
		
		
		return head;
	}
	
	
	
}
