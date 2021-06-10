package module;

import java.util.Comparator;

public class NameSort  implements Comparator
{

	@Override
	public int compare(Object a1, Object a2) {
		// TODO Auto-generated method stub
		Employee e1=(Employee)a1;
		Employee e2=(Employee)a2;
		return  e1.getName().compareTo(e2.getName());
	
	
	}

}
