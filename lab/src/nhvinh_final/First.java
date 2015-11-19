package nhvinh_final;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class First
{
	
	ArrayList<Nhanvien> list = Function.list;
	
	public static void main(String[] args) throws IOException
	{	
		//khai bao bien
		int choose_Function=0;
		
		//************************************************
		
		while(choose_Function!=5)
		{
		//------------------------- In menu---------------------------------
		System.out.println("***-----Menu-----***");
		System.out.println("1 Nhap vao danh sach nhan vien");
		System.out.println("2 In danh sach nhan vien");
		System.out.println("3 Luu danh sach nhan vien vao o dia");
		System.out.println("4 Doc danh sach nhan vien tu o dia va in ra");
		System.out.println("5 Thoat");
		
		//***********************************************************
		//nhap vao 
		do
		{	try{
			System.out.print("Chon task:");
			Scanner in = new Scanner(System.in);
			choose_Function = in.nextInt();
		}catch(InputMismatchException e)
		{
			System.out.println("Sai kieu du lieu nhap vao");
			break;
		}
			if ((choose_Function<1)||(choose_Function>5))
			{
				System.out.println("Gia tri task trong khoang 1 - 5. Moi ban chon lai");
			}
		}while((choose_Function<1)||(choose_Function>5));
		
		//***********************************chon function********************************
		
		switch(choose_Function)
			{
				case 1:
				{
					//Input.inputName();
					Function.insertNhanVien();
					break;
				}
				case 2:
				{
					Function.printListNhanVien();
					break;
				}
				case 3:
				{
					
						Function.saveListNhanVien();
					
						break;
				}
				case 4:
				{
						try {
								Function.readPrintListNhanVien();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;
				}
				
						default:
				{
					
				}
				
			}
		
		}
		
		
	}
}

