package final_exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	//TODO define static data list use to save and load db
	public static ArrayList<Employee> data = new ArrayList<>();
	
	public static int insertId() throws IDLengthIncorectExeption, IDIncorectExeption {
		System.out.println("In sert id:");
		Scanner si = new Scanner(System.in);
		String s = si.nextLine();
		int id = 0;
		if(s == null || s.length() != 6) throw new IDLengthIncorectExeption();
		try {		
			id = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new IDIncorectExeption();
		}  
		return id;		
	}
	
	public static String insertUserName() throws DataInputExeption{
		System.out.println("Insert Name:");
		Scanner si = new Scanner(System.in);
		String name = si.nextLine();
		if(name == null || name.isEmpty()) throw new DataInputExeption();
		return name;
	}
	public static String insertHomeTown() throws DataInputExeption{
		System.out.println("Insert home town:");
		Scanner si = new Scanner(System.in);
		String name = si.nextLine();
		si.close();
		if(name == null || name.isEmpty()) throw new DataInputExeption();
		return name;
	}
	
	public static String insertDataOfBirth() throws DataInputExeption{
		System.out.println("Insert data of birth dd/mm/yyyy:");
		Scanner si = new Scanner(System.in);
		String name = si.nextLine();
		if(name == null || name.isEmpty()) throw new DataInputExeption();
		return name;
	}
	
	public static double insertSalary() throws BaseSalaryException{
		System.out.println("Insert salary:");
		Scanner si = new Scanner(System.in);
		double salary = si.nextDouble();
		if(salary < 3100000) throw new BaseSalaryException();
		return salary;
	}
	
}
