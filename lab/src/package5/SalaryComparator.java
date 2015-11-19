package package5;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		 
		return Double.compare(e1.salary, e2.salary);
	}

}
