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
	 * Constructs a logList object
	 */
	@SuppressWarnings("unchecked")
	public LogList() {
		this.list = (E[]) new Object[INIT_CAP];
		this.size = 0;
	}
	
	
	/**
	 * Adds an element to the list
	 * @param element the element to be added to the list
	 * @throws NullPointerException if element parameter is null
	 */
	@Override
	public void addLog(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		if (size == list.length) {
			ensureCapacity(size * 2);
		}
		
		for (int i = 0; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = element;
		size++;
	}

	/**
	 * Sets an element at a specific index in the log, replacing what was once in that index
	 * @param idx index to be added at
	 * @param element value to be added
	 * @throws NullPointerException if element parameter is null
	 * @throws IndexOutOfBoundsException if index is greater than the size or negative
	 */
	@Override
	public void setLog(int idx, E element) {
		if (element == null) {
			throw new NullPointerException("Value cannot be null.");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		this.list[idx] = element;

	}

	/**
	 * removes a value from the list at a specific index, the list is then shifted to adjust and remove the empty space
	 * @param idx the index where the value will be removed
	 * @return the value that is removed
	 * @throws IndexOutOfBoundsException if index is greater than the size or negative
	 */
	@Override
	public E removeLog(int idx) {
		if (idx < 0 || idx >= this.size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		E valueToRemove = this.list[idx];

		for (int i = idx; i < this.size() - 1; i++) {
			this.list[i] = this.list[i + 1];
		}

		this.list[this.size() - 1] = null;
		size--;
		return valueToRemove;
	}

	/**
	 * gets the value at a specific index in the list (log)
	 * @param idx the index where the value we need is
	 * @return the value in the specific index
	 * @throws IndexOutOfBoundsException if index is greater than the size or negative
	 */
	@Override
	public E getLog(int idx) {
		if (idx >= size() || idx < 0) {
			throw new IndexOutOfBoundsException("invalid index.");
		}
		return this.list[idx];
	}

	/**
	 * gets the size of the list
	 * @return integer number that represents the size of the list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * sets the capacity of the list
	 * @param capacity the new maximum amount of values that can be added to the list
	 */
	private void ensureCapacity(int capacity) {
		@SuppressWarnings("unchecked")
		E[] newList = (E[]) new Object[capacity];
		for (int i = 0; i < this.size(); i++) {
			newList[i] = this.list[i];
		}
	}
}
