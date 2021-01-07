package com.emartinez.conference.model;

import com.emartinez.conference.config.ConferenceConfig;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TalkEvent extends Talk {

    private Calendar startHour;

    public TalkEvent(String title, Calendar startHour, int duration) {
        this.title = title;
        this.startHour = startHour;
        this.duration = duration;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mma");
        if (getDuration() == 5)
            return sdf.format(getStartHour().getTime()) + " " + getTitle() + " " + ConferenceConfig.LIGHTNING_TIME + "min";
        else
            return sdf.format(getStartHour().getTime()) + " " + getTitle() + " " + getDuration() + "min";
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
