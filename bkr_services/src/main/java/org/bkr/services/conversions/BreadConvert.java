package org.bkr.services.conversions;

import org.bkr.models.MasterBreadList;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.Bread;

public class BreadConvert implements Convertable<MasterBreadList,Bread>{


	@Override
	public Bread convert(MasterBreadList b) {
		
		Bread e=new Bread();
		e.setBreadName(b.getBreadName());
		e.setId(b.getId());
		e.setPrice(b.getPrice());
		return e;
	}

	@Override
	public MasterBreadList trevnoc(Bread b) {
		
		
		MasterBreadList e=new MasterBreadList();
		e.setBreadName(b.getBreadName());
		e.setId(b.getId());
		e.setPrice(b.getPrice());
		return e;
	}
	
}
