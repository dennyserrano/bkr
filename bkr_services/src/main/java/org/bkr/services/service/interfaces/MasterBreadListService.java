package org.bkr.services.service.interfaces;

import java.util.List;

import org.bkr.models.MasterBreadList;

public interface MasterBreadListService {

	public MasterBreadList save(MasterBreadList mbl);
	public MasterBreadList findById(Long id);
	public List<MasterBreadList> findAll();
	public void delete(long id);
	
}
