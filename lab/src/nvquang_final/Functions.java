package nvquang_final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions {
	static ArrayList<Employee> list = new ArrayList<Employee>();
	static SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
	private static Scanner si;
	private static Scanner si1;
	private static Scanner si11;

	public static void Input() throws BaseSalaryException, DataInputExeption {

		String exist = "Y";
		int i = 1;

		// ArrayList<Employee> list = new ArrayList<Employee>();

		do {
			Employee e = new Employee();
			System.out.println(" Nhap nhan vien thu " + i);
			System.out.println("Ten: ");
			si = new Scanner(System.in);
			String name = e.setName(si.nextLine());
			if (name == null || name.isEmpty())
				throw new DataInputExeption();

			System.out.println("\nNgay thang nam sinh: ");
			si1 = new Scanner(System.in);
			try {
				// java.util.Date date =
				// e.setDateOfBirth(sf.parse(si1.nextLine()));
				// if (date == null || ((List<Employee>) date).isEmpty()) throw
				// new DataInputExeption();
				e.setDateOfBirth(sf.parse(si1.nextLine()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("\nNoi o: ");
			si11 = new Scanner(System.in);
			String no = e.setLivePlace(si11.nextLine());
			if (no == null || no.isEmpty()) {
				throw new DataInputExeption();
			}

			System.out.println("\nLuong: ");
			si11 = new Scanner(System.in);
			double lu = e.setSalary(si11.nextDouble());
			// if (lu < 3100000 || lu.isEmpty()) throw new
			// BaseSalaryException();
			if (lu < 3100000) {
				throw new BaseSalaryException();
			}
			list.add(e);
			System.out.println("\nBan co muon thoat? y/n ");
			si11 = new Scanner(System.in);
			exist = si11.next();
			i++;
		} while ("N".equalsIgnoreCase(exist));

	}

	public static void Print_list() {
		System.out.println("===============Danh sach nhan vien vua nhap vao:=========================");
		System.out.println("\n\nHo ten \t\t\t Ngay sinh \t\t\t Noi o \t\t luong ");
		for (Employee e1 : list)
			System.out.println(e1.getName() + "\t\t\t" + sf.format(e1.getDateOfBirth()) + " \t\t\t " + e1.getLivePlace()
					+ "\t\t\t" + e1.getSalary());
	}

	public static void Save_list() throws ClassNotFoundException {

		try {
			FileOutputStream fos = new FileOutputStream("C:\\employee_list.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			System.out.println("The list saved!");

		} catch (FileNotFoundException e10) {
			// TODO Auto-generated catch block
			e10.printStackTrace();
		} catch (IOException e10) {
			// TODO Auto-generated catch block
			e10.printStackTrace();
		}

	}

	public static void Read_list() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream("C:\\employee_list.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Employee> emp = ((List<Employee>) ois.readObject());
		ois.close();

		System.out.println("================Danh sach doc lai tu db=================");
		System.out.println("Ho ten \t\t\t Ngay sinh \t\t\t Noi o \t\t luong ");
		for (Employee e : emp)
			System.out.println(e.getName() + "\t\t\t" + sf.format(e.getDateOfBirth()) + " \t\t\t " + e.getLivePlace()
					+ "\t\t\t" + e.getSalary());
		//ois.close();
	}

	public static void Escape() {
		System.out.println("The program exit!");
	}
}
