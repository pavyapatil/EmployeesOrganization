package fi.employees.db;

public class Engineer extends Employee
{
	private static final long serialVersionUID = -6775284097941769559L;
    private float overtime;
    
    public Engineer(String name,int age,String gender,String address,float basicSalary,float overtime) {
		super(name,age,gender,address,basicSalary);
		this.setOvertime(overtime);
	}
 
public float getOvertime() 
{
	return overtime;
}

public void setOvertime(float overtime)
{
	this.overtime = overtime;
}
}
