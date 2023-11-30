package application;

import java.util.ArrayList;

// Author: Ryan Swart

public class PlanningPokerData {

	private final static PlanningPokerData instance = new PlanningPokerData();
	
	public static PlanningPokerData getInstance() {
        return instance;
    }
	
	public ArrayList<String> userStories = new ArrayList<>();
	public ArrayList<String[]> keyWords = new ArrayList<>();
	public ArrayList<Integer> effortPoints = new ArrayList<>();
	
	public String currentProject;
	public String currentStory;
	public String[] currentKeys;
	public int currentPoints;
	
	public ArrayList<Integer> selectedList = new ArrayList<>();
	
	public ArrayList<String> notes = new ArrayList<>();
}
