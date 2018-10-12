package org.bkr.services.interfaces;

import org.bkr.models.MasterBreadList;

public interface MasterBreadListService {

	public MasterBreadList save(MasterBreadList mbl);
	public MasterBreadList findById(Long id);
	
}
