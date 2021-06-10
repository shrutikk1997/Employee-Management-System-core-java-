package view;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.MyWindowListener;
import db.DAOemployee;
import module.Admin;

public class AdminFrame extends Frame implements ActionListener
{ 
	Label lbid,lbname,lbsal,lballowence;

      TextField txid,txname,txsal,txallowence;
     Button btsubmit,btreset;


		    public AdminFrame()
		    {
		    	lbid=new Label("enter id");
		    	lbname=new Label("enter name");
		    	lbsal=new Label("enter sal");
		    	lballowence=new Label("enter allowence");	
		    
		    	txid=new TextField(10);
		    	txname=new TextField(10);
		    	txsal=new TextField(10);
		    	txallowence=new TextField(10);
		    	
		    	btsubmit=new Button("submit");
		    	btreset=new Button("reset");
		    	
		    	 this.setVisible(true);
		    	 this.setBounds(100, 200, 250, 400);
		    	 this.setLayout(new FlowLayout());
		    	 
		    	 
		    	 this.add(lbid);
		    	 this.add(txid);
		    	 this.add(lbname);
		    	 this.add(txname);
		    	 this.add(lbsal);
		    	 this.add(txsal);
		    	 this.add(lballowence);
		    	 this.add(txallowence);
		    	 this.add(btsubmit);
		    	 this.add(btreset);
		    	 
		    	 
		    	 
		    	 
		    	 MyWindowListener m1=new MyWindowListener(this);
		    	 this.addWindowListener(m1);
		    	 
		    	 btreset.addActionListener(this);
		         btsubmit.addActionListener(this);
		      
		    
	
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==btreset)
		{
			new AdminFrame();
		}
		else if(a.getSource()==btsubmit)
		{
			Admin a1=new Admin();
			a1.setId(Integer.parseInt(txid.getText()));
			a1.setName(txname.getText());
			a1.setSal(Integer.parseInt(txsal.getText()));
			a1.setAllowence(Integer.parseInt(txallowence.getText()));
			DAOemployee d1=new DAOemployee();
			if(d1.insert(a1)==true)
			{
				JOptionPane.showMessageDialog(this, "admin added successfully");
				this.dispose();
				new EmployeesFrame();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "fail");
			}
		}
	}
	
	}
