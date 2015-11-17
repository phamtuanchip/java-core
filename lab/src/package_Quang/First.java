package package1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class First {

	public static void main(String[] args) {
		System.out.println ("Hello");		
		Employee e = new Employee();
		Manager m1 = new Manager();
		Manager m2 = new Manager();
		e.setDOB(new Date());
		e.setName("Nguyen Van A");
		e.setHome("Hanoi");
		e.setSalary(5000000);
		m1.setBonus(0);
		m1.setRole("TL");
		m1.setName("Nguyen Van M");
		m1.setSalary(6000);
		m2.setBonus(0);
		m2.setRole("TL");
		m2.setName("Nguyen Van T");
		m2.setSalary(7000);
		
		System.out.println("Name " + e.getName());
		System.out.println("Home " + e.getHomeTown());
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Name " + sf.format(e.getDateOfBirth()));
		System.out.println("Salary: " + e.getSalary());
		System.out.println("Manager Name: " + m1.getName());
		System.out.println("Bonus: " + m1.getBonus());
		System.out.println("Bonus: " + m1.Bonus);
		System.out.println("Roles: " + m1.getRole());
		System.out.println("Manager Salary: " + m1.getSalary());
		System.out.println("Manager Name: " + m1.getName());
		System.out.println("Bonus: " + m2.getBonus());
		System.out.println("Bonus: " + m2.Bonus);
		System.out.println("Roles: " + m2.getRole());
		System.out.println("Manager Salary: " + m2.getSalary());
	}
}





