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

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public int goThroughLog(Log log) { // TODO tbd
        Team team = getTeam(log.getTeamId());
        if (team == null) return 1;
        if (log.isScored()) {
            team.addToScore(log.getInputId() * 100);
            team.setPenaltyTime(log.getTimestamp());
        }

        return 0;
    }

    /**
     * Get team by team id from ArrayList of Teams
     * 
     * @param id
     * @return corresponding team
     */
    public Team getTeam(int id) {
        for (Team team : teams) {
            if (team.getTeamId() == id) return team;
        } return null;
    }

}