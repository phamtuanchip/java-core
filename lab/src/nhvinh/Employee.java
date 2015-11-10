package nhvinh;

import java.util.Date;

public class Employee extends Person{
	
	double salary=10000.0;
	

	public Employee(){
		
	}
	//constructor of Employee class
	public Employee(String name, Date dob, String hometown, double d)
	{
		Name=name;
		DateOfBirth = dob;
		HomeTown = hometown;
		salary=d;
	}
	
	void setSalary(double d)
	{
		salary=d;
	}
	double getSalary()
	{
		return salary;
		
	
	}
//*/
}
