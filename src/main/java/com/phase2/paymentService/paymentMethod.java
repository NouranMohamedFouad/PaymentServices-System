package com.phase2.paymentService;

public interface paymentMethod 
{
	public void payForService(int a);
	public void removeAmount(int a);
	public int getAmount();
}
