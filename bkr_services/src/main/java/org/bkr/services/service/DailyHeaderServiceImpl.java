package org.bkr.services.service;

import java.util.ArrayList;
import java.util.List;

import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;
import org.bkr.services.repo.DailyDetailRepository;
import org.bkr.services.repo.DailyHeaderRepository;
import org.bkr.services.service.interfaces.DailyHeaderService;
import org.bkr.services.utilities.DailyHeaderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DailyHeaderServiceImpl implements DailyHeaderService {

	@Autowired DailyHeaderRepository dhr;
	@Autowired DailyDetailRepository ddr;
	
	@Override
	@Transactional
	public DailyHeader save(DailyHeader dh) {
		
		DailyHeaderHelper.align(dh);
		
		dhr.save(dh);
		
		if(dh.getDailyDetailses()!=null)
			for(DailyDetail dd:dh.getDailyDetailses())
			{
				dd.setDailyHeader(dh);
				ddr.save(dd);
			}
		return dh;
	}

	@Override
	public List<DailyHeader> findAll() {
		
		ArrayList<DailyHeader> al=new ArrayList<>();
		
		dhr.findAll(Sort.by("date").descending()).forEach(al::add);
		
		return al;
	}

	@Override
	public DailyHeader findById(long id) {
		return dhr.findById(id).get();
	}

	@Override
	public void delete(long id) {
		DailyHeader dh=findById(id);
		
		if(dh.getDailyDetailses()!=null)
			for(DailyDetail dd:dh.getDailyDetailses())	
				ddr.delete(dd);
			
		dhr.delete(dh);
	}

	
}
