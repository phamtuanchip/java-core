package final_exam;

import java.util.Date;

public class Employee extends Person implements Comparable<Employee> {
	double salary ; 
	 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
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

	@Override
	public int compareTo(Employee arg0) {		
		return this.Name.compareTo(arg0.Name);
	}
	
}
