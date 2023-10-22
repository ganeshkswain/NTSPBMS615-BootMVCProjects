package com.nt.service;

public interface IPurchaseOrder {
	public String purchase(String[] iteams,Double[] prices,String[] emails)throws Exception;
}
