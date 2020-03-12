package p1;

import java.util.ArrayList;

public class Case {
    private int numTeams;
    private int numLogs;
    private ArrayList<Log> logs;
    private ArrayList<Team> teams;

    public Case(int numOfTeams, int numOfLogs, ArrayList<Log> logs, ArrayList<Team> teams) {
        this.numTeams = numOfTeams;
        this.numLogs = numOfLogs;
        this.logs = logs;
        this.teams = teams;
    }
    
    public int getNumTeams() {
        return numTeams;
    }

    public int getNumLogs() {
        return numLogs;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

}