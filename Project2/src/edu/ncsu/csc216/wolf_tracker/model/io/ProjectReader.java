package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;

/**
 * Reads in file texts and converts that text into objects and data that can be used by the Controller
 * @author Cole Hincken
 */
public class ProjectReader {

	/**
	 * reads in a file and turns the string text into a Project object 
	 * @param file the file object that is being read in
	 * @return A project object that contains all the info in the file
	 */
	public static Project readProjectFile(File file) {
		return null;
	}
	
	/**
	 * Processes a single task string in a File and creates a task object to be put in a Project object
	 * @param project the project that will contain the task
	 * @param task the String form of the task that will be processed
	 */
	private static void processTask(Project project, String task) {
		
	}
}
