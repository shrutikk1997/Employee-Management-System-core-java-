package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.MyWindowListener;

public class CalSalResult extends Frame implements ActionListener
{
     Label lbtext;
     TextField txoutput;
     Button btback;
	public CalSalResult(int a,int id)
	{
	   lbtext=new Label("Salary of Employee"+id+"is:");
	   txoutput=new TextField(10);
	   txoutput.setText(Integer.toString(a));
	   btback=new Button("back");
	   
	   this.setVisible(true);
  	 this.setBounds(100, 200, 50, 400);
  	 this.setLayout(new FlowLayout());
  	 
  	 
  	 this.add(lbtext);
  	 this.add(txoutput);
  	 this.add(btback);
  	MyWindowListener mw = new MyWindowListener(this);
	this.addWindowListener(mw);
	btback.addActionListener(this);
	
  	
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==btback)
		{
			this.dispose();
			new Welcome();
		}
	}
     
}
