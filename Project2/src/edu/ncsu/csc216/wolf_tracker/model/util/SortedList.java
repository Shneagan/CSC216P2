package edu.ncsu.csc216.wolf_tracker.model.util;

/**
 * A custom list where values in the list are automatically sorted. In this case, tasks are sorted based on their names
 * @param <E> the element type to be added. 
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** the amount of elements in the list */
	private int size;
	
	/**
	 * Adds an element to the list, and is automatically sorted
	 * @param element the value to be added
	 */
	@Override
	public void add(E element) {
		
	}

	/**
	 * removes an element from the list at the index parameter provided
	 * @param idx the index provided
	 * @return the element that is removed
	 */
	@Override
	public E remove(int idx) {
		return null;
	}

	/**
	 * Checks if the list contains the parameter value
	 * @param element the value that we are checking for inside the list
	 * @return true if the element is in the list, false otherwise
	 */
	@Override
	public boolean contains(E element) {
		return false;
	}

	/**
	 * gets the value that is at the index provided in the parameter
	 * @param idx the index provided
	 * @return the value at the index
	 */
	@Override
	public E get(int idx) {
		return null;
	}

	/**
	 * gets the size of the list
	 * @return integer value of the number of elements in the list
	 */
	@Override
	public int size() {
		return 0;
	}

}
