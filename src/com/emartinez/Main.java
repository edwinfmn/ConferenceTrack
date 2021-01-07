package com.emartinez;

import com.emartinez.conference.management.ConferenceManagement;
import com.emartinez.conference.model.Talk;
import com.emartinez.conference.util.ConferenceUtil;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Talk> talkList = null;

        ConferenceUtil util = new ConferenceUtil();

        try {
            talkList = util.readInput();
        } catch (FileNotFoundException e) {
            return;
        }

        if(talkList.isEmpty() || talkList.size() == 0) {
            System.err.println("Input File doesn't have any talk. Please check the input information.");
            return;
        } else {
            ConferenceManagement cm = new ConferenceManagement();
            try {
                cm.manageConference();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }




    }
}
