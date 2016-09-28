package hr.etfos.d1babic.guildwars2timersremake.data.database;

import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;

/**
 * Created by DominikZoran on 27.09.2016..
 */
public class DatabasePresenterImpl implements DatabasePresenter {

    private EventsDatabase database;
    private String eventTitle;

    public DatabasePresenterImpl(EventsDatabase database) {
        this.database = database;
    }

    @Override
    public List<WorldEventModel> getEventsFromDatabase() {
        return database.getEvents();
    }

    @Override
    public List<WorldEventModel> getSubsFromDatabase() {
        return database.getSubscribedEvents();
    }

    @Override
    public void subscribe() {
        database.subscribeToEvent(eventTitle);
    }

    @Override
    public void unsubscribe() {
        database.unsubscribeEvent(eventTitle);
    }

    @Override
    public void setTitle(String title) {
        this.eventTitle = title;
    }

}
