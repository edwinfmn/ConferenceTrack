package com.emartinez.conference.model;

import com.emartinez.conference.config.ConferenceConfig;

public class NetworkingEvent extends TalkEvent {
    public NetworkingEvent() {
        super("Networking", ConferenceConfig.SESSION_NETWORKING_START, ConferenceConfig.NETWORKING_SESSION_TIME);
    }
}
