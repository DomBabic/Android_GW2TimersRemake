package hr.etfos.d1babic.guildwars2timersremake.presentation;

import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabaseInterface;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;
import hr.etfos.d1babic.guildwars2timersremake.view.SubscriptionsView;

/**
 * Created by DominikZoran on 29.09.2016..
 */
public class SubscriptionsPresenterImpl implements SubscriptionsPresenter {

    private DatabaseInterface database;
    private SubscriptionsView subsView;

    public SubscriptionsPresenterImpl(DatabaseInterface database) {
        this.database = database;
    }

    public void setView(SubscriptionsView subsView) {
        this.subsView = subsView;
    }

    @Override
    public void getSubscribedEvents() {
        List<WorldEventModel> subscribedEvents = database.getSubsFromDatabase();

        if(subscribedEvents != null) {
            subsView.setAdapterItems(subscribedEvents);
        }
    }
}
