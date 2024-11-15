package edu.ncsu.csc216.wolf_tracker.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the custom list sortedList
 * @author Cole Hincken
 */
public class SortedListTest {

	/** The list to be tested */
	private SortedList<Integer> list = new SortedList<>();
	
	/**
	 * Creates a sortedList object and sets its contents
	 */
	@BeforeEach
	public void init() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	}
	
	
	/**
	 * tests the add method
	 */
	@Test
	public void testAdd() {
		assertEquals(5, list.size());
		list.add(6);
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(4, list.get(3));
		assertEquals(5, list.get(4));
		assertEquals(6, list.get(5));
		assertEquals(6, list.size());
		assertThrows(NullPointerException.class, () -> list.add(null));
	}

	/**
	 * tests the remove method
	 */
	@Test
	public void testRemove() {
		list.remove(0);
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(4, list.get(2));
		assertEquals(5, list.get(3));
		assertEquals(4, list.size());
		list.remove(2);
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(5, list.get(2));
	}

	/**
	 * tests the contains method
	 */
	@Test
	public void testContains() {
		assertTrue(list.contains(1));
		assertFalse(list.contains(10));
	}

}
