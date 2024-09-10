package utils;

import java.time.LocalDate;
import java.util.HashMap;

import com.acts.core.Course;
import com.acts.core.Student;

import custom_exceptions.StudentHandlingException;

public class StudentUtils {
//add a method for parsing string --> Course (enum)
	public static Course parseAndValidateCourse(String course)
	{
		return Course.valueOf(course.toUpperCase());
	}
	
	//add a method for parsing string --> LocalDate (dob)
	public static LocalDate parseDob(String dob)
	{
		return LocalDate.parse(dob);
	}
	//add a method for checking for dup student(PRN)
	public static void checkForDup(String prn1,HashMap<String, 
			Student> students1) throws StudentHandlingException
	{
		if(students1.containsKey(prn1))
			throw new StudentHandlingException("Dup PRN !!!!!");
		System.out.println("no dup....");
	}
	
}
