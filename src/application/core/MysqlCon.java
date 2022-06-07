package application.core;

import java.sql.*;


public class MysqlCon {
	private Connection con;
	
	public MysqlCon()
	{
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/miniprojet","root",""); 
			//System.out.println("connected to db");
			//here sonoo is database name, root is username and password  
			//Statement stmt=con.createStatement();  
			//ResultSet rs=stmt.executeQuery("select * from emp");  
			/*while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			//con.close();  */
			}catch(Exception e){ System.out.println(e);}
	}
	public void finalize()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet request(String e) {
		ResultSet rs=null;
		try {
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery(e);
			
			
		}catch(Exception s){ System.out.println(s);}
		return rs;
	}
	public void exec(String e) {
		
		//ResultSet rs=null;
		try {
			Statement stmt=con.createStatement();
			stmt.executeUpdate(e);
			
			
		}catch(Exception s){ System.out.println(s);}
	}
}
