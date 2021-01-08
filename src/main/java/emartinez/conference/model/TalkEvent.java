package emartinez.conference.model;

import emartinez.conference.config.ConferenceConfig;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TalkEvent extends Talk {

    private Calendar startHour;

    public TalkEvent(String title, Calendar startHour, int duration) {
        this.title = title;
        this.startHour = startHour;
        this.duration = duration;
    }

    public TalkEvent(String title, Calendar startHour) {
        this.title = title;
        this.startHour = startHour;
        this.duration = 0;
    }

    @Override
    public String toString() {
        // different formats 12H hh - 24H HH - AM/PM text ´a´ at the end
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");

        if (getDuration() == 5)
            return sdf.format(getStartHour().getTime()) + " " + getTitle() + " " + ConferenceConfig.LIGHTNING_TIME + "min";
        else
            return sdf.format(getStartHour().getTime()) + " " + getTitle() + " " + (getDuration() == 0 ? "" : getDuration() + "min");
    }

    public String getTitle() {
        return title;
    }

    public Calendar getStartHour() {
        return startHour;
    }

    public int getDuration() {
        return duration;
    }
}
