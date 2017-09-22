package com.cg.mobile.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.dbUtil.DbUtil;
import com.cg.mobile.exception.MobileApplicationException;

public class MobileDaoImpl implements IMobileDAO{

	int result=0;
	Connection conn=null;
	@Override
	public int addPurchaseDetails(PurchaseDetails p) throws MobileApplicationException 
	{
		
		
		try {
			conn=DbUtil.getConnection();
String insertQuery="Insert into purchasedetails values(purchase_seq_id.nextval,?,?,?,SYSDATE,?)";
			
			PreparedStatement ps=conn.prepareStatement(insertQuery);
			ps.setString(1, p.getcName());
			ps.setString(2,p.getMailId());
			ps.setString(3,p.getPhoneNo());
			String sql="select mobileId from mobiles where mobileId=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getMobileId());
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				ps.setInt(4, rs.getInt(1));
				result=ps.executeUpdate();
				System.out.println(result);
				
			}
			
			
			
			
			} 
		catch (IOException e) 
		{


			e.printStackTrace();
		}
		catch(SQLException e)
		{	throw new MobileApplicationException(e.getMessage());
			
			
		}
		return result;
	
		
	}
	@Override
	public ArrayList<MobileDetails> retrieveDetails() {
		ArrayList<MobileDetails> list=new ArrayList<MobileDetails>();
		try {
			conn=DbUtil.getConnection();
		
		
		String sql="Select * from mobiles";
		
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
	
		
		while(rs.next())
		{
			
			int mid=rs.getInt(1);
			String name=rs.getString(2);
			int price=rs.getInt(3);
			String quantity=rs.getString(4);
			list.add(new MobileDetails(mid,name,price,quantity));
			
		}}
		catch (IOException | SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		return list;
	}

}
