package com.emartinez.conference.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Session {

    public List<TalkEvent> events;
    public Calendar startTime;
    public int remainingTime;

    public Session(Calendar startTime, int remainingTime) {
        this.events = new ArrayList<>();
        this.startTime = startTime;
        this.remainingTime = remainingTime;
    }

    public Boolean fitsInSessionTime(Talk talk) {
        return remainingTime >= talk.duration;
    }

    public void addTalkOrEvent(TalkEvent talkEvent) {
        this.events.add(talkEvent);
        this.remainingTime -= talkEvent.getDuration();
    }

    public List<TalkEvent> getEvents() {
        return events;
    }

    public void setEvents(List<TalkEvent> events) {
        this.events = events;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

}
