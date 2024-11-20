package edu.ncsu.csc216.wolf_tracker.model.util;


/**
 * A custom list where values in the list are automatically sorted. In this case, tasks are sorted based on their names
 * @author Cole Hincken
 * @param <E> the element type to be added. 
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** the amount of elements in the list */
	private int size;
	
	/** first value in the list */
	private ListNode front;
	
	/**
	 * Creates a sortedList object
	 */
	public SortedList() {
		this.front = null;
		this.size = 0;
	}
	
	/**
	 * Adds an element to the list, and is automatically sorted
	 * @param element the value to be added
	 * @throws NullPointerException if parameter is null
	 * @throws IllegalArgumentException if the parameter element already exists in the list
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
        ListNode current = front;
        ListNode previous = null;

        while (current != null && element.compareTo(current.data) > 0) {
            previous = current;
            current = current.next;
        }

        if (current != null && element.compareTo(current.data) == 0) {
            throw new IllegalArgumentException("Cannot add duplicate element.");
        }

        ListNode newNode = new ListNode(element, current);
        if (previous == null) {
            front = newNode;
        } else {
            previous.next = newNode;
        }
        size++;
		
	}

	/**
	 * removes an element from the list at the index parameter provided
	 * @param idx the index provided
	 * @return the element that is removed
	 * @throws IndexOutOfBoundsExeption if index is negative or greater than size of list
	 */
	@Override
	public E remove(int idx) {
		if (idx < 0 || idx >= this.size || front == null) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		E value;
		if (idx == 0) {
			value = front.data;
			front = front.next;
		} 
		else {
			ListNode current = front;

			for (int i = 0; i < idx - 1; i++) {
				current = current.next;
			}

			value = current.next.data;
			current.next = current.next.next;
			
		}
		size--;
		return value;
	}

	/**
	 * Checks if the list contains the parameter value
	 * @param element the value that we are checking for inside the list
	 * @return true if the element is in the list, false otherwise
	 */
	@Override
	public boolean contains(E element) {
        ListNode current = front;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
	}

	/**
	 * gets the value that is at the index provided in the parameter
	 * @param idx the index provided
	 * @return the value at the index
	 * @throws IndexOutOfBoundsException if the index is negative or larger than the size of the list
	 */
	@Override
	public E get(int idx) {
		if (idx < 0 || idx >= this.size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		ListNode current = front;

		for (int i = 0; i < idx; i++) {
			current = current.next;

		}

		return current.data;

	}

	/**
	 * gets the size of the list
	 * @return integer value of the number of elements in the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Contains info on a specific node, or element in the list.
	 * Each node holds its value and then a reference to the next node, which
	 * maintains a sequential list
	 * @author Cole Hincken
	 */
	private class ListNode {
		
		/** the values in this node */
		public E data;
		
		/** Next node in the list */
		public ListNode next;
		
		/**
		 * Creates a listnode object
		 * @param data the values in the listnode
		 * @param next the next referenced node that comes after this node
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
}
