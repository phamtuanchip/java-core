package package5;

import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		 
		return e1.DateOfBirth.compareTo(e2.DateOfBirth);
	}

}
