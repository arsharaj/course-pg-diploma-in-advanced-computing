package utils;

import java.util.Collection;
import java.util.List;

import com.app.core.Emp;
import com.app.core.Mgr;
import com.app.core.SalesMgr;
import com.app.core.TempWorker;

public class GenericUtils {
	/*
	 * 1. Add a method to print all elements from any of the following 
	 * Test cases :
	 * AL<String> , LL<Integer> , Vector<LocalDate> ,
	 *  HS<Double> , LHS,TS
	 */
//	public static void printElements(Collection<Object> collection) {
//		for(Object o : collection)
//			System.out.println(o);
//		
//	}
	public static void printElements(Collection<?> collection) {
		for(Object o : collection)
			System.out.println(o);
		
	}
	/*
	 * Add a method to find sum of salary of emps from any List 
Test cases : AL<Mgr> ,LL<Worker> , Vector<SM> ....
	 */
	public static double sumOfSalaries(List<? extends Emp> list) {
		double sum=0;
		for (Emp e : list)
			sum += e.computeSalary();
	//	list.add(new Mgr(1234));
	//	list.add(new SalesMgr(1234));
	//	list.add(new TempWorker(3456));
	//	list.add(new Object());
		return sum;
	}
}
