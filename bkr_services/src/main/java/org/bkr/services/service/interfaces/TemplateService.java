package org.bkr.services.service.interfaces;

import org.bkr.models.Template;

public interface TemplateService {

	public Template save(Template t);
	public Template findById(long id);
	public Template fetchFullById(long id);
}
