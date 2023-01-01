package com.phase2.paymentService;

public class creditCard implements paymentMethod
{
	private int amount=10000;

	@Override
	public void payForService(int a) 
	{
		 System.out.println("paying by credit card");  
		 removeAmount(a);
	}
	@Override 
	public void removeAmount(int a) 
	{ 
		amount=amount-a; 
	}
	@Override
	public int getAmount()
	{
		return amount;
	}
}
