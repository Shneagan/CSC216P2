package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.LogList;

/**
 * An Abstract class that contains information on a list of tasks, to be used by both the All Tasks Log and Category Log
 * @author Cole Hincken
 */
public abstract class AbstractTaskLog {

	/** the name of the list of tasks */
	private String taskLogName;
	
	/** the List of tasks which uses a custom list implementation to operate */
	private LogList<Task> tasks;

	/**
	 * Constructs a task log object
	 * @param taskLogName the name of the task log
	 */
	public AbstractTaskLog(String taskLogName) {
		setTaskLogName(taskLogName);
		this.tasks = new LogList<>();
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
	 * @throws IllegalArgumentException if name is empty or null
	 */
	public void setTaskLogName(String taskLogName) {
		if (taskLogName == null || taskLogName.isEmpty()) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.taskLogName = taskLogName;
	}
	
	/**
	 * gets the list of task objects
	 * @return a list of task objects
	 */
	public LogList<Task> getTasks() {
		return tasks;
	}
	
	/**
	 * adds a task to the list
	 * @param t the task to be added
	 * @throws NullPointerException if the task is null (thrown by ILogList)
	 */
	public void addTask(Task t) {
		tasks.addLog(t);
	}
	
	/**
	 * sets the value at the index in the list to a task object
	 * @param index the list index where the task will be added
	 * @param t the task to be added
	 * @throws NullPointerException if t is null
	 * @throws IndexOutOfBoundsException if index is negative or greater than size of the list
	 */
	public void setTask(int index, Task t) {
		tasks.setLog(index, t);
	}
	
	/**
	 * Removes a task from the index parameter position
	 * @param index the index where the task will be removed
	 * @return the task that is removed
	 * @throws IndexOutOfBoundsException if the index is out of bounds for the size of the list
	 */
	public Task removeTask(int index) {
		return tasks.removeLog(index);
	}
	
	/**
	 * gets the task at the certain index
	 * @param index the index where the task we are finding exists
	 * @return the task at the index parameter
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 */
	public Task getTask(int index) {
		return tasks.getLog(index);
	}
	
	/**
	 * gets the number of tasks in the log
	 * @return integer number of tasks
	 */
	public int getTaskCount() {
		return tasks.size();
	}
	
	/**
	 * Finds the task with the shortest duration and returns that duration
	 * @return integer number of time (in minutes)
	 */
	public int getMinDuration() {
		int min = 10000000;
		for (int i = 0; i < tasks.size(); i++) {
			Task t = tasks.getLog(i);
			if (t.getTaskDuration() < min) {
				min = t.getTaskDuration();
			}
		}
		return min;
	}
	
	/**
	 * Finds the task with the longest duration and returns that duration
	 * @return integer number of time (in minutes)
	 */
	public int getMaxDuration() {
		int max = 0;
		for (int i = 0; i < tasks.size(); i++) {
			Task t = tasks.getLog(i);
			if (t.getTaskDuration() > max) {
				max = t.getTaskDuration();
			}
		}
		return max;
	}
	
	/**
	 * Gets the average duration of time of all the tasks in the task log
	 * @return a decimal number of time (in minutes)
	 */
	public double getAvgDuration() {
		int sum = 0;
		for (int i = 0; i < tasks.size(); i++) {
			sum += tasks.getLog(i).getTaskDuration();
		}
		return sum / tasks.size();
	}
	
	/**
	 * Accumulates all the tasks in the list and puts them in array form
	 * @return a 2D array that contains info on all the tasks
	 */
	public String[][] getTasksAsArray() {
		String[][] taskArray = new String[tasks.size()][3];
		for (int i = 0; i < tasks.size(); i++) {
			taskArray[i][0] = tasks.getLog(i).getTaskTitle();
			taskArray[i][1] = Integer.toString(tasks.getLog(i).getTaskDuration());
			taskArray[i][2] = tasks.getLog(i).getCategoryName();
		}
		return taskArray;
	}
	
	/**
	 * Returns a string representation of the task log
	 * @return string that holds info on all the tasks in the task log
	 */
	public String toString() {
		return getName() + "," + getTaskCount() + "," + getMinDuration() + "," + getMaxDuration() + "," + getAvgDuration();
	}
}
