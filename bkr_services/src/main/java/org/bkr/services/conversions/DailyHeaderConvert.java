package org.bkr.services.conversions;

import org.bkr.models.DailyHeader;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.DHeader;

public class DailyHeaderConvert implements Convertable<DailyHeader, DHeader>
{

	@Override
	public DHeader convert(DailyHeader head) {
		DHeader dh=new DHeader();
		dh.setDate(head.getDate());
		dh.setDifference(head.getDifference());
		dh.setExpenses(head.getExpenses());
		dh.setGrandTotal(head.getGrandTotal());
		dh.setId(head.getId());
		dh.setRemittance(head.getRemittance());
		dh.setTotal(head.getTotal());
		dh.setAmExpenses(head.getAmExpenses());
		dh.setAmRemittance(head.getAmRemittance());
		dh.setPmExpenses(head.getPmExpenses());
		dh.setPmRemittance(head.getRemittance());
		return dh;
	}

	@Override
	public DailyHeader trevnoc(DHeader head) {
		DailyHeader dh=new DailyHeader();
		dh.setDate(head.getDate());
		dh.setDifference(head.getDifference());
		dh.setExpenses(head.getExpenses());
		dh.setGrandTotal(head.getGrandTotal());
		dh.setId(head.getId());
		dh.setRemittance(head.getRemittance());
		dh.setTotal(head.getTotal());
		dh.setAmExpenses(head.getAmExpenses());
		dh.setAmRemittance(head.getAmRemittance());
		dh.setPmExpenses(head.getPmExpenses());
		dh.setPmRemittance(head.getPmRemittance());
		return dh;
	}
}
