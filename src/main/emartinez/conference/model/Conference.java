package main.emartinez.conference.model;

import java.util.ArrayList;
import java.util.List;

public class Conference {

    public List<Track> tracks;

    public Conference() {
        this.tracks = new ArrayList<>();
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
