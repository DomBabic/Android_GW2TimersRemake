package hr.etfos.d1babic.guildwars2timersremake.model;

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

}
