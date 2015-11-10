package package2;

import java.util.Date;

public class Manager extends Employee {
	String role;
	double bonus;
	
	 public Manager(String name, Date dob, String town, double salary, String role){
		 super(name, dob, town, salary);
		 this.role = role;
		 if(this.role.equals("TL")) bonus = 1000000;
		 else if(this.role.equals("PM")) bonus = 1500000;
		 else bonus = 0;
	 }

	 public void setRole(String role) {
		 this.role = role;
	 }
	 public String getRole(){
		 return role;
		 
	 }
	 
	 public double getSalary(){
		 return salary + bonus;
	 }
}
