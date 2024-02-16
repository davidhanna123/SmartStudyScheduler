package BusinessLogic;

import java.util.TreeSet;

public class LimitedTreeSet<E> extends TreeSet<E> {
	private int maxCapacity;
	
	public LimitedTreeSet(int max){
		this.maxCapacity = max;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return super.contains(o);
	}

	@Override
	public boolean add(E e){
		// TODO Auto-generated method stub
		if(this.size() >= this.maxCapacity) {
			throw new IllegalStateException();
		}
		return super.add(e);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return super.remove(o);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		super.clear();
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		return super.first();
	}

	@Override
	public E last() {
		// TODO Auto-generated method stub
		return super.last();
	}
	
	
}
