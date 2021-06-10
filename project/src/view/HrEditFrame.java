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
import module.Employee;
import module.Hr;

public class HrEditFrame  extends Frame implements ActionListener
{
	Label lbid,lbname,lbsal,lbcommision;

    TextField txid,txname,txsal,txcommision;
   Button btsubmit,btreset;

			public HrEditFrame(Employee e1) {
				// TODO Auto-generated constructor stub
				lbid=new Label("enter id");
		    	lbname=new Label("enter name");
		    	lbsal=new Label("enter sal");
		    	lbcommision=new Label("enter commision");	
		    
		    	txid=new TextField(10);
		    	txname=new TextField(10);
		    	txsal=new TextField(10);
		    	txcommision=new TextField(10);
		    	
		    	btsubmit=new Button("submit");
		    	btreset=new Button("reset");
		    	txid.setText(Integer.toString(e1.getId()));
		    	txid.setEditable(false);
		    	 this.setVisible(true);
		    	 this.setBounds(100, 200, 250, 400);
		    	 this.setLayout(new FlowLayout());
		    	 
		    	 
		    	 this.add(lbid);
		    	 this.add(txid);
		    	 this.add(lbname);
		    	 this.add(txname);
		    	 this.add(lbsal);
		    	 this.add(txsal);
		    	 this.add(lbcommision);
		    	 this.add(txcommision);
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
					new SalesmangerFrame();
				}
				else if(a.getSource()==btsubmit)
				{
					Hr h1=new Hr();
					h1.setId(Integer.parseInt(txid.getText()));
					h1.setName(txname.getText());
					h1.setSal(Integer.parseInt(txsal.getText()));
					h1.setComission(Integer.parseInt(txcommision.getText()));
					
					DAOemployee e1=new DAOemployee();
					if(e1.insert(h1)==true)
					{
						JOptionPane.showMessageDialog(this, "hr edited successfully");
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
