package com.phase2.paymentService;

public class LandlineServices implements Service
{
	int size=0;
	int i=0; 
	private serviceProvider[] arr;
	private Iform f;
	private String name="landline Services";
	//////////////////////////////
	public LandlineServices(int n,Iform form)
	{
		f=form; 
		size=n;
		arr=new LandlineServicesProvider[size]; 
		for(int i=0;i<size;i++)
		{
			arr[i]=new LandlineServicesProvider();
			arr[i].setName("---");	
		}
		createServiceProvider("Monthly receipt",f);
		createServiceProvider("Quarter receipt",f); 
	}
	@Override
	public String getService() 
	{
		return name; 
	}
	@Override
	public serviceProvider createServiceProvider(String s,Iform f) 
	{ 
		arr[i++].add(s,f); 
		return new LandlineServicesProvider(); 
	} 
	@Override
	public serviceProvider[] returnServiceProviders()
	{
		return arr; 
	}
}
