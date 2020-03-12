package p1;

import java.util.ArrayList;

public class Scoreboard {

    public void main(String[] args) {

    }

    public ArrayList<int[]> input; // TODO set to info read from input.txt
    public int numCases = 0; // TODO set to first num from input
    public ArrayList<Case> cases = new ArrayList<Case>();

    public void setCases() {
        for (int i = 1; i < input.size(); i++){
            if (input.get(i).length == 2) {
                int numTeams = input.get(i)[0];
                int numLogs = input.get(i)[1];
                ArrayList<Log> logs = new ArrayList<Log>();
                ArrayList<Team> teams = new ArrayList<Team>();
                for (int j = 1; j < numTeams + 1; j++) { // filling teams with instances of Team
                    teams.add(new Team(j));
                }
                for (int j = i + 1; j < i + 1 + numLogs; j++) { // filling logs with instances of Log
                    if (input.get(j).length == 2) {
                        i = j - 1;
                        return; // if  we arrive at the end of all of the log statements and on to the next case, this stops it
                    }
                    logs.add(new Log(input.get(j)[0], input.get(j)[1], input.get(j)[2], input.get(j)[3], input.get(j)[4]));
                }
            }
        }
    }
}