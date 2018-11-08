package org.bkr.web.rest;

import java.util.List;

import org.bkr.models.Template;
import org.bkr.services.factories.TemplateFactory;
import org.bkr.services.service.interfaces.DailyDetailService;
import org.bkr.services.service.interfaces.DailyHeaderService;
import org.bkr.services.service.interfaces.TemplateService;
import org.bkr.web.THeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController {

	@Autowired private TemplateService templateService;
	@Autowired private DailyDetailService dailyDetailService;
	
	@RequestMapping("/all")
	public List<THeader> all()
	{
		return TemplateFactory.generateHead(templateService.findAll());
	}
	
	@RequestMapping("/find")
	public THeader get(@RequestParam("y") long id)
	{
		return TemplateFactory.generate(templateService.findById(id));
	}
	@RequestMapping("/findwro")
	public THeader getWReadOnly(@RequestParam("y") long id)
	{
		THeader t= get(id);
		if(dailyDetailService.countByTemplateId(id)>0)
			t.setReadonly(true);
		
		return t;
	}
	
	@RequestMapping(value= "/save",method=RequestMethod.POST)
	public THeader save(@RequestBody THeader template)
	{
		Template t=TemplateFactory.generate(template);
		templateService.save(t);
		return TemplateFactory.generate(t);
	}
	
	@RequestMapping(value= "/delete",method=RequestMethod.DELETE)
	public void delete(@RequestParam("y") long id)
	{
		templateService.delete(id);
	}
	
	@RequestMapping(value= "/activate")
	public void activate(@RequestParam("y") long id)
	{
		templateService.setActive(id);
	}
	
}
