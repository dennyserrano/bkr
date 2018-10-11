package org.bkr.services.interfaces;

import java.util.Set;

import org.bkr.models.TemplateDetail;

public interface TemplateDetailService {

	public TemplateDetail save(TemplateDetail td);
	public Set<TemplateDetail> save(Set<TemplateDetail> s);
}
