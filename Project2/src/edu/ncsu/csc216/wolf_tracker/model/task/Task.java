package edu.ncsu.csc216.wolf_tracker.model.task;

import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;

public class Task {

	private String taskTitle;
	
	private int taskDuration;
	
	private String taskDetails;
	
	private CategoryLog category;
	
	public Task(String taskTitle, int taskDuration, String taskDetails) {
		setTaskTitle(taskTitle);
		setTaskDuration(taskDuration);
		setTaskDetails(taskDetails);
	}

	/**
	 * @return the taskTitle
	 */
	public String getTaskTitle() {
		return taskTitle;
	}

	/**
	 * @param taskTitle the taskTitle to set
	 */
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	/**
	 * @return the taskDuration
	 */
	public int getTaskDuration() {
		return taskDuration;
	}

	/**
	 * @param taskDuration the taskDuration to set
	 */
	public void setTaskDuration(int taskDuration) {
		this.taskDuration = taskDuration;
	}

	/**
	 * @return the taskDetails
	 */
	public String getTaskDetails() {
		return taskDetails;
	}

	/**
	 * @param taskDetails the taskDetails to set
	 */
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	
	public void addCategory(CategoryLog categoryLog) {
		
	}
	
	public String getCategoryName() {
		return null;
	}
	
	public String toString() {
		return null;
	}
	
}
