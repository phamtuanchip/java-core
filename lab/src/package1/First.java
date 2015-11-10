package package1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class First {

	public static void main(String[] args) {
		System.out.println ("Hello");		
		Employee e = new Employee();
		e.setDOB(new Date());
		e.setName("Employee 1");
		e.setHome("Hanoi");
		System.out.println("Name " + e.getName());
		System.out.println("Home " + e.getHomeTown());
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Name " + sf.format(e.getDateOfBirth()));
	}
}





