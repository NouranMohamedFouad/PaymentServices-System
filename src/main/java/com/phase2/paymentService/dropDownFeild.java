package com.phase2.paymentService;

public class dropDownFeild extends Feild
{
    //////////////////////
	dropDownFeild(Iform w)
	{
		wrapee=w;
	}
	@Override
	public String create()
	{
		return wrapee.create()+" dropdown feild  ";
	}
	@Override
	public void fill()
	{
		
	}

}
