package com.emartinez.conference.management;

import com.emartinez.conference.config.ConferenceConfig;
import com.emartinez.conference.exception.ConferenceOriginException;
import com.emartinez.conference.model.*;
import com.emartinez.conference.util.ConferenceUtil;
import com.emartinez.conference.util.TalksComparator;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Edwin Martinez 2021-01-06
 */
public class ConferenceManagement {

    Conference conference;

    public ConferenceManagement() {
        conference = new Conference();
    }

    /**
     * Main method for read Talks from input file and schedule them into conference/tracks/sessions
     */
    public void manageConference() {

        List<Talk> talks;

        ConferenceUtil util = new ConferenceUtil();
        try {
            talks = util.readInput();
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + ConferenceConfig.TALKS_FILE);
            return;
        } catch (ConferenceOriginException oe) {
            System.err.println(oe.getMessage());
            return;
        }

        // organize all talks readed from input file.
        scheduleTalks(talks);

        // show final Conference Schedule
        printTalks(conference);

    }

    /**
     * Method to organize the talks list into sessions and tracks
     */
    public void scheduleTalks(List<Talk> talks) {

        int dayCount = 0;

        // Sort talks descending
        talks.sort(new TalksComparator());

        // Execute the schedule for all tasks
        while (talks.size() != 0) {

            // create sessions for each section of the track (day)
            Session morningSession = new Session(ConferenceConfig.SESSION_MORNING_START,
                    ConferenceConfig.MORNING_SESSION_TIME);
            assignTalksToSession(morningSession, talks);

            Session lunch = new Session(ConferenceConfig.SESSION_LUNCH_START, ConferenceConfig.LUNCH_TIME);
            lunch.addTalkOrEvent(new LunchEvent());

            Session afternoonSession = new Session(ConferenceConfig.SESSION_AFTERNOON_START,
                    ConferenceConfig.AFTERNOON_SESSION_TIME);
            assignTalksToSession(afternoonSession, talks);

            Session networking = new Session(ConferenceConfig.SESSION_NETWORKING_START,
                    ConferenceConfig.NETWORKING_SESSION_TIME);
            networking.addTalkOrEvent(new NetworkingEvent());


            Track track = new Track(++dayCount);
            List<Session> sessions = new ArrayList<>();
            sessions.add(morningSession);
            sessions.add(lunch);
            sessions.add(afternoonSession);
            sessions.add(networking);
            track.setSessions(sessions);

            conference.addTrack(track);
        }

    }

    /**
     * Method to assign a group of Talks for each Session, after adding a talk remove it from the talks list.
     * @param session Section of the track (day)
     * @param talks List of pending talks to schedule
     */
    public void assignTalksToSession(Session session, List<Talk> talks) {
        Calendar currentStartTime = session.getStartTime();
        for (Iterator<Talk> talksIterator = talks.iterator(); talksIterator.hasNext();) {
            Talk talk = talksIterator.next();
            if (session.fitsInSessionTime(talk)) {
                // add an talk event to the session at the currentStartTime calculated.
                session.addTalkOrEvent(new TalkEvent(talk.getTitle(), currentStartTime, talk.getDuration()));
                // calculate the next start time based on the current start time and current talk duration.
                currentStartTime = ConferenceUtil.nextTalkTime(currentStartTime, talk);
                // remove the talk from the list. This means that the talk has been scheduled in the conference.
                talksIterator.remove();
            }
        }
    }

    /**
     * Method to output the Conference Schedule.
     * @param conference Conference information
     */
    public void printTalks(Conference conference) {
        for (Track track : conference.getTracks()) {
            System.out.println("Track " + track.getDayNo() + ":");
            for(Session session : track.getSessions()) {
                for (TalkEvent talkEvent : session.getEvents()) {
                    System.out.println(talkEvent.toString());
                }
            }
        }
    }

}
