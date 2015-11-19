package nhvinh_final;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;





public class Function 

{
	static ArrayList<Nhanvien> list = new ArrayList<Nhanvien>();
		public static void insertNhanVien()
		{
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			String exist = "N"; //Disable menu
				int i = 1;
				
				while("N".equalsIgnoreCase(exist))
				{
					Nhanvien e = new Nhanvien();
					System.out.println("Nhap thong tin nhanvien thu " + i + ":");	
					System.out.println("Ten: ");
					Scanner si = new Scanner(System.in);
					e.setName(si.nextLine());
				//	Input.inputName();
					
					//Input.inputDate();
					System.out.println("Ngay thang nam sinh: ");
					si = new Scanner(System.in);
					try {
						e.setDOB(sf.parse(si.nextLine()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Noi o: ");
					si = new Scanner(System.in);
					e.setHome(si.nextLine());
					System.out.println("Luong: ");
					si = new Scanner(System.in);
					e.setSalary(si.nextDouble());
					list.add(e);
					System.out.println("Ban co muon thoat? y/n ");
					si = new Scanner(System.in);
					exist = si.next();				
					i++;
				}
		}
		
		public static void printListNhanVien()
		{
			System.out.println("Danh sach nhan vien");
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Ho ten \t\t\t         Ngay sinh \t\t         Noi o        \tluong");
			for(Nhanvien e: list)
			System.out.println(e.getName() +"\t\t\t" + sf.format(e.getDateOfBirth()) + " \t\t\t "+ e.getHomeTown()+"\t\t" +e.getSalary());
		        
		}
		
		//*************************************************************************************
		public static void saveListNhanVien() throws IOException 
		{
				System.out.println ("Saving..."); 
				FileOutputStream fos = new FileOutputStream("C:\\danhsach.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		 		oos.writeObject(list);
				oos.close();
				
				System.out.println ("Luu thanh cong!!!"); 
		}
		
		public static void readPrintListNhanVien() throws IOException, ClassNotFoundException 
		{
			System.out.println ("Loading..."); 
			System.out.println("Loading completed");
			FileInputStream fis = new FileInputStream("C:\\danhsach.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println("Ho ten \t\t\t         Ngay sinh \t\t         Noi o        \tluong");
			list = (ArrayList<Nhanvien>) ois.readObject();
			
			for(Nhanvien e:list)
			{	
				SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println(e.getName() +"\t\t\t" + sf.format(e.getDateOfBirth()) + " \t\t\t "+ e.getHomeTown()+"\t\t" +e.getSalary());
			}
	            
            ois.close();

		}
		
		
		
		

}
