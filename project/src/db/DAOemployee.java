package db;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import com.mysql.jdbc.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.sql.*;
import java.sql.PreparedStatement;

import module.Admin;
import module.Employee;
import module.Hr;
import module.IdSort;
import module.ExtraPaymentSort;
import module.NameSort;
import module.SalesManger;
import view.AdminEditFrame;
import view.DeleteEmployee;
import view.HrEditFrame;
import view.SalesmangerEditFrame;
import view.SalesmangerFrame;


public class DAOemployee
{
    
	static Class c1;
	static String url;
	static Connection con;
	static Statement s1;

	static
	{
		try {
			
			c1=Class.forName("com.mysql.jdbc.Driver");
    	 url="jdbc:mysql://localhost:3306/test";
			con=(Connection) DriverManager.getConnection(url,"root","9922980310");
			System.out.println("connection successful");
			s1=(Statement) con.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}

	public boolean insert(Employee e1)
	{
		PreparedStatement st;
		try {
			st = con.prepareStatement("insert into Employee values(?,?,?)");
			st.setInt(1, e1.getId());
			st.setString(2,e1.getName() );
		    st.setDouble(3, e1.getSal());
		    st.addBatch();
		    st.execute();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	if(e1 instanceof SalesManger)
		{
			
				
			SalesManger s1=(SalesManger)e1;
			PreparedStatement st2;
			try {
				st2 = con.prepareStatement("insert into SalesManger values(?,?,?)");
				st2.setInt(1, s1.getId());
				st2.setInt(2, s1.getIntensive());
			    st2.setInt(3, s1.getTarget());
			    st2.addBatch();
			    st2.execute();
			   return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
				}
		 if(e1 instanceof Admin)
		{
			Admin a1=(Admin)e1;
			PreparedStatement st2;
			try {
				st = con.prepareStatement("insert into Admin values(?,?)");
				st.setInt(1, a1.getId());
				st.setInt(2, a1.getAllowence());
			    st.addBatch();
			    st.execute();
			   return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(e1 instanceof Hr)
		{
			Hr a1=(Hr)e1;
		
			PreparedStatement s;
			try {
				s = con.prepareStatement("insert into Hr values(?,?)");
				s.setInt(1, a1.getId());
				s.setInt(2,a1.getComission() );
			    s.addBatch();
			    s.execute();
			  return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	     		
	}
	
	

	public boolean delete(int id)
	{
		 String sQuery="Select * from employee where id=?;";
	  	 try {
			PreparedStatement pstmt=con.prepareStatement(sQuery);
			pstmt.setInt(1, id);
			ResultSet rs=(ResultSet) pstmt.executeQuery();
			
			if(rs.next())
			{
				String dquery="delete from Employee where id=?;";
				PreparedStatement pstm=con.prepareStatement(dquery);
				pstm.setInt(1, id);
				pstm.executeUpdate();
				System.out.println("Row deleted");
				return true;
			}
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	 
	  	 return false;
	 
		
	}


		public Employee search(int i)
		{
		String sql="select*from employee where id=?;";
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setInt(1, i);
			ResultSet rs=(ResultSet) stat.executeQuery();
			while(rs.next())
			{
				int id=Integer.parseInt(rs.getString(1));
				String name=rs.getString(2);
				double sal=Double.parseDouble(rs.getString(3));
				
				
				
				 String sql2="select * from salesmanger where id=?";
				 PreparedStatement st=con.prepareStatement(sql2);
				 st.setInt(1,i);
				 ResultSet srs=(ResultSet) st.executeQuery();
				 while(srs.next())
				 {
					 int ints=Integer.parseInt(srs.getString(2));
					 int target=Integer.parseInt(srs.getString(3));
					 SalesManger s=new  SalesManger();
					 s.setId(id);
					 s.setName(name);
					 s.setSal(sal);
					 s.setIntensive(ints);
					 s.setTarget(target);
					 return s;
				 }
				
				 
				 String str="select* from Admin where id=?;";
				 PreparedStatement ad1=con.prepareStatement(str);
				 ad1.setInt(1,i);
				 ResultSet ars=(ResultSet) ad1.executeQuery();
				 while(ars.next())
				 {
					 int allowence=Integer.parseInt(ars.getString(2));
					 Admin  a=new Admin();
					 a.setId(id);
					 a.setName(name);
					 a.setSal(sal);
					 a.setAllowence(allowence);
					  return a;
				 }
				
				 String string="select * from Hr where id=?;";
				 PreparedStatement hr1=con.prepareStatement(string);
				 hr1.setInt(1,i);
				 ResultSet hrs=(ResultSet) hr1.executeQuery(); 
				 while(hrs.next())
				 {
					 int commision=Integer.parseInt(hrs.getString(2));
					 Hr h=new Hr();
					 h.setId(id);
					 h.setName(name);
					 h.setSal(sal);
					 h.setComission(commision);
					  return h;
				 }
				
				 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return null;

	}


		public int calSal(int id) {
			
			Employee f=this.search(id);
			try {int b = 0,sal=0;
			
			String c="select* from Employee where id=?;";
			 PreparedStatement q;
			
				
				q = con.prepareStatement(c);
				 q.setInt(1,id);
				 ResultSet calsal=(ResultSet) q.executeQuery(); 
				 while(calsal.next())
				 {
					  sal=Integer.parseInt(calsal.getString(3));
					  System.out.println(sal);
				 }
				if(f instanceof SalesManger)
				{
				
					String sc="select* from salesmanger where id=?;";
					 PreparedStatement sp=con.prepareStatement(sc);
					 sp.setInt(1,id);
					 ResultSet scalsal=(ResultSet) sp.executeQuery(); 
					 while(scalsal.next())
					 {
						 int ints=Integer.parseInt(scalsal.getString(2));
						   b=sal+ints;
						   return b;
						   
					 }
				}
				
				else if(f instanceof Admin)
				{
					String in="select* from Admin where id=?;";
					 PreparedStatement gh=con.prepareStatement(in);
					 gh.setInt(1,id);
					 ResultSet acalsal=(ResultSet) gh.executeQuery(); 
					 while(acalsal.next())
					 {
						 int allow=Integer.parseInt(acalsal.getString(2));
						   b=sal+allow;
						   return b;
						   
					 }
				}
				else if(f instanceof Hr)
				{
					String ds="select* from Hr where id=?;";
					 PreparedStatement cv=con.prepareStatement(ds);
					 cv.setInt(1,id);
					 ResultSet hcalsal=(ResultSet) cv.executeQuery(); 
					 while(hcalsal.next())
					 {
						 int cm=Integer.parseInt(hcalsal.getString(2));
						   b=sal+cm;
						   return b;
						   
					 }
				}
				return b;
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
			}
		

		public void sortById() {
			// TODO Auto-generated method stub
	     /* IdSort i1=new IdSort();
			Collections.sort(arremployee,i1);
			System.out.println("sorting is");
			System.out.println(arremployee);*/
			String b="select*from employee order by id;";
			 PreparedStatement m;
			try {
				m = con.prepareStatement(b);
				ResultSet h=(ResultSet) m.executeQuery();
				 while(h.next())
				 {
					 System.out.println(h.getString(1));
					 System.out.println(h.getString(2));
					 System.out.println(h.getString(3));
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}

		public void sortByName() {
			/*
			NameSort n1=new NameSort();
			Collections.sort(arremployee,n1);
			System.out.println("sorting is");
			System.out.println(arremployee);*/
			String k="select*from employee order by name;";
			 PreparedStatement kk;
			try {
				kk= con.prepareStatement(k);
				ResultSet o=(ResultSet)kk.executeQuery();
				 while(o.next())
				 {
					 System.out.println(o.getString(1));
					 System.out.println(o.getString(2));
					 System.out.println(o.getString(3));
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}

		public void sortByExtraPayment() {
			// TODO Auto-generated method stub
			/*ExtraPaymentSort i1=new ExtraPaymentSort();
			Collections.sort(arremployee,i1);
			System.out.println("sorting is");
			System.out.println(arremployee);*/
			String p="select*from employee order by salary;";
			 PreparedStatement pp;
			try {
				pp= con.prepareStatement(p);
				ResultSet j=(ResultSet)pp.executeQuery();
				 while(j.next())
				 {
					 System.out.println(j.getString(1));
					 System.out.println(j.getString(2));
					 System.out.println(j.getString(3));
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		public boolean edit1(int id) {
			

				Employee es=this.search(id);
				if(es instanceof SalesManger)
				{
					SalesmangerEditFrame s1=new SalesmangerEditFrame(es);
					return true;
				}
				if(es instanceof Admin)
				{
					
					AdminEditFrame s2=new AdminEditFrame(es);
					return true;
				}
				if(es instanceof Hr)
				{
					
					HrEditFrame s3=new HrEditFrame(es);
					return true;
				}
				
				String sh="delete from employee where id=?;";
				 PreparedStatement ed;
				try {
					ed = con.prepareStatement(sh);
					ed .setInt(1,id);
					ed.executeQuery();
				 					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
		
	}				

}