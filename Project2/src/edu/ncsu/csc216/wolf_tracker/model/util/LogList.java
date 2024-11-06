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
	
	/**
	 * Adds an element to the list
	 * @param element the element to be added to the list
	 */
	@Override
	public void addLog(E element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Sets an element at a specific index in the log, replacing what was once in that index
	 * @param idx index to be added at
	 * @param element value to be added
	 */
	@Override
	public void setLog(int idx, E element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * removes a value from the list at a specific index, the list is then shifted to adjust and remove the empty space
	 * @param idx the index where the value will be removed
	 * @return the value that is removed
	 */
	@Override
	public E removeLog(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * gets the value at a specific index in the list (log)
	 * @param idx the index where the value we need is
	 * @return the value in the specific index
	 */
	@Override
	public E getLog(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * gets the size of the list
	 * @return integer number that represents the size of the list
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * sets the capacity of the list
	 * @param capacity the new maximum amount of values that can be added to the list
	 */
	private void ensureCapacity(int capacity) {
		
	}
}
