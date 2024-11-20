package edu.ncsu.csc216.wolf_tracker.model.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Tests the projectWriter class
 */
class ProjectWriterTest {

	
	/**
	 * Tests the writeProjectFile method
	 */
	@Test
	void testWriteProjectFile() {
		Project p = new Project("ProjectName");
		p.addCategoryLog("Design");
		p.addTask(new Task("Title", 20, "Details"));
		File projectFile = new File("test-files/test_project2.txt");
		p.saveProject(projectFile);
		try {
			checkFiles("test-files/exp_test_project2", "test-files/test_project2.txt");

		} catch (IllegalArgumentException e) {
			fail("Failed");
		}
		
	}

	/**
	 * Tests the writeStatsFile() method
	 */
	@Test
	void testWriteStatsFile() {
		Project p = new Project("Name");
		p.addCategoryLog("Design");
		p.addTask(new Task("Title", 20, "Details"));
		p.addTask(new Task("Title2", 30, "Details"));
		File statsFile = new File("test-files/act_stats");
		p.saveStats(statsFile);
		try {
			checkFiles("test-files/exp_stats", "test-files/act_stats");
		} catch (IllegalArgumentException e) {
			fail("Failed");
		}
	}

	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 * @throws IllegalArgumentException if the files cannot be found
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (actScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("Cannot save to file");
		}
	

	}
}
