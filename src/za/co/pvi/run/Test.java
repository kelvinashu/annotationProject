package za.co.pvi.run;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import za.co.pvi.annotations.Course;
import za.co.pvi.domain.Student;

public class Test {
	public static void main(String[] args) {
		Student student = new Student(10, "Visual Man");
		//classExample(student);
		methodExample(student);
	}

	private static void methodExample(Student student) {
		System.out.println(student.toString());

		Class<? extends Student> cls = student.getClass();

		// Method
		Method method = null;
		try {
			 method = cls.getMethod("toString");
		} catch (NoSuchMethodException e) {
			// TODO I will later on do it
			// FIXME Some description about the FIX goes here
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Annotation ann = method.getAnnotation(Course.class);
		Course course = (Course) ann;

		// Course course = (Course) Student.class.getMethod("toString").getAnnotation(Course.class);

		System.out.println("Course Name\t\t: " + course.name());
		System.out.println("Course Amount\t\t: " + course.amount());
	}

	private static void classExample(Student student) {

		System.out.println(student.toString());

		@SuppressWarnings("rawtypes")
		Class cls = student.getClass();

		@SuppressWarnings("unchecked")
		Annotation ann = cls.getAnnotation(Course.class);
		Course course = (Course) ann;

		// Course course = (Course) Student.class.getAnnotation(Course.class);

		System.out.println("Course Name\t\t: " + course.name());
		System.out.println("Course Amount\t\t: " + course.amount());
	}
}
