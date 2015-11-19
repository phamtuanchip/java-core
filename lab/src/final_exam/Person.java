package final_exam;

import java.io.Serializable;
import java.util.Date;

public class Person extends People implements Human, Serializable{
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
	
	public Date getDateOfBirth() {
		
		return DateOfBirth;
	}
	
	String getHomeTown() {
		
		return HomeTown;
	}
	
	public void setName(String n) {
		Name = n;
	}
	
	void setDOB(Date d) {
		DateOfBirth = d;
	}
	
	void setHome(String h) {
		HomeTown = h;
	}
	@Override
	public void setDateOfBirth(Date date) {
		DateOfBirth = date;
		
	}
	@Override
	public void setPlaceOfBirth(String place) {
		HomeTown = place;
		
	}
	@Override
	public String getPlaceOfBirth() {  
		return HomeTown;
	}
	@Override
	public void setId(int id) {
		id = this.hashCode();
		
	}
}
