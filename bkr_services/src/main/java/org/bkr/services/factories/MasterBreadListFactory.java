package org.bkr.services.factories;

import org.bkr.models.MasterBreadList;
import org.bkr.services.conversions.BreadConvert;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.Bread;

public class MasterBreadListFactory {

	private Convertable<MasterBreadList, Bread> breadConverter=new BreadConvert();
	
	public MasterBreadList generate(Bread b)
	{
		return breadConverter.trevnoc(b);
	}
	
	public Bread generate(MasterBreadList b)
	{
		return breadConverter.convert(b);
	}
	
}
