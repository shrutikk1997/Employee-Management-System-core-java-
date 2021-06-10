package module;

public class SalesManger extends Employee
{
	int intensive;
	 int target;
	
	 public SalesManger() {
		super();
		this.intensive =0;
		this.target =0;

	}
	public SalesManger(int id,String name,int sal,int intensive, int target)
	{
		super();
		this.intensive = intensive;
		this.target = target;
	}
	public int getIntensive() {
		return intensive;
	}
	public void setIntensive(int intensive) {
		this.intensive = intensive;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	@Override
	public String toString() {
		return " \nid" +id +"\n name" +name +"\n sal"+sal+"\n intensive"+intensive+"\n target"+target;
				
	}
	@Override
	public int calSal() {
		// TODO Auto-generated method stub
		int a=(int) (this.sal+this.intensive);
		return a;
	}

}
