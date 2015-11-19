package nvquang_final;

import java.util.Date;

public class Person implements Human {
	String Name = "";
	Date DateOfBirth = new Date();
	String HomelivePlace = "";

	public Person(){
		
	}
	public Person(String name, Date dob, String livePlace){
		Name = name;
		DateOfBirth = dob;
		HomelivePlace = livePlace;
	}
	public String getName() {
		
		return Name; 
	}
	
	public Date getDateOfBirth() {
		
		return DateOfBirth;
	}
	
//	public String getlivePlace() {
//		
//		return HomelivePlace;
//	}
	
	public String setName(String n) {
		return Name = n;
	}
	
//	void setDOB(Date d) {
//		DateOfBirth = d;
//	}
//	
//	void setHome(String h) {
//		HomelivePlace = h;
//	}
	
	public Date setDateOfBirth(Date date) {
		return DateOfBirth = date;
		
	}
	
	public String setLivePlace(String place) {
		return HomelivePlace = place;

}
	
	public String getLivePlace() {
		// TODO Auto-generated method stub
		return HomelivePlace;
	}

	}

