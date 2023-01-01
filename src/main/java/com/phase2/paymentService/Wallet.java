package com.phase2.paymentService;

public class Wallet implements paymentMethod
{
	private int amount=10000; 
    
	@Override
	public void payForService(int a) 
	{
		// TODO Auto-generated method stub
		 System.out.println("paying by Wallet");  
		 removeAmount(a);
	}
	public void addAmount(int a)
	{
		 amount=amount+a;
	}
	public void removeAmount(int a)
	{
		amount=amount-a;
	}	
	public void setAmount(int a)
	{
		amount=a;
	}
	public int getAmount()
	{
		return amount; 
	}
	
}
