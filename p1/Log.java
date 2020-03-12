package p1;

public class Log {
    
    private int timestamp;
    private int teamId;
    private int problemId;
    private boolean scored;

    public Log(int timestamp, int teamId, int problemId, boolean scored) {
        this.timestamp = timestamp;
        this.teamId = teamId;
        this.problemId = problemId;
        this.scored = scored;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getTeamId() {
        return teamId;
    }
    
    public int getProblemId() {
        return problemId;
    }

    public boolean isScored() {
        return scored;
    }
}