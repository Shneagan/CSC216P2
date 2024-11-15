package edu.ncsu.csc216.wolf_tracker.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the custom list LogList
 * @author Cole Hincken
 */
public class LogListTest {

	/** LogList to be tested */
	private LogList<Integer> list;

	/**
	 * Sets up the main contents of the list
	 */
	@BeforeEach
	public void init() {
		list = new LogList<>();
		list.addLog(1);
		list.addLog(5);
		list.addLog(10);
		list.addLog(15);
	}
	
	
	/**
	 * tests the addLog method
	 */
	@Test
	public void testAddLog() {
		assertEquals(4, list.size());
		list.addLog(50);
		assertEquals(5, list.size());
		assertEquals(1, list.getLog(0));
		assertEquals(5, list.getLog(1));
		assertEquals(10, list.getLog(2));
		assertEquals(15, list.getLog(3));
		assertEquals(50, list.getLog(4));
		assertThrows(NullPointerException.class, () -> list.addLog(null));
	}
	

	/**
	 * tests the setLog method
	 */
	@Test
	public void testSetLog() {
		assertEquals(4, list.size());
		list.setLog(2, 50);
		assertEquals(4, list.size());
		assertEquals(1, list.getLog(0));
		assertEquals(5, list.getLog(1));
		assertEquals(50, list.getLog(2));
		assertEquals(15, list.getLog(3));
		assertThrows(NullPointerException.class, () -> list.setLog(0, null));
		assertThrows(IndexOutOfBoundsException.class, () -> list.setLog(-1, 10));
		assertThrows(IndexOutOfBoundsException.class, () -> list.setLog(6, 10));

	}

	/**
	 * tests the removeLog method
	 */
	@Test
	public void testRemoveLog() {
		assertEquals(4, list.size());
		list.removeLog(0);
		assertEquals(5, list.getLog(0));
		assertEquals(10, list.getLog(1));
		assertEquals(15, list.getLog(2));
		assertThrows(IndexOutOfBoundsException.class, () -> list.removeLog(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.removeLog(20));
	}

	/**
	 * tests the getLog method
	 */
	@Test
	public void testGetLog() {
		assertEquals(4, list.size());
		assertEquals(1, list.getLog(0));
		assertEquals(5, list.getLog(1));
		assertEquals(10, list.getLog(2));
		assertEquals(15, list.getLog(3));
		assertThrows(IndexOutOfBoundsException.class, () -> list.getLog(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.getLog(20));


	}
	
	/**
	 * Tests ensure capacity indirectly
	 */
	@Test
	public void testEnsureCapacity() {
		list.addLog(1);
		list.addLog(10);
		list.addLog(10);
		list.addLog(10);
		list.addLog(10);
		list.addLog(10);
		list.addLog(20);
		list.addLog(10);
	}

}
