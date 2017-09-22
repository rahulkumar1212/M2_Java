package com.cg.mobile.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.dao.IMobileDAO;
import com.cg.mobile.dao.MobileDaoImpl;
import com.cg.mobile.exception.MobileApplicationException;

public class Test1 {
	
	static IMobileDAO dao=null;
	static PurchaseDetails bean=null;

	@BeforeClass
	public static void initilize() throws MobileApplicationException {
		System.out.println("hi");
		dao=new MobileDaoImpl();
		bean=new PurchaseDetails();
	}
	
	@Test
	public void test()
	{
		bean.setcName("123sample");
		bean.setMailId("abc@gmail.com");
		bean.setMobileId(1001);
		bean.setPhoneNo("9431239578");
		bean.setPurchaseId(1001);

	}

	@Test
	public void testAddDetails() throws MobileApplicationException 
	{
		
		assertNotNull(dao.addPurchaseDetails(bean));
	}
	@Test
	public void getDetails()
	{
		assertNotNull(dao.retrieveDetails());
	}
}
