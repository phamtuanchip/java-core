package package4;

import java.util.Date;

public class Person implements Human{
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPlaceOfBirth(String place) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getPlaceOfBirth() {
		// TODO Auto-generated method stub
		return null;
	}
}
