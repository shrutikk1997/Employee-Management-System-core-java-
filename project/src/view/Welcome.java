package view;

import java.awt.*;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.MyWindowListener;
import module.User;

public class Welcome extends Frame implements ActionListener
{
Label lbWelcome;
Button btadd,btremove,btsearch,btedit,btsort,btcal;
	

	public Welcome() {
		// TODO Auto-generated constructor stub
		
		this.btadd=new Button("Add Employee");
		this.btremove=new Button("remove Employee");
		this.btsearch=new Button("Search Employee");
		this.btedit=new Button("Edit Employee");
		this.btsort=new Button("Sort");
		this.btcal=new Button("calculate Salary");
		this.setVisible(true);
		this.setBounds(300,150,100,300);
		this.setLayout(new FlowLayout());
		this.setResizable(false);

		lbWelcome = new Label("Welcome on Home Page ");
		
		this.add(lbWelcome);
		this.add(btadd);
		this.add(btremove);
		this.add(btsearch);
		this.add(btedit);
		this.add(btsort);
		this.add(btcal);
		MyWindowListener mw = new MyWindowListener(this);
		this.addWindowListener(mw);
		btadd.addActionListener(this);
		btremove.addActionListener(this);
		btsearch.addActionListener(this);
		btedit.addActionListener(this);
		btsort.addActionListener(this);
		btcal.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==btadd)
		{
			new view.EmployeesFrame();
			this.dispose();
		}
		else if(a.getSource()==btremove)
		{
			new view.DeleteEmployee();
			this.dispose();
		}
		else if(a.getSource()==btsearch)
		{
			new view.SearchEmployee();
			this.dispose();
		}
		else if(a.getSource()==btedit)
		{
              new view.EditFrame();
		}
		else if(a.getSource()==btsort)
		{
			new view.SortFrame();
			this.dispose();
		}
		else if (a.getSource()==btcal)
		{
			new view.CalSalFrame();
			this.dispose();
		}
	}
public static void main(String[] args) {
	Welcome w1=new Welcome();
}	
}
