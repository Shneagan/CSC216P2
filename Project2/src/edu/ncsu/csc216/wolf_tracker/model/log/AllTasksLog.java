package edu.ncsu.csc216.wolf_tracker.model.log;

/**
 * A task log that extends AbstractTaskLog, which holds info on every task in the project, regardless of category
 * @author Cole Hincken
 */
public class AllTasksLog extends AbstractTaskLog {
	
	/**
	 * Constructs the allTaskLog with the given parameter name. This constructor uses the AbstractTaskLog constructor to construct
	 * @param taskLogName name of the task log
	 */
	public AllTasksLog(String taskLogName) {
		super(taskLogName);
	}

	/** String that represents the name of the allTasksLog */
	public static final String ALL_TASKS_NAME = "All Tasks";
	
	/**
	 * Sets the allTaskLog's name to the parameter name
	 * @param taskLogName the name to be set to
	 */
	public void setTaskLogName(String taskLogName) {
		
	}
}
