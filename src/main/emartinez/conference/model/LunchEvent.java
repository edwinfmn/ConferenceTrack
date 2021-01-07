package main.emartinez.conference.model;

import main.emartinez.conference.config.ConferenceConfig;

public class LunchEvent extends TalkEvent {
    public LunchEvent() {
        super("Lunch", ConferenceConfig.SESSION_LUNCH_START);
    }
}
