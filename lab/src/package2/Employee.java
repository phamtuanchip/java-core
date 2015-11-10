package package2;

import java.util.Date;

public class Employee extends Person {
	double salary ; 
	 
	public Employee(String name, Date dob, String town, double salary){
		super(name, dob, town);
		this.salary = salary;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}  
	
	public double getSalary(){
		return salary;
	}
	
}
