package edu.ncsu.csc216.wolf_tracker.model.task;

import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;

/**
 * A simple Java class that holds information on an individual task, 
 * like its title, duration, and description
 * @author Cole Hincken
 */
public class Task {

	/** The name of the task */
	private String taskTitle;
	
	/** The length of time, in minutes, that task lasts for */
	private int taskDuration;
	
	/** a description of the task and its events */
	private String taskDetails;
	
	/** the category that the task resides in */
	private CategoryLog category;
	
	/**
	 * Constructs a Task object
	 * @param taskTitle the name of the task
	 * @param taskDuration the time, in minutes, the task lasts for
	 * @param taskDetails a description of the task
	 */
	public Task(String taskTitle, int taskDuration, String taskDetails) {
		setTaskTitle(taskTitle);
		setTaskDuration(taskDuration);
		setTaskDetails(taskDetails);
	}

	/** Gets the name of the task
	 * @return the taskTitle
	 */
	public String getTaskTitle() {
		return taskTitle;
	}

	/** Sets the name of the Task
	 * @param taskTitle the title to set
	 */
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	/** gets the duration field of the task
	 * @return the taskDuration
	 */
	public int getTaskDuration() {
		return taskDuration;
	}

	/** Sets the duration field to the parameter value
	 * @param taskDuration the taskDuration to set
	 */
	public void setTaskDuration(int taskDuration) {
		this.taskDuration = taskDuration;
	}

	/** gets the details field of the task
	 * @return the taskDetails
	 */
	public String getTaskDetails() {
		return taskDetails;
	}

	/** sets the details field to the parameter value
	 * @param taskDetails the taskDetails to set
	 */
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	
	/**
	 * Adds a category to the category list
	 * @param categoryLog a category
	 */
	public void addCategory(CategoryLog categoryLog) {
		
	}
	
	/**
	 * Gets the name of the category 
	 * @return name of category
	 */
	public String getCategoryName() {
		return null;
	}
	
	/**
	 * Converts the task information to a string form
	 * @return a string of all task information
	 */
	public String toString() {
		return null;
	}
	
}
