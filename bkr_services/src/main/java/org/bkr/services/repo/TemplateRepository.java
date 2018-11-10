package org.bkr.services.repo;

import java.util.List;

import org.bkr.models.Template;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TemplateRepository extends CrudRepository<Template, Long>{
	
	@Query("SELECT t FROM Template t "
			+ "JOIN FETCH t.templateDetails td "
			+ "JOIN FETCH td.masterBreadList "
			+ "WHERE t.id=?1")
	public Template fetchFullById(long id);
	
	@Query("SELECT t FROM Template t "
			+ "JOIN FETCH t.templateDetails td "
			+ "JOIN FETCH td.masterBreadList "
			+ "WHERE t.active=?1")
	public List<Template> findByActive(boolean val);
	
	
}
