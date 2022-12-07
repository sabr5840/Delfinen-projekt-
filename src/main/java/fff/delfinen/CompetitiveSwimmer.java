package fff.delfinen;

public class CompetitiveSwimmer extends Member {
    private double timeResult;
    private int placement;
    private String discipline;
    private String event;
    private String date;

    public void CompetitiveResult(double timeResult, int placement, String discipline, String event, String date, int membershipNumber) {
        this.timeResult = timeResult;
        this.discipline = discipline;
        this.placement = placement;
        this.event = event;
        this.date = date;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    public double getResult() {
        return timeResult;
    }

    public void setTimeResult(double timeResult) {
        this.timeResult = timeResult;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTournamentName() {
        return event;
    }

    public void setTournamentName(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "CompetitiveSwimmer{" +
                "timeResult=" + timeResult +
                ", placement=" + placement +
                ", discipline='" + discipline + '\'' +
                ", event='" + event + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
