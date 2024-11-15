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
		category = null;
	}

	/** Gets the name of the task
	 * @return the taskTitle
	 */
	public String getTaskTitle() {
		return taskTitle;
	}

	/** Sets the name of the Task
	 * @param taskTitle the title to set
	 * @throws IllegalArgumentException if taskTitle is null or empty
	 */
	public void setTaskTitle(String taskTitle) {
		if (taskTitle == null || taskTitle.isEmpty()) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
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
	 * @throws IllegalArgumentException if duration is less than 1
	 */
	public void setTaskDuration(int taskDuration) {
		if (taskDuration < 1) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
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
	 * @throws IllegalArgumentException if details are null or empty
	 */
	public void setTaskDetails(String taskDetails) {
		if (taskDetails == null || taskDetails.isEmpty()) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDetails = taskDetails;
	}
	
	/**
	 * Adds a category to the task
	 * @param categoryLog a category
	 * @throws IllegalArgumentException if parameter is null or category is already assigned.
	 */
	public void addCategory(CategoryLog categoryLog) {
		if (categoryLog == null || this.category != null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.category = categoryLog;
	}
	
	/**
	 * Gets the name of the category 
	 * @return name of category
	 */
	public String getCategoryName() {
		if (category == null) {
			return "";
		}
		return category.getName();
	}
	
	/**
	 * Converts the task information to a string form
	 * @return a string of all task information
	 */
	public String toString() {
		return "* " + taskTitle + "," + taskDuration + "," + getCategoryName() + "\n" + taskDetails;
	}
	
}
