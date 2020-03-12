package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Scoreboard {
    
    public ArrayList<int[]> input = getLines();
    public int numCases = input.get(0)[0];
    public ArrayList<Case> cases = new ArrayList<Case>();

    public static void main(String[] args) {
        Scoreboard scoreBoard = new Scoreboard();
        scoreBoard.setCases();
        scoreBoard.setTeamInfo();
        for (int i = 0; i < scoreBoard.cases.size(); i++) {
            for (int j = 0; j < scoreBoard.cases.get(i).getTeams().size(); j++) {
                System.out.printf("ID: %d, PEN: %d, FUCK: %d\n", scoreBoard.cases.get(i).getTeams().get(j).getTeamId(), scoreBoard.cases.get(i).getTeams().get(j).getPenaltyTime(), scoreBoard.cases.get(i).getTeams().get(j).getScore());
            }
        }

    }

    private static ArrayList<int[]> getLines() {
        ArrayList<int[]> fileByLine  = new ArrayList<int[]>();
        String line;
        StringBuffer oneLineWonder = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")))) {
           while ((line = br.readLine()) != null) {
              oneLineWonder.append(line);
              oneLineWonder.append(";");
           }
           for(String caseOrLog : oneLineWonder.toString().split(";")) {
              String[] sArray = caseOrLog.split(" ");
              int[] intArray = new int[sArray.length];
              for (int i = 0; i < sArray.length; i++) {
                 intArray[i] = Integer.parseInt(sArray[i]);
              }
              fileByLine.add(intArray);
           }
        } catch (IOException e) {
           e.printStackTrace();
        }
        return fileByLine;
    }

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
                cases.add(new Case(numTeams, numLogs, logs, teams));
            }
        }
    }

    public void setTeamInfo() {
        for (int i = 0; i < cases.size(); i++) {
            ArrayList<Log> caseLogs = cases.get(i).getLogs();
            ArrayList<Team> caseTeams = cases.get(i).getTeams();
            for (int j = 0; j < caseLogs.size(); j++) {
                if (caseLogs.get(i).isScored()) {
                    int teamId = caseLogs.get(i).getTeamId();

                    int addScore = caseLogs.get(i).getInputId() * 100;
                    caseTeams.get(teamId - 1).addToScore(addScore);
                    if (caseLogs.get(i).getTimestamp() > caseTeams.get(teamId - 1).getPenaltyTime()) {
                        caseTeams.get(teamId - 1).setPenaltyTime(caseLogs.get(i).getTimestamp());
                    }

                    
                }
            }
            cases.get(i).setTeams(caseTeams);
        }
    }
}