package package2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class First {

	public static void main(String[] args) {

		
		String s1 = "PM" ;
		String s2 = "PM" ;
		System.out.println("S1== S2 " + (s1 == s2));
		
		System.out.println("S1== PM " + (s1 == "PM"));
		 
		System.out.println("PM == PM " + ("PM" == "PM"));
		
		System.out.println("S1.equals(S2) " + s1.equals(s2));
		
		String s3 = new String("PM") ;
		String s4 = new String("PM") ;
		
		System.out.println("S3== S4 " + (s3 == s4));
		System.out.println("S3.equals(S4) " + s3.equals(s4));
		
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			//e.setDOB(sf.parse("10/11/1991"));
			//e.setName("Nguyen Van A");
			//e.setHome("Hanoi");
			//e.setSalary(5000000);
			Employee e = new Employee("Nguyen Van A", sf.parse("10/11/1991"), "Hanoi", 5000000);
			Manager m1 = new Manager("Nguyen Van M", sf.parse("10/11/1981"), "Hanoi", 5000000, "TL");
			Manager m2 = new Manager("Nguyen Van T", sf.parse("10/11/1980"), "Hanoi", 5000000, "PM");
			System.out.println("Ho ten \t\t\t Ngay sinh \t vai tro \t luong \t\t thuong \t thuc linh");
			System.out.println(e.getName() +"\t\t" + sf.format(e.getDateOfBirth()) + " \t\t\t "+e.getSalary()+" \t\t\t" + e.getSalary());
			System.out.println(m1.getName() +"\t\t" + sf.format(m1.getDateOfBirth()) + " \t"+m1.getRole()+"\t\t "+m1.salary+" \t"+m1.bonus+"\t" + m1.getSalary());
			System.out.println(m2.getName() +"\t\t" + sf.format(m2.getDateOfBirth()) + " \t"+m2.getRole()+"\t\t "+m2.salary+" \t"+m2.bonus+"\t" + m2.getSalary());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}





