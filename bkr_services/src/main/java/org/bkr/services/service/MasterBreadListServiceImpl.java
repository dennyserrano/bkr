package org.bkr.services.service;

import java.util.ArrayList;
import java.util.List;

import org.bkr.models.MasterBreadList;
import org.bkr.services.repo.MasterBreadListRepository;
import org.bkr.services.service.interfaces.MasterBreadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterBreadListServiceImpl implements MasterBreadListService {

	
	@Autowired MasterBreadListRepository mblr;
	@Autowired TemplateDetailServiceImpl templateDetailService;
	
	@Override
	public MasterBreadList save(MasterBreadList mbl) {
		
//		if(mbl.getId()!=null)
//		{
//			long breadCount=templateDetailService.countByBreadId(mbl.getId());
//			if(breadCount>0)
//				throw new RuntimeException("Unable to make changes to this item because it has been assigned to a template!");
//		}
		
		return mblr.save(mbl);
	}

	@Override
	public MasterBreadList findById(Long id) {
		
		return mblr.findById(id).get();
	}

	@Override
	public List<MasterBreadList> findAll() {
		ArrayList<MasterBreadList> al=new ArrayList<>();
		mblr.findAll().forEach(al::add);
		return al;
	}

	@Override
	public void delete(long id) {
		MasterBreadList mbl=new MasterBreadList(id);
		
		if(mbl.getId()!=null)
		{
			long breadCount=templateDetailService.countByBreadId(mbl.getId());
			if(breadCount>0)
				throw new RuntimeException("Unable to delete this item because it has been assigned to a template!");
		}
		
		mblr.delete(mbl);
	}

}
