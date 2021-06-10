package view;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.MyWindowListener;
import db.DAOuser;
import module.User;

public class Register extends Frame implements ActionListener
{
  Label lbusername,lbpassword,lbcity;
  TextField txusername,txpassword,txcity;
  Button btreset,btsubmit;
   public Register() 
 {
	this.lbusername=new Label("user name");
	this.lbpassword=new Label("password");
	this.lbcity=new Label("city");
	this.txusername=new TextField(20);
	this.txpassword=new TextField(20);
	this.txcity=new TextField(20);
	this.btreset=new Button("reset");
	this.btsubmit=new Button("submit");
	
	 this.setVisible(true);
	 this.setBounds(100, 200, 200, 400);
	 this.setLayout(new FlowLayout());
	 
	 
	 this.add(lbusername);
	 this.add(txusername);
	 this.add(lbpassword);
	 this.add(txpassword);
	 this.add(lbcity);
	 this.add(txcity);
	 
	 this.add(btsubmit);
	 this.add(btreset);
	 
	 MyWindowListener m1=new MyWindowListener(this);
	 this.addWindowListener(m1);
     btsubmit.addActionListener(this);
     btreset.addActionListener(this);
     txusername.addActionListener(this);
     txpassword.addActionListener(this);
     txcity.addActionListener(this);
 }
@Override
public void actionPerformed(ActionEvent a ) {
	// TODO Auto-generated method stub
	 if(a.getSource()==btsubmit)
	 {
		 User u1=new User();
		 u1.setUsername(txusername.getText());
		 u1.setPassword(txpassword.getText());
		 u1.setCity(txcity.getText());
		 
		 DAOuser d1=new DAOuser();
		 if(d1.insert(u1)==true)
		 {
			 JOptionPane.showMessageDialog(this,"registration successful");
			 this.dispose();
			 new LoginFrame();
		 
		 }
		 else
		 {
			 JOptionPane.showMessageDialog(this,"registration fail/full");
				
		 }
	
	 }
	 else if(a.getSource()==btreset)
	 {
	   this.dispose();
	   new Register();
	 }
	
}
   
}
