package emartinez.conference.model;

import java.util.ArrayList;
import java.util.List;

public class Track {

    public int dayNo;
    public List<Session> sessions;

    public Track(int dayNo) {
        this.dayNo = dayNo;
        this.sessions = new ArrayList<>();
    }

    public int getDayNo() {
        return dayNo;
    }

    public void setDayNo(int dayNo) {
        this.dayNo = dayNo;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

}
