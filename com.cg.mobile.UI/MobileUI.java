package com.cg.mobile.UI;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.exception.MobileApplicationException;
import com.cg.mobile.service.IMobileService;
import com.cg.mobile.service.MobileServiceImpl;

public class MobileUI {
	static Scanner sc=new Scanner(System.in);
	static PurchaseDetails details=null;
	static IMobileService service= new MobileServiceImpl();
	
	
	public static void main(String[] args) throws MobileApplicationException {
		
	
		System.out.println("Mobile Application");
		System.out.println("*******************");
		while(true)
		{
			System.out.println("1.Enter purchase details");
			System.out.println("2.Get mobile details");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addPurchasedetails();
			break;
			case 2:getMobiledetails();
			break;
			case 3: System.exit(0);
			break;
			
			}
			
		}
		
	}

	

	private static void addPurchasedetails() throws MobileApplicationException
	{
		try{
		System.out.println("Enter Customer Name");
		String name=sc.next();
		if(service.validateName(name))
		{
		System.out.println("Enter mailid");
		String mail=sc.next();
		if(service.validateEmail(mail))
		{
		System.out.println("Enter phone number");
		String phone=sc.next();
		String p=String.valueOf(phone);
		if(service.validatePhoneNo(p))
		{
		System.out.println("Enter mobile id");
		int mobid=sc.nextInt();
		
		details=new PurchaseDetails(name,mail,phone,mobid);
		//no use as it is globally declared
		service=new MobileServiceImpl();
		int res=service.addPurchaseDetails(details);
		System.out.println(res+" inserted");
		if(res==1)
		{
			System.out.println("value is added in database");
		}
		else
		{
			System.out.println("value not added");
		}
		}}}
		
	}
		catch(MobileApplicationException e){
			throw new MobileApplicationException("Exception occured");
		}
		
		
		
	}
	private static void getMobiledetails() 
	{
		ArrayList<MobileDetails> list=null;
		
		list=service.retrieveDetails();
		for(MobileDetails m:list)
		{
			System.out.println(m.getMobileId());
			System.out.println(m.getName());
			System.out.println(m.getPrice());
			System.out.println(m.getQuantity());
		}
		
	}
}
