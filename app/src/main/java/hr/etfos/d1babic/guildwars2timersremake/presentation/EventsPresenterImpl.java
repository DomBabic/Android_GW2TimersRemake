package hr.etfos.d1babic.guildwars2timersremake.presentation;

import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabaseInterface;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;
import hr.etfos.d1babic.guildwars2timersremake.view.EventsView;

/**
 * Created by DominikZoran on 29.09.2016..
 */
public class EventsPresenterImpl implements EventsPresenter {

    private EventsView view;
    private DatabaseInterface database;

    public EventsPresenterImpl(DatabaseInterface database) {
        this.database = database;
    }

    @Override
    public void getAllEvents() {
        List<WorldEventModel> events = database.getEventsFromDatabase();

        if(events != null) {
            view.setAdapterItems(events);
        }
    }

    @Override
    public void setView(EventsView view) {
        this.view = view;
    }

}
