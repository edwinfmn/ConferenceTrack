package com.emartinez.conference.model;

import com.emartinez.conference.config.ConferenceConfig;

public class NetworkingEvent extends TalkEvent {
    public NetworkingEvent() {
        super("Networking Event", ConferenceConfig.SESSION_NETWORKING_START);
    }
}
