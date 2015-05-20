package studentlist.compsci.sdsu;

import java.util.Iterator;

public class OnProbationFilter implements Iterator {
	private LinkedListIterator<?> onProbationListIterator;
	private Student studentObject;

	OnProbationFilter(Iterator linkedListIterator) {
		onProbationListIterator = (LinkedListIterator) linkedListIterator;
		studentObject = (Student) linkedListIterator.next();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return onProbationListIterator.hasNext();

	}

	@Override
	public Object next() {
		while (onProbationListIterator.hasNext()) {
			studentObject = (Student) onProbationListIterator.next();
			if (studentObject.getStudentGpa() <= 2.85)
				break;
		}
		return studentObject;
	}
}
