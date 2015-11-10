package nhvinh;
import java.util.Date;

public class Manager extends Employee{
	
	String Role;
	double Bonus;
	
	public Manager(String name, Date dob, String hometown, double d,String role)
	{
		Name=name;
		DateOfBirth = dob;
		HomeTown = hometown;
		salary=d;
		Role=role;
		if (Role=="PM")
		{
			System.out.println("Role == PM");
			Bonus=1500000;
		}
		else if(Role=="TL") 
		{
			Bonus=1000000;
		}
		else
		{
			Bonus=0;
		}
	}
	
	double getSalary()
	{
		return (salary+Bonus);
	}
	

}
