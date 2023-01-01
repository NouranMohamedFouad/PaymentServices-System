package com.phase2.paymentService;
//import java.util.LinkedList;
import java.util.Queue;

public class Donations implements Service
{
	int size=0;
	int i=0; 
	private serviceProvider[] arr;
	private Iform f;
	private String name="Donations Services";
	//private Queue<serviceProvider> ar=new LinkedList();
	public Donations(int n,Iform form)
	{
		f=form;
		size=n;
		arr=new DonationsProvider[size]; 
		for(int i=0;i<size;i++)
		{
			arr[i]=new DonationsProvider();
			arr[i].setName("---");	
		}	
		createServiceProvider("Cancer Hospital",f);
		createServiceProvider("Schools",f);
		createServiceProvider("NGOs",f);
	}
	@Override
	public String getService() 
	{
		return name;
	}
	@Override 
	public serviceProvider createServiceProvider(String s,Iform form) 
	{ 
		
		arr[i++].add(s,f);
		return new DonationsProvider();   
	}
	@Override
	public serviceProvider[] returnServiceProviders() 
	{
		return arr;  
	}
}
