package lmhung_final.package3;

import java.io.Serializable;
import java.util.Date;

public class Person implements Human, Serializable {
	String Name;
	Date  DateOfBirth = new Date();
	String Location;
	
	public Person() {
		
	}
	
	public Person(String name, Date dob, String town){
		Name = name;
		DateOfBirth = dob;
		Location = town;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}
	@Override
	public Date getDateOfBirth() {
		// TODO Auto-generated method stub
		return DateOfBirth;
	}
	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return Location;
	}
	public void setName(String n) {
		// TODO Auto-generated method stub
		Name = n;
	}
	@Override
	public void setDateOfBirth(Date d) {
		// TODO Auto-generated method stub
		DateOfBirth = d;
	}
	@Override
	public void setLocation(String p) {
		// TODO Auto-generated method stub
		Location = p;
	}	
}
