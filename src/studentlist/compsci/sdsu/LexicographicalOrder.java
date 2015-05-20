package studentlist.compsci.sdsu;

public class LexicographicalOrder<Type> implements StrategyPattern<Type> {
	private LinkedList<Type> orderedList = new LinkedList<>();

	@Override
	public LinkedList<Type> sort(Object[] linkedListArray) {
		Student[] studentArray = new Student[linkedListArray.length];
		System.arraycopy(linkedListArray, 0, studentArray, 0,
				linkedListArray.length);
		Student temporary = null;

		for (int studentIndex = 0; studentIndex < studentArray.length; studentIndex++) {
			for (int nextStudentIndex = studentIndex + 1; nextStudentIndex < studentArray.length; nextStudentIndex++) {
				if (studentArray[studentIndex].getStudentName().compareToIgnoreCase(
						studentArray[nextStudentIndex].getStudentName()) > 0) {
					temporary = studentArray[studentIndex];
					studentArray[studentIndex] = studentArray[nextStudentIndex];
					studentArray[nextStudentIndex] = temporary;
				}
			}
			orderedList.add(studentArray[studentIndex]);
		}
		return orderedList;
	}
}
