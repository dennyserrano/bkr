package org.bkr.services.repo;

import java.util.List;

import org.bkr.models.TemplateDetail;
import org.springframework.data.repository.CrudRepository;

public interface TemplateDetailRepository extends CrudRepository<TemplateDetail, Long>{
	
	List<TemplateDetail> findIdByTemplateId(long templateId);
	
}
