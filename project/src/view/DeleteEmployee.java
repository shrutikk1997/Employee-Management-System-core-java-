package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import control.MyWindowListener;
import db.DAOemployee;

public class DeleteEmployee extends Frame implements ActionListener
{
	Label lbid;
	TextField txid;
	Button btsubmit,btback;
	public DeleteEmployee() 
	{
		 lbid=new Label("enter id");
         txid=new TextField(10);
         btsubmit=new Button("Delete");
         btback=new Button("back");
         
         this.setVisible(true);
    	 this.setBounds(100, 200, 50, 400);
    	 this.setLayout(new FlowLayout());
    	 
    	 
    	 this.add(lbid);
    	 this.add(txid);
    	 this.add(btsubmit);
    	 this.add(btback);
    	 
    	 MyWindowListener m1=new MyWindowListener(this);
    	 this.addWindowListener(m1);
    	 
    	 btsubmit.addActionListener(this);
         btback.addActionListener(this);
      
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==btsubmit)
		{
			
          int id=Integer.parseInt(txid.getText());			
		  DAOemployee d1=new DAOemployee();
		 if( d1.delete(id)==true)
		 {
			 JOptionPane.showMessageDialog(this, "id  found & deleted successfully");
			 this.dispose();
			 new Welcome();
		 }
		 else
		 {
			 JOptionPane.showMessageDialog(this, "id not found");
			 this.dispose();
			 new Welcome();
			 
		 }
		
		}
		else if(a.getSource()==btback)
		{
			
			this.dispose();
			new Welcome();
		}
	}
	

}
