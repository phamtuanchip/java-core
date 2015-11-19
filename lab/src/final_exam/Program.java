package final_exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	ArrayList<Employee> list = Input.data;

	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
	public void insertEmployee() {
		String exist = "N"; 
		while("N".equalsIgnoreCase(exist)) {			
			Employee e = new Employee();
			boolean correct = false;
			System.out.println(" Employee thu " + (list.size() +1));
			//TODO repeat insert 
			while (!correct) {
				try {

					e.setName(Input.insertUserName());
					correct = true;
				} catch (DataInputExeption e1) {
					System.out.println(e1.getMessage());
					//e1.printStackTrace();
				}		
			}
			correct = false;
			//TODO repeat insert 
			while(!correct)
				try {
					try {
						e.setDateOfBirth(sf.parse(Input.insertDataOfBirth()));
						correct = true;
					} catch (ParseException e1) {
						System.out.println(e1.getMessage() + "Date format dd/mm/yyyy");
					}
				} catch (DataInputExeption e1) {
					System.out.println(e1.getMessage());
				}	
			correct = false;
			//TODO repeat insert 
			while(!correct)
				try {
					e.setSalary(Input.insertSalary());
					correct = true;
				} catch (BaseSalaryException e1) {
					System.out.println(e1.getMessage());
				}

			list.add(e);
			System.out.println("Do you want to exit? y/n ");
			Scanner si = new Scanner(System.in);
			exist = si.next();	
			//TODO Save db before exits 
			if("Y".equalsIgnoreCase(exist)) saveEmployee();
		}
	}

	public void displayEmployee() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Ho ten \t\t Ngay sinh\t\t thuc linh");
		for(Employee e: list)
			System.out.println(e.getName() +"\t\t" + sf.format(e.getDateOfBirth()) + " \t\t" + e.getSalary());
	}
	public void saveEmployee() {
		try {
			//SAVE File to C:\employee.dat
			FileOutputStream fos = new FileOutputStream("C:\\employee.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			System.out.println("------------Data saved to C:\\employee.dat--------------");
		} catch (FileNotFoundException e10) {
			//e10.printStackTrace();
			System.out.println("Could not create db file!");
		} catch (IOException e10) {
			System.out.println("Saving db error!");
			//e10.printStackTrace();
		}  
	}
	public void loadEmployee() {
		try {
			//LOAD File from C:\employee.dat and print
			FileInputStream fis = new FileInputStream("C:\\employee.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (ArrayList<Employee>) ois.readObject();
			ois.close();
			System.out.println("------------Data loaded from C:\\employee.dat--------------");
			displayEmployee();
		} catch (FileNotFoundException e10) {
			//e10.printStackTrace();
			System.out.println("Data is not available!");
		} catch (IOException e10) {
			//e10.printStackTrace();
			System.out.println("Reading db error!");
		} catch (ClassNotFoundException e10) {
			//e10.printStackTrace();
			System.out.println("Employee is not avaialbe in this JVM!");
		}
	}
	public void clear(){
		//		try {
		//			Runtime.getRuntime().exec("cls");
		//		} catch (IOException e) {						
		//			e.printStackTrace();
		//		}
	}
	public void menu(){
		boolean isExsit = false;

		do {
			System.out.println("==============Menu==============");
			System.out.println("1 Insert employee");
			System.out.println("2 Display list of employee");
			System.out.println("3 Save employee list to file");
			System.out.println("4 Load employee list from file");
			System.out.println("5 Exit");
			Scanner s = new Scanner(System.in);
			try {
				int choice = s.nextInt();
				switch (choice) {
				case 1: {
					clear();
					insertEmployee();
				}

				break;
				case 2: {
					clear();
					displayEmployee();
				}
				break;
				case 3: {
					clear();
					saveEmployee();
				}
				break;
				case 4: {
					clear();
					loadEmployee();
				}
				break;
				case 5: {
					clear();
					isExsit = true;			
					System.out.println("=====Program is exited!=======");
				}
				break;
				default: System.out.println("You have to select from 1 - 5");
				break;
				}

			} catch (InputMismatchException e) {
				System.out.println("You have to select number from 1 - 5");
			}  

		} while (!isExsit); 

	}

	public static void main(String[] args) {

		Program p = new Program();
		p.start();

	}

	private void start() {
		loadEmployee();
		menu();

	}

}
