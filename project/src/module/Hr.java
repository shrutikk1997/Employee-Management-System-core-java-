package module;

public class Hr extends Employee
{
      int comission;

	public Hr() {
		super();
		this.comission =0;
	}

	public Hr(int comission) {
		super();
		this.comission = comission;
	}

	public int getComission() {
		return comission;
	}

	public void setComission(int comission) {
		this.comission = comission;
	}

	@Override
	public String toString() {
		return "Hr [comission=" + comission + ", id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}

	@Override
	public int calSal() {
		// TODO Auto-generated method stub
		int a=(int) (this.sal+this.comission);
		return a;
	}
      
}
