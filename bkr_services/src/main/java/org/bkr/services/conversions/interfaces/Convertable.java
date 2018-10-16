package org.bkr.services.conversions.interfaces;

public interface Convertable<T,K> {
	K convert(T t);
	T trevnoc(K k);
}
