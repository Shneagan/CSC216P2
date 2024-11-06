package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.project.Project;

/**
 * Writes a project objects data to a File in string form
 * @author Cole Hincken
 */
public class ProjectWriter {

	/**
	 * Writes a Projects data to a File in string form
	 * @param projectFile the file that is to be created and written to. If the file already exists, the file is overwritten.
	 * @param project the Project object that we are pulling data from
	 */
	public static void writeProjectFile(File projectFile, Project project) {
		
	}
	
	/**
	 * Writes the summary statistics to file form
	 * @param statsFile the file to be created and written to. If the file exists, it is overwritten.
	 * @param project the Project object that we are pulling the stats from
	 */
	public static void writeStatsFile(File statsFile, Project project) {
		
	}
}
