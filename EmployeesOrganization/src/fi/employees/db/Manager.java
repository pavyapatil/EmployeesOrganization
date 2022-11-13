package fi.employees.db;

public class Manager extends Employee
{   
	private static final long serialVersionUID = 7221276447563724106L;
	private float hra;
   
	public Manager(String name,int age,String gender,String address,float basicSalary,float hra) {
		super(name,age,gender,address,basicSalary);
		this.setHra(hra);
	}

public float getHra()
    {
		return hra;
	}

	public void setHra(float hra) 
	{
		this.hra = hra;
	}

  
}
