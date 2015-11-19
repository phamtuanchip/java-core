package nvquang_final;

import java.io.IOException;
import java.util.Scanner;

public class First {

	//private static ArrayList<Employee> list;

	public static void main(String[] args) throws IOException {

		int i = 0;
		

		while (i != 5) {
			System.out.println(
					"\n\nChoose an option by typing a number: \n1. Input_employee \n2. Print_list\n3. Save_list\n4. Read_list\n5. Escape");

			try {

				i = new Scanner(System.in).nextInt();
				if ((1 <= i) & (i <= 5)) {
					switch (i) {
					case 1:
						Functions.Input();
						break;

					case 2:
						Functions.Print_list();
						break;

					case 3:
						Functions.Save_list();
					
						break;

					case 4:
						Functions.Read_list();
						break;

					case 5:
						Functions.Escape();
						break;
					default:
						return;
					}

				} else
					System.out.println("Ban phai nhap so tu 1-5!\n");
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Ban phai nhap so tu 1-5!!!!!\n");
			}
//			catch(ExceptionInInitializerError.NumberFormatException nb)
//			{System.out.println("Not a number!");}
		}
	}

	}

