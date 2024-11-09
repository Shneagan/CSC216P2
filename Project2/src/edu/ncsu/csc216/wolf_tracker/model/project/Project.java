package edu.ncsu.csc216.wolf_tracker.model.project;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.io.ProjectWriter;
import edu.ncsu.csc216.wolf_tracker.model.log.AbstractTaskLog;
import edu.ncsu.csc216.wolf_tracker.model.log.AllTasksLog;
import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tracker.model.util.SortedList;

/**
 * Contains all information about a project and holds controller methods that can add
 * and remove both categories and tasks
 * @author Cole Hincken
 */
public class Project {

	/** A list of categories */
	private ISortedList<CategoryLog> categories;
	
	/** The name of the project */
	private String projectName;
	
	/** Checks if the project has been changed or not, for saving purposes */
	private boolean isChanged;
	
	/** A list containing all tasks cumulatively */
	private AllTasksLog allTasksLog;
	
	/** currently accessed list */
	private AbstractTaskLog currentLog;
	
	/**
	 * Constructs a project object
	 * @param projectName name of the project
	 * @throws IllegalArgumentException if projectname is null, empty, or matches the alltaskslog name
	 */
	public Project(String projectName) {
		if (projectName == null || projectName.isEmpty() || projectName == AllTasksLog.ALL_TASKS_NAME) {
			throw new IllegalArgumentException("Invalid name.");
		}
			
		setProjectName(projectName);
		categories = new SortedList<CategoryLog>();
		allTasksLog = new AllTasksLog();
		currentLog = allTasksLog;
		isChanged = true;
	}
	
	/**
	 * Saves the project objects info to a file
	 * @param projectFile the file to be written to
	 */
	public void saveProject(File projectFile) {
		ProjectWriter.writeProjectFile(projectFile, this);
		isChanged = false;
	}
	
	/**
	 * Saves the summary statistics information to a file
	 * @param statsFile file to be written to
	 */
	public void saveStats(File statsFile) {
		ProjectWriter.writeStatsFile(statsFile, this);
	}
	
	/**
	 * Gets the name of the project
	 * @return name of the project
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * Sets the name of the project
	 * @param projectName the name to be set
	 */
	private void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	/**
	 * gets the boolean isChanged, which checks if the project info has been adjusted
	 * @return true if project has been changed or modified, false otherwise
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * sets the boolean field to either true or false
	 * @param isChanged true or false depending on if the project has been changed or not
	 */
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}
	
	/**
	 * Adds a category to the list of categories
	 * @param categoryName name of the category to be added
	 */
	public void addCategoryLog(String categoryName) {
		CategoryLog newLog = new CategoryLog(categoryName);
		currentLog = newLog;
		categories.add(newLog);
		isChanged = true;
	}
	
	/**
	 * Gets the current log (list) of task objects
	 * @return the currently viewed list
	 */
	public AbstractTaskLog getCurrentLog() {
		return currentLog;
	}
	
	/**
	 * sets the current task log to a specific log
	 * @param logName the log to be changed to 
	 */
	public void setCurrentTaskLog(String logName) {

	}
	
	/**
	 * getes the names of all categories
	 * @return A string array of all the category names
	 */
	public String[] getCategoryNames() {
		return null;
	}
	
	/**
	 * change the name of the category
	 * @param categoryName name to be changed to 
	 */
	public void editCategoryLogName(String categoryName) {
		
	}
	
	/**
	 * Removes the current log category
	 */
	public void removeCategoryLog() {
		
	}
	
	/**
	 * Adds a task to the currentLog
	 * @param t Task to be added
	 */
	public void addTask(Task t) {
		
	}
	
	/**
	 * Changes a tasks information
	 * @param idx index of the task to be changed
	 * @param taskName New name for the task
	 * @param taskDuration New duration for the task
	 * @param taskDetails New description of the task
	 */
	public void editTask(int idx, String taskName, int taskDuration, String taskDetails) {
		
	}
	
	/**
	 * Removes a task that is at the given index in the current log
	 * @param idx the index of the task to be removed
	 */
	public void removeTask(int idx) {
		
	}
	
	/**
	 * Gets a 2D array of the most recently added tasks
	 * @return A 2D array of task objects
	 */
	public String[][] getMostRecentTasks() {
		return null;
	}
}
