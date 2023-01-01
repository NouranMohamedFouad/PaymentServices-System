package com.phase2.paymentService;

import org.springframework.web.bind.annotation.*;

@RestController
public class admin 
{
	private Service service ;
	private realRefund refund;
	private Discount discount;
	private Transaction transaction;
	//////
	public admin(Transaction t) 
	{
	    refund=new realRefund();
	    transaction=t;  
	} 
	public void approveRefund(int amount,Wallet w,int id)
	{
		if(checkRefundTransaction(id))
		{
			refund.approveRefund(amount,w,id);   
			transaction.addRefundTrans(id);  
		}
		else
		{ 
			System.out.println("the transaction is not available "); 
		}
	}
	public void addDisc(Discount d)
	{
		
	}
	public void listAllPaymentT()
	{
		int arr[]=transaction.returnPaymentArr();
		for(int i=0;i<arr.length;i++)
		{
			 System.out.println(arr[i]);	   
		} 
	}
	public void listAllRefundT()
	{
	
		int arr[]=transaction.returnRefundArr();
		for(int i=0;i<arr.length;i++)
		{
			 System.out.println(arr[i]);	   
		}
	}
	public void listAllWalletT()
	{
		int arr[]=transaction.returnWalletArr();
		for(int i=0;i<arr.length;i++)
		{
			 System.out.println(arr[i]);	    
		}
	}
	public boolean checkRefundTransaction(int id)
	{
		boolean check=false;
		int arr[]=transaction.returnPaymentArr();
		for(int i=0;i<arr.length;i++)
		{ 
			if(arr[i]==id)
			{
				check=true;
				break;
			}
		} 
		return check;
	}	
	//private String name="hellooISA";
	
	@GetMapping(value="/admin") 
	public String name(@RequestBody String s) 
	{
		return "heloooo";
	}
	@PostMapping(value="/admin") 
	public String nname(@RequestBody String s) 
	{
		return s;
	}
	

}
