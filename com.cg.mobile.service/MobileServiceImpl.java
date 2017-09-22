package com.cg.mobile.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.dao.IMobileDAO;
import com.cg.mobile.dao.MobileDaoImpl;
import com.cg.mobile.exception.MobileApplicationException;


public class MobileServiceImpl implements IMobileService {
	
	IMobileDAO dao=null;
	

	@Override
	public int addPurchaseDetails(PurchaseDetails p) throws MobileApplicationException {
		
		dao=new MobileDaoImpl();
		return dao.addPurchaseDetails(p);
		
		
	}
public boolean validateName(String name)
	{
		String ptn="[A-Z]{1}[a-zA_Z]{2,19}";
		if(Pattern.matches(ptn, name))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the correct input name");
			return false;
		}
	}

public boolean validateEmail(String email)
{
	String emailPattern="^[?=.*A-Za-z0-9]+@[A_Za-z]+\\.[A-Za-z]{2,6}$";
	if(Pattern.matches(emailPattern,email))
	{
		return true;
	}
	else
	{
		System.out.println("Please enter the correct Email");
		return false;
	}
}
public boolean validatePhoneNo(String phone)
{
	String phonePattern="[0-9]{10}";
	if(Pattern.matches(phonePattern,phone))
	{
		return true;
	}
	else
	{
		System.out.println("Please enter the correct phone number");
		return false;
	}
}
@Override
public ArrayList<MobileDetails> retrieveDetails() {
	dao=new MobileDaoImpl();
	return dao.retrieveDetails();
}

}
