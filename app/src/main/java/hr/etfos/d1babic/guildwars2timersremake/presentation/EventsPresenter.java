package hr.etfos.d1babic.guildwars2timersremake.presentation;

import hr.etfos.d1babic.guildwars2timersremake.view.EventsView;

/**
 * Created by DominikZoran on 29.09.2016..
 */
public interface EventsPresenter {

    void getAllEvents();

    void setView(EventsView view);
}
