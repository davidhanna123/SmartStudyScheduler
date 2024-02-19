package BusinessLogic;

import java.util.TreeSet;
/**
 * A LimitedTreeSet data structure. This data structure is just a TreeSet with a maximum capacity. 
 * @param <E>
 * {@link TreeSet}
 */
public class LimitedTreeSet<E> extends TreeSet<E> {
	private int maxCapacity;
	
	/**
	 * Constructor that takes the maximum amount of objects or values that a LimitedTreeSet can have
	 * @param max
	 */
	public LimitedTreeSet(int max){
		this.maxCapacity = max;
	}

	/**
	 * {@link TreeSet#size}
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}
	/**
	 * {@link TreeSet#isEmpty}
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}
	/**
	 * {@link TreeSet#contains}
	 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return super.contains(o);
	}
	/**
	 * {@link TreeSet#add}
	 */
	@Override
	public boolean add(E e){
		// TODO Auto-generated method stub
		if(this.size() >= this.maxCapacity) {
			throw new IllegalStateException();
		}
		return super.add(e);
	}
	/**
	 * {@link TreeSet#remove}
	 */
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return super.remove(o);
	}
	/**
	 * {@link TreeSet#clear}
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		super.clear();
	}
	/**
	 * {@link TreeSet#first}
	 */
	@Override
	public E first() {
		// TODO Auto-generated method stub
		return super.first();
	}
	/**
	 * {@link TreeSet#last}
	 */
	@Override
	public E last() {
		// TODO Auto-generated method stub
		return super.last();
	}
	
	
}
