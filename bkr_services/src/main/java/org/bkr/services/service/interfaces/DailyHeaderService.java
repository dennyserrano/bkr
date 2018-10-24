package org.bkr.services.service.interfaces;

import java.util.List;

import org.bkr.models.DailyHeader;

public interface DailyHeaderService {
	public DailyHeader save(DailyHeader dh);
	public List<DailyHeader> findAll();
	public DailyHeader findById(long id);
}
