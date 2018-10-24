package org.bkr.services.conversions;

import org.bkr.models.MasterBreadList;
import org.bkr.models.Template;
import org.bkr.models.TemplateDetail;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.TDetail;

public class TemplateDetailConvert implements Convertable<TemplateDetail,TDetail>{

	@Override
	public TDetail convert(TemplateDetail detail) {
		TDetail td=new TDetail();
		td.setMasterBreadId(detail.getMasterBreadList().getId());
		td.setTemplateId(detail.getTemplate().getId());
		td.setPrice(detail.getPrice());
		td.setBreadName(detail.getMasterBreadList().getBreadName());
		td.setId(detail.getId());
		return td;
	}

	@Override
	public TemplateDetail trevnoc(TDetail detail) {
		TemplateDetail td=new TemplateDetail();
		td.setId(detail.getId());
		td.setMasterBreadList(new MasterBreadList(detail.getMasterBreadId()));
		td.setTemplate(new Template(detail.getTemplateId()));
		td.setPrice(detail.getPrice());
		return td;
	}
}
