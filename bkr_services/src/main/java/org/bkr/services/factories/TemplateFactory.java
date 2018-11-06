package org.bkr.services.factories;

import java.util.ArrayList;
import java.util.List;

import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.conversions.TemplateDetailConvert;
import org.bkr.services.conversions.TemplateHeaderConvert;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.TDetail;
import org.bkr.web.THeader;

public class TemplateFactory {

	
	private static Convertable<Template, THeader> templateConverter=new TemplateHeaderConvert();
	private static Convertable<TemplateDetail,TDetail> templateDetailConverter=new TemplateDetailConvert();
	
	public static Template generate(THeader header)
	{
		Template t=templateConverter.trevnoc(header);
		
		if(header.getDetails()!=null && header.getDetails().size()!=0)
		for(TDetail tdetail:header.getDetails())
		{
			TemplateDetail td=templateDetailConverter.trevnoc(tdetail);
			t.getTemplateDetails().add(td);
		}
		
		return t;
	}
	
	public static THeader generate(Template header)
	{
		
		THeader t=templateConverter.convert(header);
		
		if(header.getTemplateDetails()!=null && header.getTemplateDetails().size()!=0)
			for(TemplateDetail td:header.getTemplateDetails())
			{
				TDetail tdetail=templateDetailConverter.convert(td);
				t.getDetails().add(tdetail);
			}
		
		return t;
	}
	
	public static List<THeader> generateHead(List<Template> header)
	{
		ArrayList<THeader> al=new ArrayList<>();
		header.forEach(t->{
			 al.add(templateConverter.convert(t));
		});
		return al;
	}
	
	public static List<THeader> generate(List<Template> header)
	{
		ArrayList<THeader> al=new ArrayList<>();
		header.forEach(t->{
			 al.add(generate(t));
		});
		
		return al;
	}
	
}
