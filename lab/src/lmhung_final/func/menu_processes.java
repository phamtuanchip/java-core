package lmhung_final.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import lmhung_final.package3.Employee;

public class menu_processes {

	private static Comparator<Employee> byName()
	{
	    return new Comparator<Employee>() {
	        public int compare(Employee o1, Employee o2)
	        {
	            return o1.getName().compareTo(o2.getName());
	        }
	    };        
	}
	
	public static boolean validateString(String s) throws DataInputExeption {
		boolean b = false;
		
		if (s == "" || s.length() == 0) {
			throw new DataInputExeption();			
		}
		else {
			b = true;
		}
		
		return b;
	}
	
	public static boolean validateSalary(Double d) throws BaseSalaryException {
		boolean b = false;
		
		if (d < 3100000) {
			throw new BaseSalaryException();			
		}
		else {
			b = true;
		}
		
		return b;
	}
	
	@SuppressWarnings("resource")
	public static void NhapNhanVien(List<Employee> list) throws DataInputExeption, BaseSalaryException {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		int i = 1;
		String thoat = "n";
		String str = "";
		
		try {						
			while(thoat.equalsIgnoreCase("n")) {
				Employee e = new Employee();
				System.out.println(" Employee thu" + i);				
				
				System.out.println("Ten: ");
				Scanner si = new Scanner(System.in);
				str = si.nextLine();
				if (validateString(str) == true) {
					e.setName(str);
				}				

				System.out.println("Ngay thang nam sinh: ");
				si = new Scanner(System.in);
				str = si.nextLine();
				if (validateString(str) == true) {
					e.setDateOfBirth(sf.parse(str));
				}			
				
				System.out.println("Noi o: ");
				si = new Scanner(System.in);
				str = si.nextLine();
				if (validateString(str) == true) {
					e.setLocation(str);
				}
				
				System.out.println("Luong: ");
				si = new Scanner(System.in);
				Double s = si.nextDouble();
				if (validateSalary(s) == true) {
					e.setSalary(s);
				}
				
				list.add(e);
				System.out.println("Ban da nhap xong? y/n ");
				si = new Scanner(System.in);
				thoat = si.next();				
				i++;
				}
			}
			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	public static void InDanhSach (List<Employee> list) {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Ho ten \t\t\t Ngay sinh \t Noi sinh \t Luong");
		Collections.sort(list, byName());
		for (Employee emp : list) {			
			System.out.println(emp.getName() +"\t\t\t" + sf.format(emp.getDateOfBirth()) + " \t "+ emp.getLocation() + " \t\t" + emp.getSalary());
			}
	}
	
	public static void LuuDanhSach (List<Employee> list) {
		try {
			//SAVE File to C:\\danhsach.dat
			FileOutputStream fos = new FileOutputStream("C:\\danhsach.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();	
			System.out.println("Da luu xong danh sach nhan vien vao file C:\\danhsach.dat");
		} catch (FileNotFoundException e10) {
			// TODO Auto-generated catch block
			e10.printStackTrace();
		} catch (IOException e10) {
			// TODO Auto-generated catch block
			e10.printStackTrace();
		}
	}
	
	public static void DocInDanhSach () {	
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			//LOAD File from C:\\danhsach.dat and print
			FileInputStream fis = new FileInputStream("C:\\danhsach.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			@SuppressWarnings("unchecked")
			List<Employee> list = (List<Employee>) ois.readObject();
			ois.close();
			
			System.out.println("================ Danh sach doc tu file C:\\danhsach.dat =================");
			System.out.println("Ho ten \t\t\t Ngay sinh \t Noi o \t luong");
			for(Employee e: list)
			System.out.println(e.getName() +"\t\t\t" + sf.format(e.getDateOfBirth()) + " \t "+e.getLocation()+" \t" + e.getSalary());			
		} catch (FileNotFoundException e10) {
			// TODO Auto-generated catch block
			e10.printStackTrace();
		} catch (IOException e10) {
			// TODO Auto-generated catch block
			e10.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		
	}
}
