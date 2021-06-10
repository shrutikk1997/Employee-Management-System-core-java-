package module;

import java.util.Comparator;

public class IdSort implements Comparator
{

	@Override
	public int compare(Object a1, Object a2) //here object from arraylist come one by one
	{
		// TODO Auto-generated method stub
		Employee e1=(Employee)a1;
		Employee e2=(Employee)a2;
		return e1.getId()-e2.getId();
	}

}
