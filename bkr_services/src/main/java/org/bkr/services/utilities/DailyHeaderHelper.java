package org.bkr.services.utilities;

import java.math.BigDecimal;
import org.bkr.models.DailyDetail;
import org.bkr.models.DailyHeader;

public class DailyHeaderHelper {

	public static DailyHeader align(DailyHeader dh)
	{
		dh.setExpenses(dh.getAmExpenses().add(dh.getPmExpenses()));
		dh.setRemittance(dh.getAmRemittance().add(dh.getPmRemittance()));
		BigDecimal total=BigDecimal.ZERO;
		for(DailyDetail dd:dh.getDailyDetailses())
		{
			dd.setTgafs(dd.getBeginningInv()+dd.getProduction());
			dd.setSales(dd.getTgafs()-dd.getEndingInv());
			dd.setAmount(new BigDecimal(dd.getSales()).multiply(dd.getTemplateDetail().getPrice()));
			total=total.add(dd.getAmount());
		}
		
		dh.setTotal(total);
		dh.setGrandTotal(dh.getTotal().subtract(dh.getExpenses()));
		dh.setDifference(dh.getRemittance().subtract(dh.getGrandTotal()));
		return dh;
	}
	
}
