package org.bkr.web.rest;

import java.util.Date;
import java.util.List;

import org.bkr.models.DailyHeader;
import org.bkr.models.MasterBreadList;
import org.bkr.services.factories.DailyHeaderFactory;
import org.bkr.services.factories.MasterBreadListFactory;
import org.bkr.services.service.interfaces.MasterBreadListService;
import org.bkr.web.Bread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masterbreadlist")
public class MasterBreadListController 
{
	@Autowired private MasterBreadListService breadService;
	
	@RequestMapping("/all")
	public List<Bread> all()
	{
		return MasterBreadListFactory.generate(breadService.findAll());
	}
	
	@RequestMapping("/find")
	public Bread get(@RequestParam("y") long id)
	{
		return MasterBreadListFactory.generate(breadService.findById(id));
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Bread save(@RequestBody Bread bread)
	{
		MasterBreadList mbl= MasterBreadListFactory.generate(bread);
		breadService.save(mbl);
		return MasterBreadListFactory.generate(mbl);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void delete(@RequestBody Bread bread)
	{
		MasterBreadList mbl= MasterBreadListFactory.generate(bread);
		breadService.delete(mbl.getId());
	}
	
}
