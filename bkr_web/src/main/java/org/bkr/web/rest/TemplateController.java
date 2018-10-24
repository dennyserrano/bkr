package org.bkr.web.rest;

import java.util.List;

import org.bkr.models.Template;
import org.bkr.services.factories.TemplateFactory;
import org.bkr.services.service.interfaces.TemplateService;
import org.bkr.web.THeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController {

	@Autowired private TemplateService templateService;
	
	@RequestMapping("/all")
	public List<THeader> all()
	{
		return TemplateFactory.generate(templateService.findAll());
	}
	
	@RequestMapping("/find")
	public THeader get(@RequestParam("y") long id)
	{
		return TemplateFactory.generate(templateService.findById(id));
	}
	
	@RequestMapping("/save")
	public THeader save(@RequestBody THeader template)
	{
		Template t=TemplateFactory.generate(template);
		templateService.save(t);
		return TemplateFactory.generate(t);
	}
	
}
