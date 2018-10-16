package org.bkr.services.conversions;

import org.bkr.models.TemplateDetail;
import org.bkr.models.TemplateDetailsId;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.TDetail;

public class TemplateDetailConvert implements Convertable<TemplateDetail,TDetail>{

	@Override
	public TDetail convert(TemplateDetail detail) {
		TDetail td=new TDetail();
		td.setMasterBreadId(detail.getId().getMasterBreadId());
		td.setTemplateId(detail.getId().getTemplateId());
		return td;
	}

	@Override
	public TemplateDetail trevnoc(TDetail detail) {
		TemplateDetail td=new TemplateDetail();
		TemplateDetailsId id=new TemplateDetailsId(detail.getTemplateId(), detail.getMasterBreadId());
		td.setId(id);
		return td;
	}
}
