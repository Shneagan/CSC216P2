package edu.ncsu.csc216.wolf_tracker.model.io;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;

/**
 * Tests the ProjectReader class by reading project files and verifying output.
 */
public class ProjectReaderTest {


    /**
     * Tests reading a valid project file.
     */
    @Test
    public void testReadValidProjectFile() {
    	// Setup: Define expected project name, categories, and tasks based on input data
        String expectedProjectName = "Test Project";
        String[] expectedCategoryNames = {"Category1", "Category2", "All Tasks"};
        String expectedMostRecentTask = "Sample Task";  // Task title to check for
        
        // Call ProjectReader to create the Project
        File projectFile = new File("test_project.txt");  // Adjust file path accordingly
        Project project = ProjectReader.readProjectFile(projectFile);

        // Check the project name
        assertEquals(expectedProjectName, project.getProjectName());

        // Check the categories
        assertArrayEquals(expectedCategoryNames, project.getCategoryNames());

        // Verify the most recent tasks in each category
        String[][] mostRecentTasks = project.getMostRecentTasks();
        assertEquals(expectedMostRecentTask, mostRecentTasks[0][0]);  // For Category1
        assertEquals(expectedMostRecentTask, mostRecentTasks[1][0]);  // For Category2

        // Optionally check the change status
        assertTrue(project.isChanged());  // or false depending on expected behavior
    }

    /**
     * Tests reading a non-existent file, expecting an IllegalArgumentException.
     */
    @Test
    public void testReadNonExistentFile() {
        File nonExistentFile = new File("nonexistent.txt");
        assertThrows(IllegalArgumentException.class, () -> {
            ProjectReader.readProjectFile(nonExistentFile);
        });
    }
}
