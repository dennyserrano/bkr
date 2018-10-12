package org.bkr.services;

import org.bkr.models.MasterBreadList;
import org.bkr.repo.MasterBreadListRepository;
import org.bkr.services.interfaces.MasterBreadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterBreadListServiceImpl implements MasterBreadListService {

	
	@Autowired MasterBreadListRepository mblr;
	
	@Override
	public MasterBreadList save(MasterBreadList mbl) {
		
		return mblr.save(mbl);
	}

	@Override
	public MasterBreadList findById(Long id) {
		
		return mblr.findById(id).get();
	}

}
