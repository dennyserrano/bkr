package org.bkr.repo;

import java.util.List;

import org.bkr.models.TemplateDetail;
import org.bkr.models.TemplateDetailsId;
import org.springframework.data.repository.CrudRepository;

public interface TemplateDetailRepository extends CrudRepository<TemplateDetail, TemplateDetailsId>{
	
	List<TemplateDetail> findIdByTemplateId(long templateId);
	
}
