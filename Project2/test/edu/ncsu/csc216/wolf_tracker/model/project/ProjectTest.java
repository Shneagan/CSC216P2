package edu.ncsu.csc216.wolf_tracker.model.project;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.log.AllTasksLog;
import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Tests the project class, which acts as a controller for the model
 */
public class ProjectTest {

	/**
	 * tests creating a project object
	 */
	@Test
	public void testProject() {
		assertThrows(IllegalArgumentException.class, () -> new Project(""));
		assertThrows(IllegalArgumentException.class, () -> new Project(null));
		assertThrows(IllegalArgumentException.class, () -> new Project("All Tasks"));
		Project p = new Project("ProjectName");
		assertEquals("ProjectName", p.getProjectName());
		assertEquals(true, p.getCurrentLog() instanceof AllTasksLog);
		assertEquals(true, p.isChanged());
	}

	/**
	 * tests saving project information to a file
	 */
	@Test
	public void testSaveProject() {
		Project p = new Project("ProjectName");
		p.addTask(new Task("Name", 20, "Details"));
        try {
            p.saveProject(new File("test_save_project.txt"));
            File file = new File("test_save_project.txt");
            assertTrue(file.exists());
        } catch (IllegalArgumentException e) {
            fail("Unable to save the apps to the file.");
        }	
	}

	/**
	 * tests saving statistics to a file
	 */
	@Test
	public void testSaveStats() {
		Project p = new Project("ProjectName");
		p.addTask(new Task("Name", 20, "Details"));
		p.addTask(new Task("Name2", 30, "Details"));
        try {
            p.saveStats(new File("test_save_stats.txt"));
            File file = new File("test_save_stats.txt");
            assertTrue(file.exists());
        } catch (IllegalArgumentException e) {
            fail("Unable to save the apps to the file.");
        }
	}

	/**
	 * tests the getProjectName method
	 */
	@Test
	public void testGetProjectName() {
        Project p = new Project("ProjectName");
        assertEquals("ProjectName", p.getProjectName());
    }

	/**
	 * tests the isChanged method
	 */
	@Test
	public void testIsChanged() {
        Project p = new Project("ProjectName");
        assertTrue(p.isChanged());
        p.setChanged(false);
        assertFalse(p.isChanged());
    }

	/**
	 * tests the setChanged method
	 */
	@Test
	public void testSetChanged() {
		Project p = new Project("ProjectName");
        p.setChanged(false);
        assertFalse(p.isChanged());
        p.setChanged(true);
        assertTrue(p.isChanged());
    }

	/**
	 * Tests the addCategoryLog method
	 */
	@Test
	public void testAddCategoryLog() {
	    Project p = new Project("ProjectName");
        p.addCategoryLog("NewCategory");
        p.addCategoryLog("Category2");
        assertEquals(2, p.getCategoryNames().length);
        assertEquals("NewCategory", p.getCategoryNames()[1]);
        assertTrue(p.isChanged());
    }

	/**
	 * tests the getCurrentLog method
	 */
	@Test
	public void testGetCurrentLog() {
        Project p = new Project("ProjectName");
        p.addCategoryLog("NewCategory");
        p.setCurrentTaskLog("NewCategory");
        assertTrue(p.getCurrentLog() instanceof CategoryLog);
        assertEquals("NewCategory", p.getCurrentLog().getName());
    }

	/**
	 * tests the setCurrentLog method
	 */
	@Test
	public void testSetCurrentTaskLog() {
	      Project p = new Project("ProjectName");
	        p.addCategoryLog("Category1");
	        p.addCategoryLog("Category2");
	        
	        p.setCurrentTaskLog("Category1");
	        assertEquals("Category1", p.getCurrentLog().getName());
	        
	        p.setCurrentTaskLog("NonExistingCategory");
	        assertTrue(p.getCurrentLog() instanceof AllTasksLog);
	 }

	/**
	 * tests the getCategoryNames method
	 */
	@Test
	void testGetCategoryNames() {
	     Project p = new Project("ProjectName");
	        p.addCategoryLog("Category1");
	        p.addCategoryLog("Category2");
	        p.addCategoryLog("Category3");
	        String[] categoryNames = p.getCategoryNames();
	        assertEquals(3, categoryNames.length);
	        assertEquals("All Tasks", categoryNames[0]);
	        assertEquals("Category2", categoryNames[1]);
	        assertEquals("Category3", categoryNames[2]);
	}

	/**
	 * tests the editCategoryLogName method
	 */
	@Test
	void testEditCategoryLogName() {
	       Project p = new Project("ProjectName");
	        p.addCategoryLog("Category1");
	        p.setCurrentTaskLog("Category1");
	        p.editCategoryLogName("UpdatedCategory");
	        assertEquals("UpdatedCategory", p.getCurrentLog().getName());
	        
	        assertThrows(IllegalArgumentException.class, () -> p.editCategoryLogName("All Tasks"));
	 }

	/**
	 * tests the removeCategoryLog method
	 */
	@Test
	void testRemoveCategoryLog() {
	      Project p = new Project("ProjectName");
	        p.addCategoryLog("Category1");
	        p.addCategoryLog("Category2");
	        p.removeCategoryLog();
	        assertTrue(p.getCurrentLog() instanceof AllTasksLog);
	        assertEquals(1, p.getCategoryNames().length);
	}

	/**
	 * tests the addTask method
	 */
	@Test
	void testAddTask() {
        Project p = new Project("ProjectName");
        p.addCategoryLog("Category1");
        p.setCurrentTaskLog("Category1");
        Task task = new Task("Task1", 60, "Description");
        p.addTask(task);
        assertEquals(1, p.getCurrentLog().getTasks().size());
        assertTrue(p.isChanged());	}

	/**
	 * tests the editTask method
	 */
	@Test
	void testEditTask() {
        Project p = new Project("ProjectName");
        p.addCategoryLog("Category1");
        p.setCurrentTaskLog("Category1");
        Task task = new Task("Task1", 60, "Description");
        p.addTask(task);
        
        p.editTask(0, "UpdatedTask", 120, "Updated Description");
        assertEquals("UpdatedTask", p.getCurrentLog().getTask(0).getTaskTitle());
        assertEquals(120, p.getCurrentLog().getTask(0).getTaskDuration());
        assertEquals("Updated Description", p.getCurrentLog().getTask(0).getTaskDetails());
        assertTrue(p.isChanged());	}

	/**
	 * tests the removeTask method
	 */
	@Test
	void testRemoveTask() {
	       Project p = new Project("ProjectName");
	        p.addCategoryLog("Category1");
	        p.setCurrentTaskLog("Category1");
	        Task task = new Task("Task1", 60, "Description");
	        p.addTask(task);
	        
	        assertEquals(1, p.getCurrentLog().getTasks().size());
	        p.removeTask(0);
	        assertEquals(0, p.getCurrentLog().getTasks().size());
	        assertTrue(p.isChanged());	}

	/**
	 * tests the getMostRecentTasks method
	 */
	@Test
	void testGetMostRecentTasks() {
	      Project p = new Project("ProjectName");
	        p.addCategoryLog("Category1");
	        Task task1 = new Task("Task1", 30, "Description1");
	        Task task2 = new Task("Task2", 60, "Description2");
	        
	        p.setCurrentTaskLog("Category1");
	        p.addTask(task1);
	        p.addTask(task2);
	        
	        String[][] recentTasks = p.getMostRecentTasks();
	        assertEquals("Task2", recentTasks[0][0]);
	        assertEquals("60", recentTasks[0][1]);
	        assertEquals("Category1", recentTasks[0][2]);	}

}
