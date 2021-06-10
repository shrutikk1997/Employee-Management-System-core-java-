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
import module.Employee;
import module.Hr;
import module.SalesManger;

public class EditFrame extends Frame implements ActionListener {
	Label lbid;
	TextField txid;
	Button btsearch,btback;
	public EditFrame() 
	{
		 lbid=new Label("enter id");
         txid=new TextField(10);
         btsearch=new Button("Edit");
         btback=new Button("back");
        
         
         this.setVisible(true);
    	 this.setBounds(100, 200, 50, 400);
    	 this.setLayout(new FlowLayout());
    	 
    	 
    	 this.add(lbid);
    	 this.add(txid);
    	 this.add(btsearch);
    	 
    	 this.add(btback);
    	 
    	 MyWindowListener m1=new MyWindowListener(this);
    	 this.addWindowListener(m1);
    	 
    	 btsearch.addActionListener(this);
    	 
         btback.addActionListener(this);
      
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==btsearch)
		{
		    int id=Integer.parseInt(txid.getText());
		     DAOemployee d1=new DAOemployee();
		     
		   if(d1.edit1(id)!=false)
		   {
			   JOptionPane.showMessageDialog(this, "id found");
		   }
		   else
		   {
			   JOptionPane.showMessageDialog(this, "id not found");
		   }
		   }
		     else if(a.getSource()==btback)
		{
			
			this.dispose();
			new Welcome();
		}
		}

}
