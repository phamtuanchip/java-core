package package3;

import java.util.Date;

public class Person {
	String Name = "";
	Date DateOfBirth = new Date();
	String HomeTown = "";

	public Person(){
		
	}
	public Person(String name, Date dob, String town){
		Name = name;
		DateOfBirth = dob;
		HomeTown = town;
	}
public String getName() {
		
		return Name; 
	}
	
	Date getDateOfBirth() {
		
		return DateOfBirth;
	}
	
	String getHomeTown() {
		
		return HomeTown;
	}
	
	public	void setName(String n) {
		Name = n;
	}
	
	void setDOB(Date d) {
		DateOfBirth = d;
	}
	
	void setHome(String h) {
		HomeTown = h;
	}
}
