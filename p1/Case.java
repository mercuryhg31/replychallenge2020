package p1;

import java.util.ArrayList;

public class Case {
    private int numOfTeams;
    private int numOfLogs;
    private ArrayList<Log> logs;
    private ArrayList<Team> teams;

    public Case(int numOfTeams, int numOfLogs, ArrayList<Log> logs) {
        this.numOfTeams = numOfTeams;
        this.numOfLogs = numOfLogs;
        this.logs = logs;
    }
    
    public int getNumOfTeams() {
        return numOfTeams;
    }

    public int getNumOfLogs() {
        return numOfLogs;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

}