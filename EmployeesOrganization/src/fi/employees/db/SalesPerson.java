package fi.employees.db;

public class SalesPerson extends Employee
{
	private static final long serialVersionUID = 1832212228422559937L;
	private float commision;
	
	public SalesPerson(String name,int age,String gender,String address,float basicSalary,float commision) {
		super(name,age,gender,address,basicSalary);
		this.setCommision(commision);
	}
	
	public float getCommision()
    {
		return commision;
	}

	public void setCommision(float commision)
	{
		this.commision = commision;
	}


}
