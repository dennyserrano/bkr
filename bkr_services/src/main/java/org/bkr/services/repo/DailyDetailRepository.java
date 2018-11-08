package org.bkr.services.repo;

import java.util.List;

import org.bkr.models.DailyDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DailyDetailRepository extends CrudRepository<DailyDetail, Long> {
	
	List<DailyDetail> findDailyHeaderById(long id);
	@Query("select count(e) from DailyDetail e where e.templateDetail.masterBreadList.id = ?1")
	long countBreadId(long masterBreadId);
	@Query("select count(e) from DailyDetail e where e.templateDetail.template.id = ?1")
	long countTemplateId(long templateId);
}
