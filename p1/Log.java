package p1;

public class Log {
    
    private int timestamp;
    private int teamId;
    private int problemId;
    private int inputId;
    private boolean scored;

    public Log(int timestamp, int teamId, int problemId, int inputId, int scored) {
        this.timestamp = timestamp;
        this.teamId = teamId;
        this.problemId = problemId;
        this.inputId = inputId;
        if (scored == 0) this.scored = false;
        else this.scored = true;
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

    public int getInputId() {
        return inputId;
    }

    public boolean isScored() {
        return scored;
    }
}