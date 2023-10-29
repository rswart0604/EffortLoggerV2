package application;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EffortLoggingData {
	
    private final static EffortLoggingData instance = new EffortLoggingData();

    public static EffortLoggingData getInstance() {
        return instance;
    }
    
	ArrayList<LocalDateTime> startTimes = new ArrayList<>();
	ArrayList<LocalDateTime> endTimes = new ArrayList<>();
	ArrayList<String> projects = new ArrayList<>();
	ArrayList<String> lifeCycles = new ArrayList<>();
	ArrayList<String> effortCategories = new ArrayList<>();
	ArrayList<String> items = new ArrayList<>();
	
	
	public ArrayList<LocalDateTime> getStartTimes() {
		return startTimes;
	}
	
	public ArrayList<LocalDateTime> getEndTimes() {
		return endTimes;
	}
	
	public ArrayList<String> getProjects() {
		return projects;
	}
	
	public ArrayList<String> getLifeCycles() {
		return lifeCycles;
	}
	
	public ArrayList<String> getEffortCategories() {
		return effortCategories;
	}
	
	public ArrayList<String> getItems() {
		return items;
	}
	
	
	
	
}
