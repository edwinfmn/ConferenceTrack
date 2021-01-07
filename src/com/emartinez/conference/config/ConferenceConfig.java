package com.emartinez.conference.config;

import com.emartinez.conference.util.ConferenceUtil;

import java.util.Calendar;

/**
 * Class to define all config parameters
 *
 * @author Edwin Martínez
 */
public class ConferenceConfig {
    // Input Talks File
    public static final String TALKS_FILE = "talks.txt";
    public static final String LIGHTNING = "lightning";

    // Standard/Fixed times
    public static final int LUNCH_TIME = 60;
    public static final int MORNING_SESSION_TIME = 180;
    public static final int AFTERNOON_SESSION_TIME = 240;
    public static final int LIGHTNING_TIME = 5;
    public static final int NETWORKING_SESSION_TIME = 60;

    // Fixed Start Hours for Sessions
    public static final Calendar SESSION_MORNING_START = ConferenceUtil.setCalTime(9,0);
    public static final Calendar SESSION_LUNCH_START = ConferenceUtil.setCalTime(12,0);
    public static final Calendar SESSION_AFTERNOON_START = ConferenceUtil.setCalTime(13,0);
    public static final Calendar SESSION_NETWORKING_START = ConferenceUtil.setCalTime(17,0);

}
