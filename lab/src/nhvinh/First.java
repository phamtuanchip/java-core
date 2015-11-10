package nhvinh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class First {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println ("Hello");		
	
		
		Employee e;
		Manager m1;
		Manager m2;
		try {
			
			e = new Employee("Nguyen van A", sf.parse("10/11/1991") ,"Ha Noi",5000000);
		
		//e.setDOB(new Date());
		//e.setName("Employee 1");
		//e.setHome("Hanoi");
		System.out.println("Name " + e.getName()); 
		System.out.println("Home " + e.getHomeTown());
		
		System.out.println("Date " + sf.format(e.getDateOfBirth()));
		System.out.println("Salary " + e.getSalary());
		
		System.out.println("");
		
		m1 =new Manager("Nguyen Van M", sf.parse("10/11/1981"),"Ha Noi", 6000000, "PM");
		
		System.out.println("Name " + m1.getName()); 
		System.out.println("Home " + m1.getHomeTown());
		
		System.out.println("Date " + sf.format(m1.getDateOfBirth()));
		System.out.println("Salary " + m1.getSalary());
		
		System.out.println("");
		
		m2 =new Manager("Nguyen Van T", sf.parse("10/11/1980"),"Ha Noi", 6000000, "TL");
		
		System.out.println("Name " + m2.getName()); 
		System.out.println("Home " + m2.getHomeTown());
		
		System.out.println("Date " + sf.format(m1.getDateOfBirth()));
		System.out.println("Salary " + m2.getSalary());
		
		//****************************************************************
		/*Car car1=new Car();
		car1.setModel("Civic");
		car1.setColor("Red");
		car1.setBrand("Honda");
		System.out.println("");
		System.out.println("Model: " + car1.getModel());
		System.out.println("Color: " + car1.getColor());
		System.out.println("Brand: " + car1.getBrand());
		*/
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
