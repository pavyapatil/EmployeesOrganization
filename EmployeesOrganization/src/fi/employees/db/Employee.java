package fi.employees.db;
import java.io.Serializable;
public abstract class Employee implements Serializable
{       
	 private static final long serialVersionUID =-7813537689952895471L; 
	
	   protected String name;
	   protected String address;
	   protected int age;
	   protected String gender;
	   protected float basicSalary;
	  
	
	   public Employee(String name,int age,String gender,String address,float basicSalary) {
			this.setName(name);
			this.setAge(age);
			this.setGender(gender);
			this.setAddress(address);
			this.setBasicSalary(basicSalary);
		}
	   
   public String getName() 
   {
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
		
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender) 
	{   
		
		this.gender = gender;
	}
	public float getBasicSalary()
	{
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) 
	{
		this.basicSalary = basicSalary;
	}
	

   
}