package lmhung_final.package3;

import java.util.ArrayList;
import java.util.Scanner;

import lmhung_final.func.BaseSalaryException;
import lmhung_final.func.DataInputExeption;
import lmhung_final.func.menu_processes;


public class First {
	
	public static void main(String[] args) throws DataInputExeption, BaseSalaryException {
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		int select = 5;
		String thoatCT = "n";
		
		while (thoatCT.equalsIgnoreCase("n")) {
			System.out.println("-----------Menu-------");
			System.out.println("1 Nhap vao danh sach nhan vien");
			System.out.println("2 In danh sach nhan vien");
			System.out.println("3 Luu danh sach nhan vien vao o dia");
			System.out.println("4 Doc danh sach nhan vien tu o dia va in ra");
			System.out.println("5 Thoat");
			System.out.println("Lua chon cua ban: ");
			Scanner c = new Scanner(System.in);
			select = c.nextInt();
	
			switch(select) {
			case 1:
				 menu_processes.NhapNhanVien(list);
				break;
			case 2:
				 menu_processes.InDanhSach(list);
				break;
			case 3:
				 menu_processes.LuuDanhSach(list);
				break;
			case 4:
				menu_processes.DocInDanhSach();
				break;
			case 5:
				thoatCT = "y";
				break;
			default:
				System.out.println("Ban phai chon so tu 1-5 !!!");				
				break;
			}
		}		
		
	}
	
}





