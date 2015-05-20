package studentlist.compsci.sdsu;

import java.util.List;

public abstract class Decorator implements List<Object> {
	
	Decorator(List<?> linkedList){
		List<?> decoratedLinkedList=linkedList;
	}
}
