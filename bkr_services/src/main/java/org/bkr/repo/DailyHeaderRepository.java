package org.bkr.repo;

import org.bkr.models.DailyHeader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyHeaderRepository extends CrudRepository<DailyHeader, Long>{

}
