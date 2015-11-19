package nvquang_final;

import java.io.Serializable;
import java.util.Date;

public class Employee extends Person implements Serializable  {
	double salary ; 
	 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, Date dob, String livePlace, double salary){
		super(name, dob, livePlace);
		this.salary = salary;
	}
	
	public double setSalary(double salary){
		//this.salary = salary;
		return this.salary = salary;
	}  
	
	public double getSalary(){
		return salary;
	}

}
