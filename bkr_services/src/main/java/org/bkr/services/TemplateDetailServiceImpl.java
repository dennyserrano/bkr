package org.bkr.services;

import java.util.Set;

import org.bkr.models.TemplateDetail;
import org.bkr.repo.TemplateDetailRepository;
import org.bkr.services.interfaces.TemplateDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateDetailServiceImpl implements TemplateDetailService {

	@Autowired TemplateDetailRepository tdr;
	
	@Override
	public TemplateDetail save(TemplateDetail td) {
		
		return tdr.save(td);
	}

	@Override
	public Set<TemplateDetail> save(Set<TemplateDetail> s) {
		
		tdr.saveAll(s);
		
		return s;
	}

}
