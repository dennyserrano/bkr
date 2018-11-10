package org.bkr.services.repo;

import org.bkr.models.DailyHeader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyHeaderRepository extends PagingAndSortingRepository<DailyHeader, Long>{

	
}
