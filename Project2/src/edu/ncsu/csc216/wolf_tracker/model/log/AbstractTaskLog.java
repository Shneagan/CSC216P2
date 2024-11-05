package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ILogList;
import edu.ncsu.csc216.wolf_tracker.model.util.LogList;

public abstract class AbstractTaskLog {

	private String taskLogName;
	
	private ILogList<Task> tasks;
	
	public AbstractTaskLog(String taskLogName) {
		
	}
	
	public String getName() {
		return this.taskLogName;
	}
	
	public void setTaskLogName(String taskLogName) {
		
	}
	
	public LogList<Task> getTasks() {
		return null;
	}
	
	public void addTask(Task t) {
		
	}
	
	public void setTask(int index, Task t) {
		
	}
	
	public Task removeTask(int index) {
		return null;
	}
	
	public Task getTask(int index) {
		return null;
	}
	
	public int getTaskCount() {
		return 0;
	}
	
	public int getMinDuration() {
		return 0;
	}
	
	public int getMaxDuration() {
		return 0;
	}
	
	public double getAvgDuration() {
		return 0.0;
	}
	
	public String[][] getTasksAsArray() {
		return null;
	}
	
	public String toString() {
		return null;
	}
}
