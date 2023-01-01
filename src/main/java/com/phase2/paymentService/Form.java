package com.phase2.paymentService;

public class Form implements Iform 
{
    String desc="this Form contains:";
	String mobileNum;
	int amount;
	@Override
	public String create()
	{
		return desc;
	}
	@Override
	public void fill()
	{
		
	}
	
}
