package lab1;

import java.util.Date;

public class Person {
	String name;
	boolean sex;
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public float getWeigh() {
		return weigh;
	}

	public void setWeigh(float weigh) {
		this.weigh = weigh;
	}
	Date date_of_birth;
	float weigh;
	
	Person(){
		
	}
	
	Person(String name, Date dob, boolean sex){
		
	}
	
	Person(String name, Date dob, boolean sex, float weight){
		
	}
	
	void setName(String name) { this.name = name;}
	String getName() { return name;}
	
}
