package edu.ncsu.csc216.wolf_tracker.model.util;

/**
 * A Custom list that utilizes an array
 * @author Cole Hincken
 * @param <E> the object type that is inside the list
 */
public class LogList<E> implements ILogList<E> {

	/** An array of E type objects */
	private E[] list;
	
	/** the size of the array */
	private int size;
	
	/** the intial capacity of the array */
	private static final int INIT_CAP = 10;
	
	@Override
	public void addLog(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLog(int idx, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E removeLog(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getLog(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void ensureCapacity(int capacity) {
		
	}
}
