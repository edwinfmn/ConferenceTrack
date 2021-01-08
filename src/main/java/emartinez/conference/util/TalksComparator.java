package emartinez.conference.util;

import emartinez.conference.model.Talk;

import java.util.Comparator;

/**
 * @author Edwin Martinez
 * 2021-01-06
 */
public class TalksComparator implements Comparator<Talk> {

    @Override
    public int compare(Talk talkA, Talk talkB) {
        if (talkA.getDuration() < talkB.getDuration()) {
            return 1;
        } else {
            return -1;
        }
    }
}
