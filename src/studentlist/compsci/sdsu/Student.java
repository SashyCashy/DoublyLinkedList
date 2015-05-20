package studentlist.compsci.sdsu;
import studentlist.compsci.sdsu.LinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.stream.Collectors;


public class Student {
	private long studentRedId;
	private String studentName;
	private double studentGpa;

	public Student() {}

	public Student(long studentRedId, String studentName, double studentGpa) {
		setStudentRedId(studentRedId);
		setStudentName(studentName);
		setStudentGpa(studentGpa);
	}

	public long getStudentRedId() {
		return studentRedId;
	}

	public void setStudentRedId(long studentRedId) {
		this.studentRedId = studentRedId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentGpa() {
		return studentGpa;
	}

	public void setStudentGpa(double studentGpa) {
		this.studentGpa = studentGpa;
	}

	public void displayStudents(LinkedList<Student> studentList) {
		studentList.stream().
		forEach(student -> System.out.println(student));
	}
	
	@Override
	public String toString() {
		return "Student [studentRedId=" + studentRedId + ", studentName="
				+ studentName + ", studentGpa=" + studentGpa + "]";
	}

}
