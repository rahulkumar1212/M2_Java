package com.cg.mobile.service;

import java.util.ArrayList;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.exception.MobileApplicationException;

public interface IMobileService {

		public int addPurchaseDetails(PurchaseDetails p) throws MobileApplicationException;
		public boolean validateName(String name);
		public boolean validateEmail(String email);
		public boolean validatePhoneNo(String phone);
		
		//multiple rows need to return so return type arraylist
		public ArrayList<MobileDetails> retrieveDetails();
}
