package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

public class CategoryLog extends AbstractTaskLog implements Comparable<CategoryLog> {

	public CategoryLog(String taskLogName) {
		super(taskLogName);
	}

	@Override
	public int compareTo(CategoryLog o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setTask(int index, Task t) {
		
	}
	
	public void addTask(Task t) {
		
	}

	

}
