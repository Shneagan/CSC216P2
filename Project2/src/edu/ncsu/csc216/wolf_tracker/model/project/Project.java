package edu.ncsu.csc216.wolf_tracker.model.project;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.io.ProjectWriter;
import edu.ncsu.csc216.wolf_tracker.model.log.AbstractTaskLog;
import edu.ncsu.csc216.wolf_tracker.model.log.AllTasksLog;
import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tracker.model.util.LogList;
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
		if (categoryName == AllTasksLog.ALL_TASKS_NAME) {
			throw new IllegalArgumentException("Invalid name.");
		}
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
		boolean found = false;
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getName().equals(logName)) {
				currentLog = categories.get(i);
				found = true;
				break;
			}
		}
		if (!found) {
			currentLog = allTasksLog;
		}
		
	}
	
	/**
	 * getes the names of all categories
	 * @return A string array of all the category names
	 */
	public String[] getCategoryNames() {
		String[] categoryNames = new String[categories.size() + 1];
		categoryNames[0] = AllTasksLog.ALL_TASKS_NAME;
		for (int i = 1; i <= categories.size(); i++) {
			categoryNames[i] = categories.get(i - 1).getName();
		}
		return categoryNames;
	}
	
	/**
	 * change the name of the category
	 * @param categoryName name to be changed to 
	 * @throws IllegalArgumentException if the categoryName parameter is a duplicate of another categories name
	 * @throws IllegalArgumentException if the categoryName is null or empty or the same as the name of the alltasksLog.
	 * @throws IllegalArgumentException if the current log is the allTasksLog
	 */
	public void editCategoryLogName(String categoryName) {
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getName().equals(categoryName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		if (categoryName == null || categoryName.isEmpty() || categoryName == AllTasksLog.ALL_TASKS_NAME) {
			throw new IllegalArgumentException("Invalid name.");
		}
		if (currentLog instanceof AllTasksLog) {
			throw new IllegalArgumentException("The All Tasks log may not be edited.");
		}
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getName().equals(currentLog.getName())) {
				CategoryLog category = categories.remove(i);
				category.setTaskLogName(categoryName);
				categories.add(category);
				isChanged = true;	
			}
		}
	}
	
	/**
	 * Removes the current log category
	 * @throws IllegalArgumentException if the current log is the alltasksLog
	 */
	public void removeCategoryLog() {
		if (currentLog instanceof AllTasksLog) {
			throw new IllegalArgumentException("The All Tasks log may not be deleted.");
		}
	    String categoryName = currentLog.getName();
	  	for (int i = 0; i < categories.size(); i++) {
	    	if (categories.get(i).getName() == categoryName) {
	    		categories.remove(i);
	    	}
	    }
	  	for (int i = 0; i < allTasksLog.getTasks().size(); i++) {
	    	if (allTasksLog.getTask(i).getCategoryName().equals(categoryName)) {
	    		  allTasksLog.getTasks().removeLog(i);
	    	}
	    }
	    
	    currentLog = allTasksLog;
	    isChanged = true;	
	}
	
	/**
	 * Adds a task to the currentLog
	 * @param t Task to be added
	 */
	public void addTask(Task t) {
		if (currentLog instanceof CategoryLog) {
			currentLog.addTask(t);
			allTasksLog.addTask(t);
			isChanged = true;
		}
	}
	
	/**
	 * Changes a tasks information
	 * @param idx index of the task to be changed
	 * @param taskName New name for the task
	 * @param taskDuration New duration for the task
	 * @param taskDetails New description of the task
	 */
	public void editTask(int idx, String taskName, int taskDuration, String taskDetails) {
		currentLog.getTask(idx).setTaskTitle(taskName);
		currentLog.getTask(idx).setTaskDuration(taskDuration);
		currentLog.getTask(idx).setTaskDetails(taskDetails);
		isChanged = true;
	}
	
	/**
	 * Removes a task that is at the given index in the current log
	 * @param idx the index of the task to be removed
	 */
	public void removeTask(int idx) {
		if (!(currentLog instanceof AllTasksLog)) {
			currentLog.removeTask(idx);
		}
		allTasksLog.removeTask(idx);
		isChanged = true;
	}
	
	/**
	 * Gets a 2D array of the most recently added tasks
	 * @return A 2D array of task objects
	 */
	public String[][] getMostRecentTasks() {
		String[][] recentTasks = new String[categories.size()][3];
		for (int i = 0; i < categories.size(); i++) {
			CategoryLog category = categories.get(i);
			
			LogList<Task> tasks = category.getTasks();
			if (tasks.size() != 0) {
				Task mostRecent = tasks.getLog(tasks.size() - 1);
				recentTasks[i][0] = mostRecent.getTaskTitle();
				recentTasks[i][1] = Integer.toString(mostRecent.getTaskDuration());
				recentTasks[i][2] = mostRecent.getCategoryName();
			}
			else {
				recentTasks[i][0] = "None";
				recentTasks[i][1] = "";
				recentTasks[i][2] = category.getName();
			}
		}
		
		return recentTasks;
	}

}
