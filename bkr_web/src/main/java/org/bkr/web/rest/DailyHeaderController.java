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
import org.springframework.web.bind.annotation.RequestMethod;
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
		return DHeaderFactory.generateHead(dhs.findAll());
	}

	
	@RequestMapping("/find")
	public DHeader find(@RequestParam("y") long id)
	{
		return DHeaderFactory.generate(dhs.findById(id));
	}
	
	
	@RequestMapping("/createnew")
	public DHeader createNew()
	{
		Template t= templateService.getActive();
		if(t==null)
			return null;
		return DHeaderFactory.createNew(t);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
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
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void delete(@RequestParam("y") long templateId)
	{
		
		dhs.delete(templateId);
		
		
	}
	
}
