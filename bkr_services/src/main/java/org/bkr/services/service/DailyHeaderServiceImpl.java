package org.bkr.services.service;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.services.repo.DailyDetailRepository;
import org.bkr.services.repo.DailyHeaderRepository;
import org.bkr.services.service.interfaces.DailyHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyHeaderServiceImpl implements DailyHeaderService {

	@Autowired DailyHeaderRepository dhr;
	@Autowired DailyDetailRepository ddr;
	
	@Override
	public DailyHeader save(DailyHeader dh) {
		
		dhr.save(dh);
		
		if(dh.getDailyDetailses()!=null)
			for(DailyDetail dd:dh.getDailyDetailses())
			{
				dd.setDailyHeader(dh);
				ddr.save(dd);
			}
		return dh;
	}

}
