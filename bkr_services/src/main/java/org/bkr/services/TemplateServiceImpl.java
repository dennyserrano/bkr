package org.bkr.services;

import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.repo.TemplateDetailRepository;
import org.bkr.repo.TemplateRepository;
import org.bkr.services.interfaces.TemplateDetailService;
import org.bkr.services.interfaces.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

	
	@Autowired TemplateRepository tr;
	@Autowired TemplateDetailService tds;
	
	@Override
	public Template save(Template t) {
		
		tr.save(t);
		
		if(t.getTemplateDetails()!=null)
			for(TemplateDetail td: t.getTemplateDetails())
			{
				td.setTemplate(t);
				tds.save(td);
			}
			
//		tds.save(t.getTemplateDetailses());
		return t;
	}

	
	
}
