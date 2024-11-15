package edu.ncsu.csc216.wolf_tracker.model.log;

import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Category log that holds information on logged tasks for a certain category
 * @author Cole Hincken
 */
public class CategoryLog extends AbstractTaskLog implements Comparable<CategoryLog> {

	/**
	 * Constructs a category log using the AbstractTaskLog constuctor
	 * @param taskLogName the name of the categoryLog
	 */
	public CategoryLog(String taskLogName) {
		super(taskLogName);
	}
	
	/**
	 * sets the value at the index in the list to a task object
	 * @param index the list index where the task will be added
	 * @param t the task to be added
	 */
	@Override
	public void setTask(int index, Task t) {
		super.setTask(index, t);
		t.addCategory(this);
	}
	
	/**
	 * adds a task to the list
	 * @param t the task to be added
	 */
	@Override
	public void addTask(Task t) {
		super.addTask(t);
		t.addCategory(this);
	}

	/**
	 * Comapres this categoryLog to another categorylog.
	 * @param o object being compared
	 * @return 0 if the objects are the same, 1 if the existing object is greater than the parameter object,
	 * and -1 if the existing object is less than the parameter object
	 */
	@Override
	public int compareTo(CategoryLog o) {
		if (this.getName().compareTo(o.getName()) == 0) {
			return 0;
		}
		else if (this.getName().compareTo(o.getName()) < 0) {
			return -1;
		}
		else {
			return 1;
		}

	}

	

}
