package edu.ncsu.csc216.wolf_tracker.model.project;

import java.io.File;

import edu.ncsu.csc216.wolf_tracker.model.log.AbstractTaskLog;
import edu.ncsu.csc216.wolf_tracker.model.log.AllTasksLog;
import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;
import edu.ncsu.csc216.wolf_tracker.model.util.ISortedList;

public class Project {

	private ISortedList<CategoryLog> categories;
	
	private String projectName;
	
	private boolean isChanged;
	
	private AllTasksLog allTasksLog;
	
	private AbstractTaskLog currentLog;
	
	public Project(String projectName) {
		
	}
	
	public void saveProject(File projectFile) {
		
	}
	
	public void saveStats(File statsFile) {
		
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	private void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public boolean isChanged() {
		return isChanged;
	}
	
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}
	
	public void addCategoryLog(String categoryName) {
		
	}
	
	public AbstractTaskLog getCurrentLog() {
		return null;
	}
	
	public void setCurrentTaskLog(String logName) {
		
	}
	
	public String[] getCategoryNames() {
		return null;
	}
	
	public void editCategoryLogName(String categoryName) {
		
	}
	
	public void removeCategoryLog() {
		
	}
	
	public void addTask(Task t) {
		
	}
	
	public void editTask(int idx, String taskName, int taskDuration, String taskDetails) {
		
	}
	
	public void removeTask(int idx) {
		
	}
	
	public String[][] getMostRecentTasks() {
		return null;
	}
}
