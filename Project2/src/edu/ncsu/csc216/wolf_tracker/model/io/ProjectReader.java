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
        // Read entire file into a single String
        String content = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                content += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to load file.");
        }
        
        // Validate the first line
        content = content.trim();
        if (!content.startsWith("!")) {
            throw new IllegalArgumentException("Unable to load file.");
        }
        
        // Split content by tasks (tokens separated by `*`)
        String[] tokens = content.split("\\r?\\n?[*]");
        
        // Process project name and categories
        String projectInfo = tokens[0].trim();
        String[] lines = projectInfo.split("\\r?\\n");
        
        // Remove `!` from project name
        String projectName = lines[0].substring(1).trim();
        Project project = new Project(projectName);
        
        // Add categories to the project
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.startsWith("#")) {
                String categoryName = line.substring(1).trim();
                project.addCategoryLog(categoryName));
            }
        }
        
        // Process each task
        for (int i = 1; i < tokens.length; i++) {
            String taskData = tokens[i].trim();
            processTask(project, taskData);
        }
        
        return project;
    }

    /**
     * Processes a single task string from the file and adds it to the project.
     *
     * @param project the project to contain the task
     * @param task the task data in string form
     */
    private static void processTask(Project project, String task) {
        String[] taskLines = task.split("\\r?\\n");
        if (taskLines.length == 0) {
            return;  // Ignore empty tasks
        }
        
        // Parse the task's first line (title, duration, category)
        String[] taskInfo = taskLines[0].split(",");
        if (taskInfo.length < 3) {
            return;
        }
        
        String title = taskInfo[0].trim();
        String durationStr = taskInfo[1].trim();
        String categoryName = taskInfo[2].trim();
        
        int duration;
        try {
            duration = Integer.parseInt(durationStr);
        } catch (NumberFormatException e) {
            return;
        }
        
        // Join the remaining lines as the task description
        String description = "";
        for (int i = 1; i < taskLines.length; i++) {
            description += taskLines[i].trim() + "\n";
        }
        
        // Create Task and add it to the Project
        try {
            Task newTask = new Task(title, duration, description.trim());
            CategoryLog categoryLog = project.getCategoryLog(categoryName);
            if (categoryLog != null) {
                categoryLog.addTask(newTask);
                project.getAllTasksLog().addTask(newTask);
            }
        } catch (IllegalArgumentException e) {
           
        }
    }
}

