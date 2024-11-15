package edu.ncsu.csc216.wolf_tracker.model.log;

/**
 * A task log that extends AbstractTaskLog, which holds info on every task in the project, regardless of category
 * @author Cole Hincken
 */
public class AllTasksLog extends AbstractTaskLog {
	
	
	/** String that represents the name of the allTasksLog */
	public static final String ALL_TASKS_NAME = "All Tasks";
	
	
	/**
	 * Default constructor for AllTasksLog
	 */
	public AllTasksLog() {
		super(ALL_TASKS_NAME);
	}

	
	
	/**
	 * Sets the allTaskLog's name to the parameter name
	 * @param taskLogName the name to be set to
	 * @throws IllegalArgumentException if taskLogName is not equal to ALL_TASKS_NAME
	 */
	public void setTaskLogName(String taskLogName) {
        if (!ALL_TASKS_NAME.equals(taskLogName)) {
            throw new IllegalArgumentException("The All Tasks log may not be edited.");
        }
        super.setTaskLogName(taskLogName);
    }
}
