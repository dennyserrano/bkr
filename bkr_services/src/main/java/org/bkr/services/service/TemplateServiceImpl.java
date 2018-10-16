package org.bkr.services.service;

import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.repo.TemplateRepository;
import org.bkr.services.service.interfaces.TemplateDetailService;
import org.bkr.services.service.interfaces.TemplateService;
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

	@Override
	public Template findById(long id) {
		
		return tr.findById(id).get();
	}

	@Override
	public Template fetchFullById(long id) {
		// TODO Auto-generated method stub
		return tr.fetchFullById(id);
	}

	
	
}
