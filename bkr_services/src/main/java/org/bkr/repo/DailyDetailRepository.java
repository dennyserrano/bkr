package org.bkr.repo;

import java.util.List;

import org.bkr.models.DailyDetail;
import org.springframework.data.repository.CrudRepository;

public interface DailyDetailRepository extends CrudRepository<DailyDetail, Long> {
	
	List<DailyDetail> findDailyHeaderById(long id);
	
}
