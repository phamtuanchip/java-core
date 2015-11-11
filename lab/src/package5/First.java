package package5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class First {

	public static void main(String[] args) {

	 
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String exist = "Y";
			int i = 1;
			ArrayList<Employee> list = new ArrayList<Employee>();
			while("N".equalsIgnoreCase(exist)) {
				Employee e = new Employee();
				System.out.println(" Employee thu" + i);
				System.out.println("Ten: ");
				Scanner si = new Scanner(System.in);
				e.setName(si.nextLine());
				System.out.println("Ngay thang nam sinh: ");
				si = new Scanner(System.in);
				e.setDateOfBirth(sf.parse(si.nextLine()));
				System.out.println("Luong: ");
				si = new Scanner(System.in);
				e.setSalary(si.nextDouble());
				list.add(e);
				System.out.println("Ban co muon thoat? y/n ");
				si = new Scanner(System.in);
				exist = si.next();				
				i++;
			}  
			
			Employee e1 = new Employee("Nguyen Van A", sf.parse("10/11/1991"), "Hanoi", 5000000);
			Manager m1 = new Manager("Nguyen Van M", sf.parse("10/11/1981"), "Hanoi", 5000000, ROLE.role_TL);
			Manager m2 = new Manager("Nguyen Van T", sf.parse("10/11/1980"), "Hanoi", 5000000, ROLE.role_PM);
			
			Employee e2 = new Employee("Nguyen Van C", sf.parse("11/11/1991"), "Hanoi", 5000000);
			Employee e3 = new Employee("Nguyen Van B", sf.parse("12/11/1991"), "Hanoi", 5000000);
			Employee e4 = new Employee("Nguyen Van D", sf.parse("13/11/1991"), "Hanoi", 5000000);
			Employee e5 = new Employee("Nguyen Van G", sf.parse("14/11/1991"), "Hanoi", 5000000);
			Employee e6 = new Employee("Nguyen Van F", sf.parse("15/11/1991"), "Hanoi", 5000000);
			Employee e7 = new Employee("Nguyen Van E", sf.parse("16/11/1991"), "Hanoi", 5000000);
			Employee e8 = new Employee("Nguyen Van I", sf.parse("17/11/1991"), "Hanoi", 5000000);
			Employee e9 = new Employee("Nguyen Van H", sf.parse("18/11/1991"), "Hanoi", 5000000);
			
			list.add(e1);
			list.add(e2);
			list.add(e3);
			list.add(e4);
			list.add(e5);
			list.add(e6);
			list.add(e7);
			list.add(e8);
			list.add(e9);
			
			System.out.println("Ho ten \t\t\t Ngay sinh \t vai tro \t luong \t\t thuong \t thuc linh");
			for(Employee e: list)
			System.out.println(e.getName() +"\t\t" + sf.format(e.getDateOfBirth()) + " \t\t\t "+e.getSalary()+" \t\t\t" + e.getSalary());
			//System.out.println(m1.getName() +"\t\t" + sf.format(m1.getDateOfBirth()) + " \t"+m1.getRole()+"\t\t "+m1.salary+" \t"+m1.bonus+"\t" + m1.getSalary());
			//System.out.println(m2.getName() +"\t\t" + sf.format(m2.getDateOfBirth()) + " \t"+m2.getRole()+"\t\t "+m2.salary+" \t"+m2.bonus+"\t" + m2.getSalary());
			
			Collections.sort(list);
			System.out.println("================Danh sach da sap xep lai =================");
			System.out.println("Ho ten \t\t\t Ngay sinh \t vai tro \t luong \t\t thuong \t thuc linh");
			for(Employee e: list)
			System.out.println(e.getName() +"\t\t" + sf.format(e.getDateOfBirth()) + " \t\t\t "+e.getSalary()+" \t\t\t" + e.getSalary());
			
			
			try {
				//SAVE File to C:\employee.tmp
				FileOutputStream fos = new FileOutputStream("C:\\employee.tmp");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.close();
				
				//LOAD File from C:\employee.tmp and print
				FileInputStream fis = new FileInputStream("C:\\employee.tmp");
				ObjectInputStream ois = new ObjectInputStream(fis);
				List<Employee> employee = (List<Employee>) ois.readObject();
				ois.close();
				
				System.out.println("================Danh sach doc lai tu db =================");
				System.out.println("Ho ten \t\t\t Ngay sinh \t vai tro \t luong \t\t thuong \t thuc linh");
				for(Employee e: employee)
				System.out.println(e.getName() +"\t\t" + sf.format(e.getDateOfBirth()) + " \t\t\t "+e.getSalary()+" \t\t\t" + e.getSalary());
				
			} catch (FileNotFoundException e10) {
				// TODO Auto-generated catch block
				e10.printStackTrace();
			} catch (IOException e10) {
				// TODO Auto-generated catch block
				e10.printStackTrace();
			} catch (ClassNotFoundException e10) {
				// TODO Auto-generated catch block
				e10.printStackTrace();
			}
			
			
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}





