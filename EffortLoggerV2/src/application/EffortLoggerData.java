package application;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EffortLoggerData {
	
    private final static EffortLoggerData instance = new EffortLoggerData();

    public static EffortLoggerData getInstance() {
        return instance;
    }
    
	ArrayList<LocalDateTime> startTimes = new ArrayList<>();
	ArrayList<LocalDateTime> endTimes = new ArrayList<>();
	ArrayList<String> projects = new ArrayList<>();
	ArrayList<String> lifeCycles = new ArrayList<>();
	ArrayList<String> effortCategories = new ArrayList<>();
	ArrayList<String> items = new ArrayList<>();
	
	String username = "";
	
	boolean singlePrototype = true;
	
	
	// TODO: we will add user story information to this later! once we have real deal planning poker set up with weights and all
	// 			this is just a prototype version of what a database interface might look like
	
	
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
	
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String newUsername) {
		username = newUsername;
	}
	
	
	
	public boolean isSinglePrototype() {
		return singlePrototype;
	}
	
	public void setSinglePrototype(boolean isSingle) {
		singlePrototype = isSingle;
	}
	
	
	
	
}
