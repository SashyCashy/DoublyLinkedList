package studentlist.compsci.sdsu;


//import java.util.Iterator;
import static org.junit.Assert.*;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class Test {
	Student student_one = new Student(818494008, "ABC", 1.56);
	Student student_two = new Student(818494008, "XYZ", 2.56);
	Student student_three = new Student(818494008, "LMNO", 4);
	Student student_four = new Student(818494008, "PQR", 4.00);
	

	LinkedList<Student> listofStudents = new LinkedList<Student>();
	LinkedList<Student> lexicographicList = new LinkedList<Student>();
	LinkedList<Student> HighestGPAList = new LinkedList<Student>();

	@Test
	public void addNodeTest() {
		listofStudents.add(student_one);
		listofStudents.add(student_two);
		listofStudents.add(student_three);
		listofStudents.add(student_four);
		listofStudents.add(student_five);

		assertEquals(listofStudents.get(0), student_one);
		assertEquals(listofStudents.get(1), student_two);
		assertEquals(listofStudents.get(2), student_three);
		assertEquals(listofStudents.get(3), student_four);
		assertEquals(listofStudents.get(4), student_five);
	}

	@Test
	public void iteratorAndToArrayTest() {
		listofStudents.add(student_one);
		listofStudents.add(student_two);
		listofStudents.add(student_three);
		listofStudents.add(student_four);
		listofStudents.add(student_five);

		Student[] studentArray = (Student[]) listofStudents
				.toArray(new Student[listofStudents.size()]);

		int index = 0;

		Iterator<Student> studentListIterator = listofStudents.iterator();
		while (studentListIterator.hasNext()) {
			assertEquals(studentListIterator.next(), studentArray[index]);
			index++;
		}
	}

	@Test
	public void lexicographicalOrderTest() {

		listofStudents.add(student_one);
		listofStudents.add(student_two);
		listofStudents.add(student_three);
		listofStudents.add(student_four);
		listofStudents.add(student_five);

		StrategyPattern<Student> orderedList = new LexicographicalOrder<Student>();
		lexicographicList = listofStudents.sort(orderedList);

		assertEquals(lexicographicList.get(0), student_four);
		assertEquals(lexicographicList.get(1), student_three);
		assertEquals(lexicographicList.get(2), student_five);
		assertEquals(lexicographicList.get(3), student_one);
		assertEquals(lexicographicList.get(4), student_two);
	}

	@Test
	public void ProbationFilterationTest() {

		Student[] arrayofStudents = new Student[2];
		arrayofStudents[0] = student_one;
		arrayofStudents[1] = student_two;

		int index = 0;

		Iterator<Student> iterateoverStudentList = listofStudents.iterator();
		OnProbationFilter filterIterator = new OnProbationFilter(
				iterateoverStudentList);
		while (filterIterator.hasNext()) {
			assertEquals(filterIterator.next(), arrayofStudents[index]);
			index++;
		}
	}

	@Test
	public void onProbationDecoratorTest() {
		int index = 0;

		listofStudents.add(student_one);
		listofStudents.add(student_two);
		listofStudents.add(student_three);
		listofStudents.add(student_four);
		listofStudents.add(student_five);

		OnProbationDecorator<Student> probationList = new OnProbationDecorator<Student>(
				listofStudents);
		Student[] studentArray = (Student[]) probationList
				.toArray(new Student[listofStudents.size()]);

		Iterator<Student> studentProbationListIterator = probationList
				.iterator();
		while (studentProbationListIterator.hasNext()) {
			assertEquals(studentProbationListIterator.next(),
					studentArray[index]);
			index++;
		}
	}

	@Test
	public void HighGPAInReverseOrderTest() {
		listofStudents.add(student_one);
		listofStudents.add(student_two);
		listofStudents.add(student_three);
		listofStudents.add(student_four);
		listofStudents.add(student_five);
		StrategyPattern<Student> highGPAStudentList = new OrderByGPA<Student>();
		HighestGPAList = listofStudents.sort(highGPAStudentList);
		assertEquals(HighestGPAList.get(0), student_four);
		assertEquals(HighestGPAList.get(1), student_three);
	}
}
