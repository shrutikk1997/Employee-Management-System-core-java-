package view;

import java.awt.*;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.MyWindowListener;
import module.Admin;
import module.Employee;
import module.Hr;
import module.SalesManger;

public class SearchResult extends Frame implements ActionListener
{
	Label lbid,lbname,lbsal,lbintensive,lbtarget,lbcommision,lballowence;

	TextField lbsid,lbsname,lbssal,lbsintensive,lbstarget,lbscommision,lbsallowence;

	

	public SearchResult(Employee e1) 
	{
		lbid=new Label("id");
		lbname=new Label("name");
		lbsal=new Label("sal");
		lbintensive=new Label("intensive");
		lbtarget=new Label("target");
		lbcommision=new Label("commision");
		lballowence=new Label("allowence");
		lbsid=new TextField(20);
		lbsname=new TextField(20);
		lbssal=new TextField(20);
		lbsintensive=new TextField(20);
		lbstarget=new TextField(20);
		lbscommision=new TextField(20);
		lbsallowence=new TextField(20);
		
		lbsid.setText(Integer.toString(e1.getId()));
		lbsname.setText(e1.getName());
		lbssal.setText(Double.toString(e1.getSal()));
		this.add(lbid);
		this.add(lbsid);
		this.add(lbname);
		this.add(lbsname);
		this.add(lbsal);
		this.add(lbssal);
		if(e1 instanceof SalesManger)
		{
			SalesManger s1=(SalesManger)e1;
	
			lbsintensive.setText(Integer.toString(s1.getIntensive()));
			lbstarget.setText(Integer.toString(s1.getTarget()));
			this.add(lbintensive);
			this.add(lbsintensive);
			this.add(lbtarget);
			this.add(lbstarget);
			
		}
		else if(e1 instanceof Admin)
		{
		  Admin a1=(Admin)e1;
		  lbsallowence.setText(Integer.toString(a1.getAllowence()));
		  this.add(lballowence);
		  this.add(lbsallowence);
		}
		else if(e1 instanceof Hr)
		{
			Hr h1=(Hr)e1;
			lbscommision.setText(Integer.toString(h1.getComission()));
			this.add(lbcommision);
			this.add(lbscommision);
		}
		 this.setVisible(true);
		 this.setBounds(100, 200, 200, 400);
		 this.setLayout(new FlowLayout());
		
		 MyWindowListener m1=new MyWindowListener(this);
		 this.addWindowListener(m1);
	    
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
