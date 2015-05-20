package studentlist.compsci.sdsu;

public interface StrategyPattern<Type> {
	public LinkedList<Type> sort(Object[] linkedList);
}
