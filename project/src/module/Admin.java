package module;

public class Admin extends Employee
{
	int allowence;
    public Admin() {
		super();
		this.allowence = 0;
	}
    
	public Admin(int allowence) {
		super();
		this.allowence = allowence;
	}
	public int getAllowence() {
		return allowence;
	}
	public void setAllowence(int allowence) {
		this.allowence = allowence;
	}

	@Override
	public String toString() {
		return "Admin \nallowence=" + allowence + ", \nid=" + id + "\n name=" + name + ",\n sal=" + sal ;
	}

	@Override
	public  int calSal() {
		// TODO Auto-generated method stub
		int a=(int) (this.sal+this.allowence);
		return a;
	}

	
    
}
