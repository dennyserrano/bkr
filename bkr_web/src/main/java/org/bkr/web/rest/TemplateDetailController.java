package org.bkr.web.rest;

import org.bkr.models.TemplateDetail;
import org.bkr.services.conversions.TemplateDetailConvert;
import org.bkr.services.service.interfaces.TemplateDetailService;
import org.bkr.web.TDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tdetail")
public class TemplateDetailController {

	@Autowired private TemplateDetailService detailService;
	
	private static final TemplateDetailConvert converter=new TemplateDetailConvert();
	
	@RequestMapping(method =RequestMethod.POST, value= "/save")
	public TDetail save(TDetail detail)
	{
		TemplateDetail td= converter.trevnoc(detail);
		
		return converter.convert(detailService.save(td));
	}
	
	@RequestMapping("/find")
	public TDetail get(@RequestParam("y") long id)
	{
		return converter.convert(detailService.findById(id));
	}
	
	
}
