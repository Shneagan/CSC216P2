package edu.ncsu.csc216.wolf_tracker.model.io;

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
        String expectedProjectName = "CSC 216 Task Log";

        File projectFile = new File("test-files/test_project.txt");
        Project project = ProjectReader.readProjectFile(projectFile);
        project.setCurrentTaskLog("Design");
        assertEquals(expectedProjectName, project.getProjectName());
        assertEquals(2, project.getCurrentLog().getTaskCount());

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
    
    /**
     * Tests project1.txt
     */
    @Test
    public void testProject1() {
    	File project1File = new File("test-files/project1.txt");
    	Project project = ProjectReader.readProjectFile(project1File);
    	String[] categoryNames = new String[8];
    	categoryNames[0] = "All Tasks";
    	categoryNames[1] = "Debugging";
    	categoryNames[2] = "Deployment";
    	categoryNames[3] = "Design";
    	categoryNames[4] = "Documentation";
    	categoryNames[5] = "Implementation";
    	categoryNames[6] = "System Test";
    	categoryNames[7] = "Unit Test";
    	assertEquals("CSC 216 Task Log", project.getProjectName());
    	assertEquals(categoryNames[3], project.getCategoryNames()[3]);
    }
    
    /**
     * Tests a TS Test
     * 
     */
    @Test
    public void testRecentTask() {
    	File project1File = new File("test-files/project1.txt");
    	Project project = ProjectReader.readProjectFile(project1File);  
    	project.setCurrentTaskLog("Design");
    	project.removeTask(3);
    	project.setCurrentTaskLog("All Tasks");
    	assertEquals("CSC 216 Task Log", project.getProjectName());
    	String[][] mostRecent = project.getMostRecentTasks();
    	assertEquals(mostRecent[0][0], "Debugging Reader Bug");   	
    }
    
    /**
     * Tests project0.txt
     */
    @Test
    public void testProject0() {
    	File project0File = new File("test-files/project0.txt");
    	Project project = ProjectReader.readProjectFile(project0File);  
    	assertEquals("CSC 216 Project 2", project.getProjectName());
    }
    

    
}

