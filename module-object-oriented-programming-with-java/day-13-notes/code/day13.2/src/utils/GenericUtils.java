package utils;

import java.util.Collection;
import java.util.List;

import com.app.core.Emp;

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
		return sum;
	}
}
