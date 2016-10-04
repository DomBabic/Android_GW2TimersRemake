package hr.etfos.d1babic.guildwars2timersremake.model;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by DominikZoran on 24.09.2016..
 */
public class WorldEventModel {

    private int id;
    private String title;
    private int icon;
    private String location;
    private String description;
    private String occurrence;
    private String occurrenceShift;
    private int subscription;
    private long timeRemainingInMilliseconds;

    public WorldEventModel(int id, String title, int icon, String location, String description, String occurrence, String
            occurrenceShift, int subscription) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.location = location;
        this.description = description;
        this.occurrence = occurrence;
        this.occurrenceShift = occurrenceShift;
        this.subscription = subscription;
    }

    public WorldEventModel(String title, int icon, String location, String description, String occurrence, String
            occurrenceShift, int subscription) {
        this.title = title;
        this.icon = icon;
        this.location = location;
        this.description = description;
        this.occurrence = occurrence;
        this.occurrenceShift = occurrenceShift;
        this.subscription = subscription;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public String getOccurrenceShift() {
        return occurrenceShift;
    }

    public int getSubscription() {
        return subscription;
    }

    public void setTimeRemainingInMilliseconds(long milliseconds) {
        this.timeRemainingInMilliseconds = milliseconds;
    }

    public long getTimeRemainingInMilliseconds() {
        return timeRemainingInMilliseconds;
    }

    public String calculateAndDisplay() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        if(!title.equals("Karka Queen") && !title.equals("Triple Trouble") && !title.equals("Tequatl the Sunless")) {


            long countdownTime;
            String[] repeat = occurrenceShift.split(":");
            String[] start = occurrence.split(":");
            long repeatInMillis = Integer.parseInt(repeat[0]) * 3600000;
            long startInMillis = (Integer.parseInt(start[0]) * 3600000) + (Integer.parseInt(start[1]) * 60000);
            calendar.getTimeInMillis();

            countdownTime = repeatInMillis - (((-startInMillis) + calendar.getTimeInMillis()) % repeatInMillis);
            setTimeRemainingInMilliseconds(countdownTime);

        }

        return formatTime();
    }

    public String formatTime() {
        return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(timeRemainingInMilliseconds),
                TimeUnit.MILLISECONDS.toMinutes(timeRemainingInMilliseconds) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(timeRemainingInMilliseconds) % TimeUnit.MINUTES.toSeconds(1));
    }



}
