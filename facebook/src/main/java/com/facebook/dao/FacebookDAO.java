package com.facebook.dao;

import java.sql.*;
import java.util.ArrayList;

import com.facebook.entity.FacebookUser;
import com.facebook.utility.MySQLDatabaseConnection;

public class FacebookDAO implements FacebookDAOInterface{

	public int createProfileDAO(FacebookUser fc) {
		int i=0;
		try {
		Connection con=MySQLDatabaseConnection.getConnection();
	
		PreparedStatement ps = con.prepareStatement("insert into facebookuser values(?,?,?,?)");
		ps.setString(1,fc.getName());
		ps.setString(2,fc.getPassword());
		ps.setString(3,fc.getEmail());
		ps.setString(4,fc.getAddress());

		i=ps.executeUpdate();
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public FacebookUser viewProfileDAO(FacebookUser fu) {
		FacebookUser fb=null;
		
		try {
			Connection con=MySQLDatabaseConnection.getConnection();
		
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where email=?");
			
			ps.setString(1,fu.getEmail());
		
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				String name = res.getString(1);
				String password = res.getString(2);
				String email = res.getString(3);
				String address = res.getString(4);
				
				fb=new FacebookUser();
				fb.setName(name);
				fb.setPassword(password);
				fb.setEmail(email);
				fb.setAddress(address);
			}
		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		return fb;
	}

	public boolean editProfileDAO(FacebookUser fc) {
		boolean b=false;
		try {
		Connection con=MySQLDatabaseConnection.getConnection();
	
		PreparedStatement ps = con.prepareStatement("update facebookuser set name=?, password=?, address=? where email=?");
		ps.setString(1,fc.getName());
		ps.setString(2,fc.getPassword());
		
		ps.setString(3,fc.getAddress());
		ps.setString(4,fc.getEmail());

		int i=ps.executeUpdate();
		if(i>0) {
			b=true;
		}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean deleteProfileDAO(FacebookUser fc) {
		boolean b=false;
		try {
		Connection con=MySQLDatabaseConnection.getConnection();
	
		PreparedStatement ps = con.prepareStatement("delete from facebookuser  where email=?");
		
		ps.setString(1,fc.getEmail());

		int i=ps.executeUpdate();
		if(i>0) {
			b=true;
		}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//int i[] = new int[9];
	
	
	public ArrayList<FacebookUser> viewAllProfileDAO() {
		FacebookUser    ff[]  = new FacebookUser[20];
		
		ArrayList<FacebookUser> ll=new ArrayList<FacebookUser>();
		
		
		try {
			Connection con=MySQLDatabaseConnection.getConnection();
		
			PreparedStatement ps = con.prepareStatement("select * from facebookuser ");
			
			ResultSet res = ps.executeQuery();
			
			
			while(res.next()) {
				String name = res.getString(1);
				String password = res.getString(2);
				String email = res.getString(3);
				String address = res.getString(4);
				
				FacebookUser fb=new FacebookUser();
				fb.setName(name);
				fb.setPassword(password);
				fb.setEmail(email);
				fb.setAddress(address);
				
				ll.add(fb);
				
			}
		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		return ll;
	}
	public FacebookUser[] viewAllProfileDAO1() {
		FacebookUser    ff[]  = new FacebookUser[20];
		
		
		try {
			Connection con=MySQLDatabaseConnection.getConnection();
		
			PreparedStatement ps = con.prepareStatement("select * from facebookuser ");
			
			ResultSet res = ps.executeQuery();
			int j=0;
			
			while(res.next()) {
				String name = res.getString(1);
				String password = res.getString(2);
				String email = res.getString(3);
				String address = res.getString(4);
				
				FacebookUser fb=new FacebookUser();
				fb.setName(name);
				fb.setPassword(password);
				fb.setEmail(email);
				fb.setAddress(address);
				
				ff[j]=fb;
				j++;
			}
		
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		return ff;
	}

	@Override
	public boolean editProfileAddressDAO(FacebookUser fc) {
		boolean b=false;
		try {
		Connection con=MySQLDatabaseConnection.getConnection();
	
		PreparedStatement ps = con.prepareStatement("update facebookuser set  address=? where email=?");
	
		
		ps.setString(1,fc.getAddress());
		ps.setString(2,fc.getEmail());

		int i=ps.executeUpdate();
		if(i>0) {
			b=true;
		}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean editProfilePasswordDAO(FacebookUser fc) {
		boolean b=false;
		try {
		Connection con=MySQLDatabaseConnection.getConnection();
	
		PreparedStatement ps = con.prepareStatement("update facebookuser set  password=? where email=?");
		
		ps.setString(1,fc.getPassword());
		
	
		ps.setString(2,fc.getEmail());

		int i=ps.executeUpdate();
		if(i>0) {
			b=true;
		}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}























