package package1;
import java.util.Date;

public class Employee extends Person {
	double  Salary;
	public Employee()
	{
		
	}
	public Employee(String name, Date dob, String hometown, double salary )
	{
		Name = name;
		DateOfBirth = dob;
		HomeTown = hometown;
	}

	void setSalary(double s)
	{
		Salary = s;
	}
	double getSalary()
	{
		return Salary;
	}
	

}
