package org.bkr.web.rest;

import java.util.Date;
import java.util.List;

import org.bkr.models.DailyHeader;
import org.bkr.services.factories.DHeaderFactory;
import org.bkr.services.factories.DailyHeaderFactory;
import org.bkr.services.service.interfaces.DailyHeaderService;
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
	
	@RequestMapping("/save")
	public DHeader save(@RequestBody DHeader dhead)
	{
		
		DailyHeader dh= DailyHeaderFactory.generate(dhead);
		
		if(dh.getDate()==null)
			dh.setDate(new Date());
		
		dhs.save(dh);
		return DHeaderFactory.generate(dh);
	}
	
}
