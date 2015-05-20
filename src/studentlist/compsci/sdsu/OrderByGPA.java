package studentlist.compsci.sdsu;

public class OrderByGPA<Type> implements StrategyPattern<Type> {
	private LinkedList<Type> reverseOrderList = new LinkedList<>();
/**
 * Function to return list of students with GPA 4.0, but in reverse order of their occurrence
 * in the list.
 */
	@Override
	public LinkedList<Type> sort(Object[] linkedListArray) {
		Student[] studentArray = new Student[linkedListArray.length];
		for (int index = linkedListArray.length - 1; index >= 0; index--) {
			studentArray[index] = (Student) linkedListArray[index];
			if (studentArray[index].getStudentGpa() == 4.0)
				reverseOrderList.add(studentArray[index]);
		}
		return reverseOrderList;
	}
}
