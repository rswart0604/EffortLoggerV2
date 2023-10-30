package application;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EffortLoggerData {
	
	// Singleton instance of EffortLoggerData
    private final static EffortLoggerData instance = new EffortLoggerData();
    
    //Returns the singleton instance of EffortLoggerData
    public static EffortLoggerData getInstance() {
        return instance;
    }
    
    //ArrayLists to hold various data related to effort logger
	ArrayList<LocalDateTime> startTimes = new ArrayList<>();
	ArrayList<LocalDateTime> endTimes = new ArrayList<>();
	ArrayList<String> projects = new ArrayList<>();
	ArrayList<String> lifeCycles = new ArrayList<>();
	ArrayList<String> effortCategories = new ArrayList<>();
	ArrayList<String> items = new ArrayList<>();
	
	String username = "";
	
	//Flag to determine whether it's a single prototype or not
	boolean singlePrototype = true;
	
	
	// TODO: we will add user story information to this later! once we have real deal planning poker set up with weights and all
	// 			this is just a prototype version of what a database interface might look like
	
	// Getter methods to access the private variables
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
	
	
	// Getter and Setter for username
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String newUsername) {
		username = newUsername;
	}
	
	
	// Getter and Setter for the singlePrototype flag
	public boolean isSinglePrototype() {
		return singlePrototype;
	}
	
	public void setSinglePrototype(boolean isSingle) {
		singlePrototype = isSingle;
	}
	
	
	
	
}
