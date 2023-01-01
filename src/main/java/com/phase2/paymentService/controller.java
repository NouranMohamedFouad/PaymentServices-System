package com.phase2.paymentService;

import org.springframework.web.bind.annotation.*;

public class controller {
	private User[] arr; 
	private int i=0;
	///////////////////////////////
	public controller() 
	{
		arr=new User[100];
		for(int i=0;i<100;i++)
		{
			arr[i]=new User();
		}
	}
	///////////////////////////////
	@PostMapping(value="/SignIn") 
	public boolean SignIn(@RequestBody String email,@RequestBody String pass) 
	{
		boolean signedIn=false;
		if(checkAccount(email,pass)) 
		{
			 System.out.println("You are logged in successfully");
			 signedIn=true; 
		} 
		else   
		{
			System.out.println("You don't have an Acount..Please Sign Up"); 
			signedIn=false;
		}
		return signedIn;  
	} 
	///////////////////////////////
	@PostMapping(value="/SignUp") 
	public void SignUp(@RequestBody String uname ,@RequestBody String email,@RequestBody String pass)
	{
		if(!checkAccount(email,pass))
		{
			arr[i].setEmail(email); 
			arr[i].setUsername(uname);
			arr[i].Setpassword(pass); 
			i++;
			 System.out.println("You are signed up successfully");
		} 
		else                               
		{
			System.out.println("You already have an Acount..Please Sign In"); 
		}
	}
	///////////////////////////////
	@GetMapping(value="/SignUp") 
	public void pay(@RequestBody serviceProvider p)
	{
		  p.getPaymentMethod();
	}
	/////////////////////////////// 
	@GetMapping(value="/refund") 
	public void requestRefund(@RequestBody User u,@RequestBody int amount,@RequestBody Refund f,@RequestBody int id)
	{
		u.askForRefund(amount,f,id); 
	} 
	/////////////////////////////// 
	
	@GetMapping(value="/check") 
	public boolean checkAccount(@RequestBody String e,@RequestBody String pass)
	{
        boolean check=false;
		
		for(int index=0;index<i;index++)
		{
			if(arr[index].getEmail()==e && arr[index].getPassword()==pass) 
			{
				check=true;
				break;
			}   
		}
		return check; 
	}
	///////////////////////////////
	@GetMapping(value="/search") 

	public Service searchForService(@RequestBody Service s,@RequestBody Iform f) throws Exception
	{
			
		serviceProvider p[]=s.returnServiceProviders(); 
		p[0].chooseProvider(); 
		for(int i=0;i<5;i++) 
		{
			 System.out.println(i+1+") "+p[i].getName());  	   
		} 
		chooseServiceProvider(p[i]);
		return s;
	}
	///////////////////////////////
	public void chooseServiceProvider(serviceProvider provider)  
	{
		
	}

	
	/////////////////////////
	public void searchForService(String service,Iform f) throws Exception
	{
		Service s; 
		if(service=="landline")  
		{
			s=new LandlineServices(5,f);
		}
		else if(service=="donations") 
		{
			s=new Donations(5,f); 
		}
		else if(service=="internetPayment") 
		{
			s=new InternetPaymentServices(5,f);	
		}
		else if(service=="mobileRecharge")
		{
			s=new MobileRechargeServices(5,f); 
		}	
		else 			
		{
			throw new Exception("This Service Is Not SUPPORTED");
		}		
		serviceProvider p[]=s.returnServiceProviders(); 
		p[0].chooseProvider();
		for(int i=0;i<5;i++)
		{
			 System.out.println(p[i].getName());	   
		}
	}
	///////////////////////////////
	
	public void selectService(@RequestBody Service service)
	{
		service.returnServiceProviders();
	}
	//////////////////////////////
	public void checkDiscount()
	{
		
	}
	@PostMapping(value="/add")
	public void addServiceProvider(@RequestBody Service s,@RequestBody String serviceProvider,@RequestBody Iform f) throws Exception
	{

		s.createServiceProvider(serviceProvider,f); 
		serviceProvider p[]=s.returnServiceProviders();
		for(int i=0;i<5;i++)
		{
			 System.out.println(p[i].getName());	    
		}
	}
	////////////////////////////////
	@PostMapping(value="/discount")
	public void addDiscount(@RequestBody Discount d)
	{
		 d.addDiscount();
	}
	////////////////////////////////
	@GetMapping(value="/list")
	public void listAllTransactions(@RequestBody admin d)
	{
		System.out.println("Payment Transactions:");
		d.listAllPaymentT();
		System.out.println("Refund Transactions:");
		d.listAllRefundT();
		System.out.println("Wallet Transactions:");
		d.listAllWalletT();
	}
	////////////////////////////////

}
