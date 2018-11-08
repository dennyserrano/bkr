package org.bkr.services.service;

import org.bkr.services.repo.DailyDetailRepository;
import org.bkr.services.service.interfaces.DailyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyDetailServiceImpl implements DailyDetailService {

	@Autowired private DailyDetailRepository ddr;
	
	@Override
	public long countByBreadId(long id) {
		
		return ddr.countBreadId(id);
	}

	@Override
	public long countByTemplateId(long id) {
		
		return ddr.countTemplateId(id);
	}

}
