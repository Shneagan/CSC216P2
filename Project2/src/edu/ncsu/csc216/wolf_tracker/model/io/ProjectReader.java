package edu.ncsu.csc216.wolf_tracker.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tracker.model.log.CategoryLog;
import edu.ncsu.csc216.wolf_tracker.model.project.Project;
import edu.ncsu.csc216.wolf_tracker.model.task.Task;

/**
 * Reads in file texts and converts that text into objects and data that can be used by the Controller
 * @author Cole Hincken
 */
public class ProjectReader {

	/**
	 * reads in a file and turns the string text into a Project object 
	 * @param file the file object that is being read in
	 * @return A project object that contains all the info in the file
	 */
    public static Project readProjectFile(File file) {
    	String projectName = "";
    	
    	String fileContent = "";
    	try (Scanner scan = new Scanner(file)) {
    		while (scan.hasNextLine()) {
    			String line = scan.nextLine();
    			line += "\n";
    			fileContent += line;
    		}
    	} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
    	int first = fileContent.indexOf('\n');
    	String line1 = fileContent.substring(0, first);
    	if (line1.charAt(0) != '!') {
    		throw new IllegalArgumentException("Unable to load file.");
    	}
    	projectName = line1.substring(1).strip();
    	Project p = new Project(projectName);
    	fileContent = fileContent.substring(first + 1);
    	
    	Scanner categoryScan = new Scanner(fileContent);
    	categoryScan.useDelimiter("\\r?\\n?[*]");
    	
    	if (categoryScan.hasNextLine()) {
    		String categories = categoryScan.next();
        	Scanner categoryScan2 = new Scanner(categories);
        	while (categoryScan2.hasNextLine()) {
        		String line = categoryScan2.nextLine();
        		if (line.charAt(0) != '#') {
        			categoryScan2.close();
        			categoryScan.close();
        			throw new IllegalArgumentException("Unable to load file.");
        		}
        		
        		String categoryName = line.substring(1).strip();
        		
        		try {
        			p.addCategoryLog(categoryName);
        		}
        		catch (IllegalArgumentException e) {
        			// Removes invalid categories
        		}
        		    		
        		
        	}
    		while (categoryScan.hasNext()) {
    			String taskData = categoryScan.next().trim();
    			processTask(p, taskData);
    			
    		}
    		categoryScan2.close();

    	}
    	categoryScan.close();
		return p;
    	
    	
    	
    }

    /**
     * Processes a single task string from the file and adds it to the project.
     *
     * @param project the project to contain the task
     * @param task the task data in string form
     */
    private static void processTask(Project project, String task) {
       Scanner taskScan = new Scanner(task);
       String taskData = taskScan.nextLine();
       Scanner taskInfoParser = new Scanner(taskData);
       taskInfoParser.useDelimiter(",");
       String taskTitle = "";
       int duration = 0;
       String categoryName = "";
       String taskDetails = "";
       try {
    	   taskTitle = taskInfoParser.next();
    	   duration = Integer.parseInt(taskInfoParser.next());
    	   categoryName = taskInfoParser.next();
       }
       catch (NumberFormatException e) {
    	   taskScan.close();
    	   taskInfoParser.close();
       }
       
       while (taskScan.hasNext()) {
    	   taskDetails += taskScan.nextLine();
       }
       
       try {
    	   Task t = new Task(taskTitle, duration, taskDetails);
    	   t.addCategory(new CategoryLog(categoryName));
    	   project.setCurrentTaskLog(t.getCategoryName());
    	   project.addTask(t);
    	   project.setCurrentTaskLog("All Tasks");
       }
       catch (IllegalArgumentException e) {
    	   // Removes invalid tasks
       }
       taskInfoParser.close();
       taskScan.close();
    }
}

