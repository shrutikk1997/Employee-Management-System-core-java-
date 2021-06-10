package module;

import java.util.Comparator;

public class ExtraPaymentSort implements Comparator
{

	@Override
	public int compare(Object a1, Object a2) {
		// TODO Auto-generated method stub
		if(a1 instanceof SalesManger &&(a2 instanceof Admin||a2 instanceof SalesManger|| a2 instanceof Hr))
		{
			SalesManger s1=(SalesManger)a1;
			if(a2 instanceof Admin)
			{
				Admin ad=(Admin)a2;
				return s1.getIntensive()-ad.getAllowence();
			}
			else if(a2 instanceof Hr)
			{
				Hr h1=(Hr)a2;
				return s1.getIntensive()-h1.getComission();
			}
			else if(a2 instanceof  SalesManger)
			{
				SalesManger sm=(SalesManger)a2;
				return s1.getIntensive()-sm.getIntensive();
			}
			
		}
		else if(a1 instanceof Admin &&(a2 instanceof Admin||a2 instanceof SalesManger|| a2 instanceof Hr))
		{
			Admin s1=(Admin)a1;
			if(a2 instanceof Admin)
			{
				Admin ad=(Admin)a2;
				return s1.getAllowence()-ad.getAllowence();
			}
			else if(a2 instanceof Hr)
			{
				Hr h1=(Hr)a2;
				return s1.getAllowence()-h1.getComission();
			}
			else if(a2 instanceof  SalesManger)
			{
				SalesManger sm=(SalesManger)a2;
				return s1.getAllowence()-sm.getIntensive();
			}
			
		}
		else if(a1 instanceof Hr &&(a2 instanceof Admin||a2 instanceof SalesManger|| a2 instanceof Hr))
		{
			Hr s1=(Hr)a1;
			if(a2 instanceof Admin)
			{
				Admin ad=(Admin)a2;
				return s1.getComission()-ad.getAllowence();
			}
			else if(a2 instanceof Hr)
			{
				Hr h1=(Hr)a2;
				return s1.getComission()-h1.getComission();
			}
			else if(a2 instanceof  SalesManger)
			{
				SalesManger sm=(SalesManger)a2;
				return s1.getComission()-sm.getIntensive();
			}
			
		}
		return 0;
		
	

	}

}
