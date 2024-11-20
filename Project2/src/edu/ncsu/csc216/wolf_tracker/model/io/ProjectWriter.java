package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.ncsu.csc216.wolf_tracker.model.log.AbstractTaskLog;
import edu.ncsu.csc216.wolf_tracker.model.project.Project;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Writes a project objects data to a File in string form
 * @author Cole Hincken
 */
public class ProjectWriter {

	/**
	 * Writes a Projects data to a File in string form
	 * @param projectFile the file that is to be created and written to. If the file already exists, the file is overwritten.
	 * @param project the Project object that we are pulling data from
	 * @throws IllegalArgumentException if file cannot be written to for any reason
	 */
	public static void writeProjectFile(File projectFile, Project project) {
        try (FileWriter writer = new FileWriter(projectFile)) {
        	writer.write("! " + project.getProjectName() + "\n");
            for (int i = 1; i < project.getCategoryNames().length; i++) {
                writer.write("# " + project.getCategoryNames()[i] + "\n");
            }
            for (int i = 1; i < project.getCategoryNames().length; i++) {
                project.setCurrentTaskLog(project.getCategoryNames()[i]);
                for (int j = 0; j < project.getCurrentLog().getTasks().size(); j++) {
                    Task task = project.getCurrentLog().getTask(j);
                    writer.write("* " + task.getTaskTitle() + "," + task.getTaskDuration() + "," +
                            task.getCategoryName() + "\n");
                    writer.write(task.getTaskDetails() + "\n");
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to save project file.", e);
        }
    }
	
	/**
	 * Writes the summary statistics to file form
	 * @param statsFile the file to be created and written to. If the file exists, it is overwritten.
	 * @param project the Project object that we are pulling the stats from
	 * @throws IllegalArgumentException if statsFile cannot be written to for any reason
	 */
	public static void writeStatsFile(File statsFile, Project project) {
           StringBuilder output = new StringBuilder("Category,Count,Min,Max,Average\n");

        try (FileWriter writer = new FileWriter(statsFile)) {
        	String[] categories = project.getCategoryNames();
            for (int i = 1; i < categories.length; i++) {
            	project.setCurrentTaskLog(project.getCategoryNames()[i]);
            	AbstractTaskLog log = project.getCurrentLog();
                output.append(log.toString()).append("\n");
            }
            project.setCurrentTaskLog("All Tasks");
        	AbstractTaskLog log = project.getCurrentLog();
            output.append(log.toString());
            writer.write(output.toString());

        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to save file", e);
        }
    }
	
	
}

