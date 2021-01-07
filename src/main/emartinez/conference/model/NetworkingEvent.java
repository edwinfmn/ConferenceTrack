package main.emartinez.conference.model;

import java.util.Calendar;

public class NetworkingEvent extends TalkEvent {
    public NetworkingEvent(Calendar startTime) {
        super("Networking Event", startTime);
    }
}
