package org.bkr.services.service.interfaces;

import java.util.List;
import java.util.Set;

import org.bkr.models.TemplateDetail;

public interface TemplateDetailService {

	public TemplateDetail save(TemplateDetail td);
	public Set<TemplateDetail> save(Set<TemplateDetail> s);
	public List<TemplateDetail> findByTemplateId(long templateId);
}
