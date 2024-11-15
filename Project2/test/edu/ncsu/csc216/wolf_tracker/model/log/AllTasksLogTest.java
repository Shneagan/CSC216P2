package edu.ncsu.csc216.wolf_tracker.model.log;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the allTasksLog class that extends the AbstractTaskLog class
 */
public class AllTasksLogTest {

	/**
	 * tests setting the tasklogName field
	 */
	@Test
	public void testSetTaskLogName() {
		AllTasksLog allTasksLog = new AllTasksLog();
		assertThrows(IllegalArgumentException.class, () -> allTasksLog.setTaskLogName("Hello"));
		allTasksLog.setTaskLogName("All Tasks");
		assertEquals("All Tasks", allTasksLog.getName());
	}
	

}
