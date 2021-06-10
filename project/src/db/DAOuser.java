package db;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import module.User;
import view.LoginFrame;
import java.sql.*;
public class DAOuser
{
	
	static Class c1;
	static String url;
	static Connection con;
	static Statement s1;
   
  
  
    static
    {
    	try
    	{
    		
    	c1=Class.forName("com.mysql.jdbc.Driver");
   	 url="jdbc:mysql://localhost:3306/user";
			con=(Connection) DriverManager.getConnection(url,"root","9922980310");
			System.out.println("connection successful");
			s1=(Statement) con.createStatement();
			
			
		} catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	catch (ClassNotFoundException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    }
    
    
    
    
    
    
    
    

	public boolean insert(User u1) 
	{
		// TODO Auto-generated method stub
	try {
		String name=u1.getUsername();
		String pass=u1.getPassword();
		String city=u1.getCity();
		PreparedStatement st=con.prepareStatement("insert into user values(?,?,?)");
	    st.setString(1, name);
	    st.setString(2,pass );
	    st.setString(3, city);
	    st.addBatch();
	    st.execute();
	    
	//s1.execute("insert into user values(name,pass,city);");
	System.out.println("row added");
		//for(int i=0;i<arruser.size();i++)
			//System.out.println();
		return true;
	}catch (Exception e) 
	{
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}

	}

public boolean validateuser(User u1)
	{
	    Statement stmt=null;
		try {
			stmt = (Statement) con.createStatement();
			ResultSet rs=(ResultSet) stmt.executeQuery("select*from user");
			while(rs.next()) {
				if( rs.getString(1).equals(u1.getUsername())
						&& rs.getString(2).equals(u1.getPassword()))
				{
					return true;
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
		return false;	
		}
}
	

