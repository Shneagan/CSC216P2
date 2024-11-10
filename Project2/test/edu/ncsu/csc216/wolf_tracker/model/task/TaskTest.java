package edu.ncsu.csc216.wolf_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * tests the Task class
 * @author Cole Hincken
 */
class TaskTest {

	/**
	 * Tests the task constructor for both invalid and valid inputs
	 */
	@Test
	void testTask() {
		Task task = assertDoesNotThrow( () -> new Task("NewTask", 10, "Task Details"));
		
			assertAll("", 
				() -> assertEquals("NewTask", task.getTaskTitle(), "incorrect name"), 
				() -> assertEquals(10, task.getTaskDuration(), "incorrect duration"),
				() -> assertEquals("Task Details", task.getTaskDetails(), "incorrect details"));					
	}

	/**
	 * tests the getTaskTitle method
	 */
	@Test
	void testGetTaskTitle() {
		Task t = new Task("TaskName", 15, "TaskDetails");
		assertEquals("TaskName", t.getTaskTitle());
		
	}

	/**
	 * test the setTaskTitle method
	 */
	@Test
	void testSetTaskTitle() {
		Task t = new Task("TaskName", 15, "TaskDetails");
		assertThrows(IllegalArgumentException.class, () -> t.setTaskTitle(null));
		
		assertThrows(IllegalArgumentException.class, () -> t.setTaskTitle(""));
	
		Task t2 = new Task("TaskName", 20, "TaskDetails");
		t2.setTaskTitle("NewTaskTitle");
		assertEquals("NewTaskTitle", t2.getTaskTitle());
	}

	/**
	 * tests the getTaskDuration method
	 */
	@Test
	void testGetTaskDuration() {
		Task t = new Task("TaskName", 15, "TaskDetails");
		assertEquals(15, t.getTaskDuration());
	}

	/**
	 * tests the setTaskDuration metho
	 */
	@Test
	void testSetTaskDuration() {
		Task t = new Task("TaskName", 15, "TaskDetails");
		assertThrows(IllegalArgumentException.class, () -> t.setTaskDuration(-10));	
		t.setTaskDuration(25);
		assertEquals(25, t.getTaskDuration());
	}
	
	
	/**
	 * Tests the getTaskDetails method
	 */
	@Test
	void testGetTaskDetails() {
		fail("Not yet implemented");
	}

	/**
	 * tests the setTaskDetails method
	 */
	@Test
	void testSetTaskDetails() {
		fail("Not yet implemented");
	}
	
	/**
	 * tests the addCategory method
	 */
	@Test
	void testAddCategory() {
		fail("Not yet implemented");
	}

	/**
	 * tests the getCategoryName method
	 */
	@Test
	void testGetCategoryName() {
		fail("Not yet implemented");
	}

	/**
	 * tests the toString method
	 */
	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
