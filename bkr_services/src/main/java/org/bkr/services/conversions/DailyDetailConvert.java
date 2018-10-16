package org.bkr.services.conversions;

import org.bkr.models.DailyDetail;
import org.bkr.models.TemplateDetail;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.DDetail;

public class DailyDetailConvert implements Convertable<DailyDetail, DDetail>{
	

	@Override
	public DDetail convert(DailyDetail detail) {
	
		DDetail dd=new DDetail();
		dd.setAmount(detail.getAmount());
		dd.setBeginningInv(detail.getBeginningInv());
		dd.setCategory(detail.getCategory());
		dd.setEndingInv(detail.getEndingInv());
		dd.setId(detail.getId());
		dd.setProduction(detail.getProduction());
		dd.setSales(detail.getSales());
		dd.setTgafs(detail.getTgafs());
		return dd;
	}

	@Override
	public DailyDetail trevnoc(DDetail detail) {
		DailyDetail dd=new DailyDetail();
		dd.setAmount(detail.getAmount());
		dd.setBeginningInv(detail.getBeginningInv());
		dd.setCategory(detail.getCategory());
		dd.setEndingInv(detail.getEndingInv());
		dd.setId(detail.getId());
		dd.setProduction(detail.getProduction());
		dd.setSales(detail.getSales());
		dd.setTgafs(detail.getTgafs());
		return dd;
	}
	
}
