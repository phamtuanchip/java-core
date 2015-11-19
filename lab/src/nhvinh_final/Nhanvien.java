package nhvinh_final;

import java.io.Serializable;
import java.util.Date;

public class Nhanvien implements Serializable
{
	
	String Name = "";
	Date DateOfBirth = new Date();
	String HomeTown = "";
	double salary ;
	
	public Nhanvien()
		{
			
		}
	
	public Nhanvien(String name, Date dob, String town, double salary)
		{
			this.Name=name;
			DateOfBirth=dob;
			HomeTown=town;
			this.salary = salary;
		}
	void setName(String n)
		{
			Name = n;
		}
	public String getName() 
		{
			return Name; 
		}
	
	void setDOB(Date d) 
		{
			DateOfBirth = d;
		}
	
	public Date getDateOfBirth()
		{
			return DateOfBirth;
		}
		
	void setHome(String h) 
		{
			HomeTown = h;
		}
	public String getHomeTown()
		{
			return HomeTown;
		}
	
	
	 void setSalary(double salary)
		{
			this.salary = salary;
		}  
	
	public double getSalary()
		{
			return salary;
		}
	
	public String toString() {
		return (getName() + "\n" + getDateOfBirth().toString() + "\n" + getHomeTown() + "\n" + getSalary() + "\n"); 
	}
}
