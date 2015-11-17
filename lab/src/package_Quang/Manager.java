package package1;
import java.util.Date;

public class Manager extends Employee {
	double Bonus;
	String Role;
	void setBonus(double bo)
	{
		Bonus = bo;
	}
	
	double getBonus()
	{
		return Bonus;
	}
	void setRole(String ro)
	{
		Role = ro;
	}
	String getRole()
	{
		return Role;
	}
	
	public Manager()
	{
		
	}
	public Manager(String name, Date dob, String hometown, double salary, double  bonus, String role)
	{
		
			Name = name;
			DateOfBirth = dob;
			HomeTown = hometown;
			Salary = salary;
			Bonus = bonus;
			Role = role;	
			
			if (role == "PM") 
			{
				Bonus = 1500000;
			}
			else if (role == "TL")
			{
				Bonus = 1000000;
			}
			else bonus = 0;
			salary = salary + bonus;
		
	}


}
