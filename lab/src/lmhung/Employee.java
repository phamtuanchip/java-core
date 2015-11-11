package lmhung;

import java.util.Date;

public class Employee extends Person {
	double Salary;
	
	public Employee () {
		
	}

	public Employee(String name, Date dob, String hometown, double salary ) {
		Name = name;
		DateOfBirth = dob;
		HomeTown = hometown;
		Salary = salary;
	}
	
	double getSalary() {
		
		return Salary;
	}
	
	void setSalary(double slr) {
		
		Salary = slr;
	}	

}
