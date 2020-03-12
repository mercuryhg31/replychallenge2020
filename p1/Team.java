package p1;

public class Team {
    private int teamId;
    private int penaltyTime;
    private int score = 0;

    public Team(int teamId) {
        this.teamId = teamId;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getPenaltyTime() {
        return penaltyTime;
    }

    public void setPenaltyTime(int penaltyTime) {
        this.penaltyTime = penaltyTime;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int score) {
        this.score += score;
    }

}