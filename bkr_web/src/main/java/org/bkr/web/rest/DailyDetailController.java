package org.bkr.web.rest;

import org.bkr.services.service.interfaces.DailyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ddetail")
public class DailyDetailController {

	@Autowired DailyDetailService dds;
	
	@RequestMapping("countByBreadId")
	public long count(@RequestParam("y") long id)
	{
		return dds.countByBreadId(id);
	}
	
}
