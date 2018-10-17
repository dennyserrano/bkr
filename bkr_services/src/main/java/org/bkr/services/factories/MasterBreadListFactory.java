package org.bkr.services.factories;

import java.util.ArrayList;
import java.util.List;

import org.bkr.models.MasterBreadList;
import org.bkr.services.conversions.BreadConvert;
import org.bkr.services.conversions.interfaces.Convertable;
import org.bkr.web.Bread;

public class MasterBreadListFactory {

	private static Convertable<MasterBreadList, Bread> breadConverter=new BreadConvert();
	
	public static MasterBreadList generate(Bread b)
	{
		return breadConverter.trevnoc(b);
	}
	
	public static Bread generate(MasterBreadList b)
	{
		return breadConverter.convert(b);
	}
	
	public static List<Bread> generate(List<MasterBreadList> breadList)
	{
		ArrayList<Bread> al=new ArrayList<>();
		breadList.forEach(b->{
			al.add(breadConverter.convert(b));
		});
		
		return al;	
	}
	
	
}
