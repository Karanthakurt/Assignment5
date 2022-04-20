package com.Assignment;
import java.sql.*;
public class jdbc4 {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		
		String qry = "insert into login values('karant', 'asdfgh')";

		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			
			
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment4?user=root & password=karanthakur");
			System.out.println("connection is established");
			
			psmt = con.prepareStatement(qry);
			
			
			psmt.addBatch( );
			int arr[ ] = psmt.executeBatch();
			for (int i : arr)
			{
			System.out.print(i);
			}
			
			psmt.addBatch();
			int arr1[ ] = psmt.executeBatch( );
			for (int j : arr1)
			{
			System.out.print(j);
			}
			}
			catch (ClassNotFoundException | SQLException e)
			{
			e.printStackTrace( );
			}

		finally {
			
			if(psmt!=null) {
				psmt.close();
			}
			if(con!=null) {
				try {
					con.close();
				}
				
				catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		System.out.println("costly resourses closed");
			

	}

}
