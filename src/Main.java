import com.emartinez.conference.exception.ConferenceOriginException;
import com.emartinez.conference.management.ConferenceManagement;
import com.emartinez.conference.model.Talk;
import com.emartinez.conference.util.ConferenceUtil;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Talk> talkList;

        ConferenceUtil util = new ConferenceUtil();

        try {
            talkList = util.readInput();
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
