package org.bkr.services.repo;

import java.util.List;

import org.bkr.models.TemplateDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TemplateDetailRepository extends CrudRepository<TemplateDetail, Long>{
	
	List<TemplateDetail> findIdByTemplateId(long templateId);
	@Query("select count(e) from TemplateDetail e where e.masterBreadList.id = ?1")
	long countByBreadId(long id);
	@Query("select count(e) from TemplateDetail e where e.masterBreadList.id = ?1 and e.template.id=?2")
	long countByTemplateIdAndBreadId(long breadId,long templateId);
}
