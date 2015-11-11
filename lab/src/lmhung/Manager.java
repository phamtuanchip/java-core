package lmhung;

import java.util.Date;

public class Manager extends Employee {
	double Bonus;
	String Role;
	
	public Manager(String name, Date dob, String hometown, double salary, String role) {
		Name = name;
		DateOfBirth = dob;
		HomeTown = hometown;
		Salary = salary;
		
		if (role == "PM") {
			Bonus = 1500000;
		}
		else if (role == "TL") {
			Bonus = 1000000;
		}
		else {
			Bonus = 0;
		}
	}
	
	double getSalary() {
		
		return (Salary + Bonus);
	}
	
	double getBonus() {
		
		return Bonus;
	}
	
	void setBonus(double b) {
		Bonus = b;
	}
	
	
	
}
