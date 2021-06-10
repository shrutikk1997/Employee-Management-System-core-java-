package module;

abstract public class Employee 
{
    int id;
    String name;
    double sal;
    
	public Employee()
	{
		this.id = 0;
		this.name = "";
		this.sal = 0;

	}

		public Employee(int id, String name, double sal) 
	{
	
		this.id = id;
		this.name = name;
		this.sal = sal;
	}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getSal() {
			return sal;
		}

		public void setSal(double sal) {
			this.sal = sal;
		}

    public abstract int calSal();
}


