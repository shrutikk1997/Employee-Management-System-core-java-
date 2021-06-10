package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.MyWindowListener;
import db.DAOemployee;
import module.SalesManger;

public class SalesmangerFrame extends Frame implements ActionListener
{
    Label lbid,lbname,lbsal,lbtarget,lbintensive;
    TextField txid,txname,txsal,txtarget,txintensive;
    Button btsubmit,btreset;
    public SalesmangerFrame()
    {
    	lbid=new Label("enter id");
    	lbname=new Label("enter name");
    	lbsal=new Label("enter sal");
    	lbtarget=new Label("enter target");	
    	lbintensive=new Label("enter intensive");
    	txid=new TextField(10);
    	txname=new TextField(10);
    	txsal=new TextField(10);
    	txtarget=new TextField(10);
    	txintensive=new TextField(10);
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
    	 this.add(lbintensive);
    	 this.add(txintensive);
    	 this.add(lbtarget);
    	 this.add(txtarget);
    	 this.add(btsubmit);
    	 this.add(btreset);
    	 
    	 
    	 
    	 
    	 MyWindowListener m1=new MyWindowListener(this);
    	 this.addWindowListener(m1);
    	 
    	 btreset.addActionListener(this);
         btsubmit.addActionListener(this);
      
    }
	@Override
	public void actionPerformed(ActionEvent ar) {
		// TODO Auto-generated method stub
		if(ar.getSource()==btreset)
		{
			new SalesmangerFrame();
		}
		else if(ar.getSource()==btsubmit)
		{
			SalesManger s1=new SalesManger();
			s1.setId(Integer.parseInt(txid.getText()));
			s1.setName(txname.getText());
			s1.setSal(Integer.parseInt(txsal.getText()));
			s1.setIntensive(Integer.parseInt(txintensive.getText()));
			s1.setTarget(Integer.parseInt(txtarget.getText()));
			
			DAOemployee e1=new DAOemployee();
			
			if(e1.insert(s1)==true)
			{
				JOptionPane.showMessageDialog(this, "Salesmanger added successfully");
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
