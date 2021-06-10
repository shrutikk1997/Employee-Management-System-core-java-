package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.MyWindowListener;
import db.DAOuser;
import module.User;


public class LoginFrame extends Frame implements  ActionListener
{
  Label lbusername,lbpassword;
  Button btsubmit,btregister;
  TextField txusername,txpassword;
   public LoginFrame() 
   {
	this.lbusername=new Label("user name");
	this.lbpassword=new Label("password");
	this.btsubmit=new Button("submit");
	this.btregister=new Button("register");
	 this.txusername=new TextField(20);;
	 this.txpassword=new TextField(20);
	 
	 this.setVisible(true);
	 this.setBounds(100, 200, 300, 400);
	 this.setLayout(new FlowLayout());
	 
	 
	 this.add(lbusername);
	 this.add(txusername);
	 this.add(lbpassword);
	 this.add(txpassword);
	 this.add(btsubmit);
	 this.add(btregister);
	 
	 MyWindowListener m1=new MyWindowListener(this);
	 this.addWindowListener(m1);
	 
	 btregister.addActionListener(this);
     btsubmit.addActionListener(this);
   }
@Override
public void actionPerformed(ActionEvent a) {
	// TODO Auto-generated method stub
	if(a.getSource()==btregister)
	{
		new Register();
		this.dispose();
	}
	else if(a.getSource()==btsubmit)
		
	{
		if(txusername.getText().equals("")||txpassword.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this, "enter username or password");
		}
		User u1=new User();
		u1.setUsername(txusername.getText());
		u1.setPassword(txpassword.getText());
		DAOuser d1=new DAOuser();
	if(d1.validateuser(u1)==true)
		{
			JOptionPane.showMessageDialog(this, "login successful");
	      new Welcome();
	      this.dispose();
		}
	else
	{
		JOptionPane.showMessageDialog(this, "login fail");
	}
		
	}
	
   }
public static void main(String[] args) {
	LoginFrame l=new LoginFrame();
}
   }












