package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Tests the abstract class AbstractTaskLog
 */
public class AbstractTaskLogTest {


	/**
	 * Tests the setTaskLogName method
	 */
	@Test
	public void testSetTaskLogName() {
		AbstractTaskLog category = new CategoryLog("Design");
		assertThrows(IllegalArgumentException.class, () -> category.setTaskLogName(null));
		assertThrows(IllegalArgumentException.class, () -> category.setTaskLogName(""));
		category.setTaskLogName("Test");
		assertEquals("Test", category.getName());

	}


	/**
	 * Tests the setTask method
	 */
	@Test
	public void testSetTask() {
		AbstractTaskLog category = new CategoryLog("Design");
		Task t = new Task("Name", 20, "Details");
		Task t2 = new Task("Name2", 25, "Details2");
		Task t3 = new Task("Name3", 30, "Details3");
		category.addTask(t);
		category.addTask(t2);
		category.setTask(1, t3);
		assertEquals(t3, category.getTask(1));
	}

	/**
	 * tests the removeTask method
	 */
	@Test
	public void testRemoveTask() {
		AbstractTaskLog category = new CategoryLog("Design");
		Task t = new Task("Name", 20, "Details");
		Task t2 = new Task("Name2", 25, "Details2");
		Task t3 = new Task("Name3", 30, "Details3");
		category.addTask(t);
		category.addTask(t2);
		category.addTask(t3);
		assertEquals(t3, category.removeTask(2));
	}


	/**
	 * tests the getTaskCount method
	 */
	@Test
	public void testGetTaskCount() {
		AbstractTaskLog category = new CategoryLog("Design");
		Task t = new Task("Name", 20, "Details");
		Task t2 = new Task("Name2", 25, "Details2");
		Task t3 = new Task("Name3", 30, "Details3");
		category.addTask(t);
		category.addTask(t2);
		category.addTask(t3);	
		assertEquals(3, category.getTaskCount()); 
	}

	/**
	 * tests the getMinDuration method for 3 tasks
	 */
	@Test
	public void testGetMinDuration() {
		AbstractTaskLog category = new CategoryLog("Design");
		Task t = new Task("Name", 20, "Details");
		Task t2 = new Task("Name2", 25, "Details2");
		Task t3 = new Task("Name3", 30, "Details3");
		category.addTask(t);
		category.addTask(t2);
		category.addTask(t3);	
		assertEquals(20, category.getMinDuration());
	}

	/**
	 * tests the getMaxDuration method for 3 tasks
	 */
	@Test
	public void testGetMaxDuration() {
		AbstractTaskLog category = new CategoryLog("Design");
		Task t = new Task("Name", 20, "Details");
		Task t2 = new Task("Name2", 25, "Details2");
		Task t3 = new Task("Name3", 30, "Details3");
		category.addTask(t);
		category.addTask(t2);
		category.addTask(t3);	
		assertEquals(30, category.getMaxDuration());
	}

	/**
	 * tests the getAvgDuration method for 5 tasks
	 */
	@Test
	void testGetAvgDuration() {
		AbstractTaskLog category = new CategoryLog("Design");
		Task t = new Task("Name", 20, "Details");
		Task t2 = new Task("Name2", 25, "Details2");
		Task t3 = new Task("Name3", 30, "Details3");
		category.addTask(t);
		category.addTask(t2);
		category.addTask(t3);
		assertEquals(25.0, category.getAvgDuration());
	}

	/**
	 * tests the getTasksAsArray method for 3 tasks
	 */
	@Test
	void testGetTasksAsArray() {
		AbstractTaskLog category = new CategoryLog("Design");
		Task t = new Task("Name", 20, "Details");
		category.addTask(t);
		String[][] arr = category.getTasksAsArray();
		assertEquals("Name", arr[0][0]);
		assertEquals("20", arr[0][1]);
		assertEquals("Design", arr[0][2]);

	}

	/**
	 * tests turning a taskLog to string form with 3 tasks
	 */
	@Test
	void testToString() {
		AbstractTaskLog category = new CategoryLog("Design");
		Task t = new Task("Name", 20, "Details");
		Task t2 = new Task("Name2", 25, "Details2");
		Task t3 = new Task("Name3", 30, "Details3");
		category.addTask(t);
		category.addTask(t2);
		category.addTask(t3);
		assertEquals("Design,3,20,30,25.0", category.toString());
	}

}
