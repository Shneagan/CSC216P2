package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ILogList;
import edu.ncsu.csc216.wolf_tracker.model.util.LogList;

/**
 * An Abstract class that contains information on a list of tasks, to be used by both the All Tasks Log and Category Log
 * @author Cole Hincken
 */
public abstract class AbstractTaskLog {

	/** the name of the list of tasks */
	private String taskLogName;
	
	/** the List of tasks which uses a custom list implementation to operate */
	private ILogList<Task> tasks;

	/**
	 * Constructs a task log object
	 * @param taskLogName the name of the task log
	 */
	public AbstractTaskLog(String taskLogName) {
		
	}
	
	/**
	 * Gets the name of the taskLog
	 * @return the name of the task log in string form
	 */
	public String getName() {
		return this.taskLogName;
	}
	
	/**
	 * sets the name of the task log
	 * @param taskLogName the name that the task log will be given
	 */
	public void setTaskLogName(String taskLogName) {
		
	}
	
	/**
	 * gets the list of task objects
	 * @return a list of task objects
	 */
	public LogList<Task> getTasks() {
		return null;
	}
	
	/**
	 * adds a task to the list
	 * @param t the task to be added
	 */
	public void addTask(Task t) {
		
	}
	
	/**
	 * sets the value at the index in the list to a task object
	 * @param index the list index where the task will be added
	 * @param t the task to be added
	 */
	public void setTask(int index, Task t) {
		
	}
	
	/**
	 * Removes a task from the index parameter position
	 * @param index the index where the task will be removed
	 * @return the task that is removed
	 */
	public Task removeTask(int index) {
		return null;
	}
	
	/**
	 * gets the task at the certain index
	 * @param index the index where the task we are finding exists
	 * @return the task at the index parameter
	 */
	public Task getTask(int index) {
		return null;
	}
	
	/**
	 * gets the number of tasks in the log
	 * @return integer number of tasks
	 */
	public int getTaskCount() {
		return 0;
	}
	
	/**
	 * Finds the task with the shortest duration and returns that duration
	 * @return integer number of time (in minutes)
	 */
	public int getMinDuration() {
		return 0;
	}
	
	/**
	 * Finds the task with the longest duration and returns that duration
	 * @return integer number of time (in minutes)
	 */
	public int getMaxDuration() {
		return 0;
	}
	
	/**
	 * Gets the average duration of time of all the tasks in the task log
	 * @return a decimal number of time (in minutes)
	 */
	public double getAvgDuration() {
		return 0.0;
	}
	
	/**
	 * Accumulates all the tasks in the list and puts them in array form
	 * @return a 2D array that contains info on all the tasks
	 */
	public String[][] getTasksAsArray() {
		return null;
	}
	
	/**
	 * Returns a string representation of the task log
	 * @return string that holds info on all the tasks in the task log
	 */
	public String toString() {
		return null;
	}
}
