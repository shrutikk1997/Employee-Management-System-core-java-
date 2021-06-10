package view;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.MyWindowListener;
import db.DAOemployee;

public class SortFrame extends Frame implements ActionListener
{
   Button btid,btname,btextrapayment,btback;
	public SortFrame()  
	{
	btid=new Button("Sort by id");
	btname=new Button("sort by name");
	btextrapayment=new Button("sort by extra payment");
	btback=new Button("back");
	
	this.setVisible(true);
	this.setBounds(300,150,100,300);
	this.setLayout(new FlowLayout());
	this.setResizable(false);

	this.add(btid);
	this.add(btname);
	this.add(btextrapayment);
	this.add(btback);
	
	MyWindowListener mw = new MyWindowListener(this);
	this.addWindowListener(mw);
	btid.addActionListener(this);
	btname.addActionListener(this);
	btextrapayment.addActionListener(this);
	btback.addActionListener(this);
	

	
}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
          if(a.getSource()==btid)
          {
        	DAOemployee d1=new DAOemployee();
        	d1.sortById();
        	this.dispose();
          }
          else if(a.getSource()==btname)
          {
        	  DAOemployee d1=new DAOemployee();
          	d1.sortByName();
           
          }
          else if(a.getSource()==btextrapayment)
          {
        	  DAOemployee d1=new DAOemployee();
        	d1.sortByExtraPayment();
          }
          else if(a.getSource()==btback)
          {
        	  new Welcome();
          }
	}

}
