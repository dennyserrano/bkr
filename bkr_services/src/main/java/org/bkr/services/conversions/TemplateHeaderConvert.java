package org.bkr.services.conversions;

import org.bkr.models.Template;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.THeader;

public class TemplateHeaderConvert implements Convertable<Template, THeader>{
	

	@Override
	public THeader convert(Template head) {
		THeader t=new THeader();
		t.setName(head.getName());
		t.setId(head.getId());
		t.setActive(head.isActive());
		return t;
	}

	@Override
	public Template trevnoc(THeader head) {
		Template t=new Template();
		t.setName(head.getName());
		t.setId(head.getId());
		t.setActive(head.isActive());
		return t;
	}
	
}
