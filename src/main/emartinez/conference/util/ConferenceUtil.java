package main.emartinez.conference.util;

import main.emartinez.conference.config.ConferenceConfig;
import main.emartinez.conference.exception.ConferenceOriginException;
import main.emartinez.conference.model.Talk;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Class for cross-app methods
 * @author Edwin Martinez
 */
public class ConferenceUtil {

    public static Calendar setCalTime(int hour, int min) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, min);
        return c;
    }

    /**
     * Method to get the next Talk Event Start Time
     * @param currentStartTime Hour and Minute when current Talk Event start
     * @param talk Talk to get the duration in minutes
     * @return Hour and Minute when starting next Talk Event
     */
    public static Calendar nextTalkTime(Calendar currentStartTime, Talk talk) {
        Calendar newTime = Calendar.getInstance();
        newTime.set(Calendar.HOUR_OF_DAY, currentStartTime.get(Calendar.HOUR_OF_DAY));
        newTime.set(Calendar.MINUTE, currentStartTime.get(Calendar.MINUTE));
        newTime.add(Calendar.MINUTE, talk.getDuration());
        return newTime;
    }

    public List<Talk> readInput(String fileName) throws FileNotFoundException, ConferenceOriginException {
        FileInputStream inputStream;
        List<Talk> talks = new ArrayList<>();

        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + fileName);
            throw e;
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String txtLine;
        int durationMin;

        try {
            // Leemos línea por línea del archivo
            while ((txtLine = bufferedReader.readLine()) != null) {
                // evitar líneas vacías o con comentarios
                if (txtLine.startsWith("#") || txtLine.startsWith("//") || txtLine.isEmpty())
                    continue;

                String name = txtLine.substring(0, txtLine.lastIndexOf(" "));
                String minutes = txtLine.substring(txtLine.lastIndexOf(" ") + 1);
                String time = minutes.replaceAll("\\D+", "");
                // poner el tiempo para conferencias lightning
                if (minutes.equals(ConferenceConfig.LIGHTNING))
                    durationMin = ConferenceConfig.LIGHTNING_TIME;
                else {
                    try {
                        durationMin = Integer.parseInt(time);
                    } catch (NumberFormatException ne) {
                        System.err.println("Error parsing the line : " + txtLine);
                        throw ne;
                    }
                }
                Talk talk = new Talk(name, durationMin);
                talks.add(talk);
            }
        } catch (Exception e) {
            throw new ConferenceOriginException("Conference Origin file is not readable");
        } finally {
            try {
                inputStream.close();
                bufferedReader.close();
            } catch (IOException ie) {
                System.err.println("Error closing input readers " + ie.getMessage());
            }
        }

        return talks;
    }
}
