import main.emartinez.conference.config.ConferenceConfig;
import main.emartinez.conference.exception.ConferenceOriginException;
import main.emartinez.conference.management.ConferenceManagement;
import main.emartinez.conference.model.Talk;
import main.emartinez.conference.util.ConferenceUtil;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Main class to execute rad Talks file and print them into a Conference Schedule
 *
 * @author Edwin Martinez
 */
public class Main {

    public static void main(String[] args) {

        List<Talk> talkList;

        ConferenceUtil util = new ConferenceUtil();

        try {
            talkList = util.readInput(ConferenceConfig.TALKS_FILE);
        } catch (FileNotFoundException | ConferenceOriginException e) {
            System.err.println(e.getMessage());
            return;
        }

        if(talkList.isEmpty()) {
            System.err.println("Input File doesn't have any talk. Please check the input information.");
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
