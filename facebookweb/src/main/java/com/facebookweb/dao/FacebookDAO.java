package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.facebookweb.entity.FacebookUser;


public class FacebookDAO implements FacebookDAOInterface {

	@Override
	public int createProfileDAO(FacebookUser fb) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdb","root","rajesh");
			PreparedStatement ps=con.prepareStatement("insert into facebookuser values(?,?,?,?)");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getPassword());
			ps.setString(3, fb.getEmail());
			ps.setString(4, fb.getAddress());
			
			i=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean loginProfileDAO(FacebookUser fb) {
		boolean i=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdb","root","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=? and password=?");
			ps.setString(1, fb.getEmail());
			ps.setString(2, fb.getPassword());
			
			
			
			ResultSet res =ps.executeQuery();
			
			if(res.next()) {
				i=true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public FacebookUser viewProfileDAO(FacebookUser fb) {
		FacebookUser ff = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdb","root","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=?");
			ps.setString(1, fb.getEmail());
			
			
			ResultSet res =ps.executeQuery();
			
			if(res.next()) {
				ff=new FacebookUser();
				ff.setName(res.getString(1));
				ff.setPassword(res.getString(2));
				ff.setEmail(res.getString(3));
				ff.setAddress(res.getString(4));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff;
	}

	@Override
	public List<FacebookUser> viewAllProfileDAO() {
		List<FacebookUser> ll1 = new ArrayList<FacebookUser>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdb","root","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from facebookuser ");
			
			ResultSet res =ps.executeQuery();
			
			while(res.next()) {
				FacebookUser ff=new FacebookUser();
				ff.setName(res.getString(1));
				ff.setPassword(res.getString(2));
				ff.setEmail(res.getString(3));
				ff.setAddress(res.getString(4));
				ll1.add(ff);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll1;
	}

	@Override
	public int deleteProfileDAO(FacebookUser fb) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookdb","root","rajesh");
			PreparedStatement ps=con.prepareStatement("delete from facebookuser where email=?");
			
			ps.setString(1, fb.getEmail());
			
			
			i=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public  List<FacebookUser> searchProfileDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
