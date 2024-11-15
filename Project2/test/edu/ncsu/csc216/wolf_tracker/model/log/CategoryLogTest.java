package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Tests the CategoryLog class which extends the AbstractTaskLog class
 */
class CategoryLogTest {

	/**
	 * Tests the CategoryLog addTask method
	 */
	@Test
	void testAddTask() {
		CategoryLog category = new CategoryLog("Design");
		Task t = new Task("TaskName", 10, "TaskDetails");
		category.addTask(t);
		assertEquals(t, category.getTask(0));
	}

	/**
	 * Tests the CategoryLog setTask method
	 */
	@Test
	void testSetTask() {
		CategoryLog category = new CategoryLog("Design");
		Task t = new Task("TaskName", 10, "TaskDetails");
		Task t2 = new Task("Task2", 20, "Task2Details");
		Task t3 = new Task("Task3", 15, "Task3Details");
		category.addTask(t);
		category.addTask(t2);
		category.setTask(1, t3);
		assertEquals(t3, category.getTask(1));
		assertEquals(t, category.getTask(0));

	}

	/**
	 * Tests the compareTo method
	 */
	@Test
	void testCompareTo() {
		CategoryLog category = new CategoryLog("Design");
		CategoryLog category2 = new CategoryLog("Design");
		CategoryLog category3 = new CategoryLog("Active");
		CategoryLog category4 = new CategoryLog("Inactive");


		assertEquals(0, category.compareTo(category2));
		assertEquals(-1, category.compareTo(category4));
		assertEquals(1, category.compareTo(category3));
	}

}
