package com.phase2.paymentService;

public class cashOnDelivery implements paymentMethod
{
	private int amount;

	@Override
	public void payForService(int a) 
	{
		 System.out.println("paying by cach on delivery");  
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
