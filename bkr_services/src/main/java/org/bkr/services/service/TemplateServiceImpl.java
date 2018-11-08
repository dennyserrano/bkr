package org.bkr.services.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.repo.TemplateRepository;
import org.bkr.services.service.interfaces.DailyDetailService;
import org.bkr.services.service.interfaces.DailyHeaderService;
import org.bkr.services.service.interfaces.TemplateDetailService;
import org.bkr.services.service.interfaces.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

	
	@Autowired TemplateRepository tr;
	@Autowired TemplateDetailService tds;
	@Autowired DailyDetailService dds;
	
	@Override
	public Template save(Template t) {
		
		
		if(t.getId()!=null)
			if(dds.countByTemplateId(t.getId())>0)
				throw new RuntimeException("Cannot edit template because it is being used in one of the daily sales reports");
		
		List<Template> l= tr.findByActive(true);
		for(Template temp:l)
		{
			temp.setActive(false);
			tr.save(temp);
		}
		t.setActive(true);
		tr.save(t);
		
		HashMap<Long, TemplateDetail> nonDeletionMap=nonDeletionMap(new ArrayList<>(t.getTemplateDetails()));
		
		if(t.getTemplateDetails()!=null)
			for(TemplateDetail td: t.getTemplateDetails())
			{
				if(nonDeletionMap.get(td.getId())==null)
					tds.delete(td.getId());
				else {
					td.setTemplate(t);
					tds.save(td);
				}
				
			}
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

	@Override
	public List<Template> findAll() {
		
		ArrayList<Template> al=new ArrayList<>();
		
		tr.findAll().forEach(al::add);
		
		return al;
	}

	@Override
	public void delete(long id) {
		
		if(dds.countByTemplateId(id)>0)
			throw new RuntimeException("Cannot delete this template because it is being used in one of the daily sales reports");
		
		
		Template t=new Template(id);
		tr.delete(t);
	}

	@Override
	public void setActive(long id) {
		List<Template> l= tr.findByActive(true);
		for(Template t:l)
		{
			t.setActive(false);
			tr.save(t);
		}
		
		Template t=tr.findById(id).get();
		t.setActive(true);
		tr.save(t);
		
	}

	
	private HashMap<Long,TemplateDetail> nonDeletionMap(List<TemplateDetail> list)
	{
		HashMap<Long,TemplateDetail> hm=new HashMap<>();
		for(TemplateDetail td:list)
			hm.put(td.getId(), td);
		
		return hm;
	}
	
	
}
