package com.phase2.paymentService;

public interface Service 
{
	public String getService();
	public serviceProvider createServiceProvider(String s,Iform f);
	public serviceProvider[] returnServiceProviders();
}