package edu.ncsu.csc216.wolf_tracker.model.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        String expectedProjectName = "Test Project";
        String[] expectedCategoryNames = {"Category1", "Category2", "All Tasks"};
        String expectedMostRecentTask = "Sample Task";
        
        File projectFile = new File("test-files/test_project.txt");
        Project project = ProjectReader.readProjectFile(projectFile);

        assertEquals(expectedProjectName, project.getProjectName());

        assertArrayEquals(expectedCategoryNames, project.getCategoryNames());

        String[][] mostRecentTasks = project.getMostRecentTasks();
        assertEquals(expectedMostRecentTask, mostRecentTasks[0][0]);
        assertEquals(expectedMostRecentTask, mostRecentTasks[1][0]);

        assertTrue(project.isChanged());
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
