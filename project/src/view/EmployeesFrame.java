package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.MyWindowListener;

public class EmployeesFrame extends Frame implements ActionListener 
{
	Label lbselect;
	Button btsalesmanger,btadmin,bthr,btback;
	public EmployeesFrame()
	{
		lbselect=new Label("Select type of Employee");
		btsalesmanger=new Button("1.Salesmanger");
		btadmin=new Button("2.Admin");
		bthr=new Button("3.hr");
		btback=new Button("back");
		 this.setVisible(true);
		 this.setBounds(100, 200, 40, 400);
		 this.setLayout(new FlowLayout());
		 
		 
		 this.add(lbselect);
		 this.add(btsalesmanger);
		 this.add(btadmin);
		 this.add(bthr);
		 this.add(btback);
		
		 MyWindowListener m1=new MyWindowListener(this);
		 this.addWindowListener(m1);
		 btsalesmanger.addActionListener(this);
		 btadmin.addActionListener(this);
		 bthr.addActionListener(this);
		 btback.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==btsalesmanger)
		{
			new view.SalesmangerFrame();
			this.dispose();
			
		}
		else if(a.getSource()==btadmin)
		{
			new view.AdminFrame();
			this.dispose();
			
		}
		else if(a.getSource()==bthr)
		{
			new view.HrFrame();
			this.dispose();
			
	
		}
		else if(a.getSource()==btback)
		{
			new Welcome();
		}
	}

}
