package org.bkr.web.rest;

import java.util.Date;
import java.util.List;

import org.bkr.models.DailyHeader;
import org.bkr.models.Template;
import org.bkr.services.factories.DHeaderFactory;
import org.bkr.services.factories.DailyHeaderFactory;
import org.bkr.services.factories.exc.DependencyException;
import org.bkr.services.service.interfaces.DailyHeaderService;
import org.bkr.services.service.interfaces.TemplateService;
import org.bkr.web.DHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dhead")
public class DailyHeaderController {

	@Autowired private DailyHeaderService dhs;
	@Autowired private TemplateService templateService;
	
	@RequestMapping("/all")
	public List<DHeader> all()
	{
		return DHeaderFactory.generate(dhs.findAll());
	}
	
	@RequestMapping("/find")
	public DHeader find(@RequestParam("y") long id)
	{
		return DHeaderFactory.generate(dhs.findById(id));
	}
	
	
	@RequestMapping("/createnew")
	public DHeader createNew(@RequestParam("y") long templateId)
	{
		Template t= templateService.findById(templateId);
		return DHeaderFactory.createNew(t);
	}
	
	@RequestMapping("/save")
	public DHeader save(@RequestBody DHeader dhead)
	{
		
		DailyHeader dh=null;
		try {
			dh = DailyHeaderFactory.generate(dhead);
		} catch (DependencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dh.getDate()==null)
			dh.setDate(new Date());
		
		dhs.save(dh);
		return DHeaderFactory.generate(dh);
	}
	
}
