package org.bkr.services.service;

import java.util.List;
import java.util.Set;

import org.bkr.models.TemplateDetail;
import org.bkr.services.repo.MasterBreadListRepository;
import org.bkr.services.repo.TemplateDetailRepository;
import org.bkr.services.service.interfaces.TemplateDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateDetailServiceImpl implements TemplateDetailService {

	@Autowired TemplateDetailRepository tdr;
	@Autowired MasterBreadListRepository mbr;
	
	@Override
	public TemplateDetail save(TemplateDetail td) {
		
		if(td.getPrice()==null)
			td.setPrice(mbr.findById(td.getMasterBreadList().getId()).get().getPrice());
		
		return tdr.save(td);
	}

	@Override
	public Set<TemplateDetail> save(Set<TemplateDetail> s) {
		
		for(TemplateDetail td:s)
			save(td);
		
		return s;
	}

	@Override
	public List<TemplateDetail> findByTemplateId(long templateId) {
		
		return tdr.findIdByTemplateId(templateId);
	}

	@Override
	public TemplateDetail findById(long id) {
		
		return tdr.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		TemplateDetail t= new TemplateDetail();
		t.setId(id);
		tdr.delete(t);
	}

}
