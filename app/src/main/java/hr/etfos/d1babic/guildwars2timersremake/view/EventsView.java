package hr.etfos.d1babic.guildwars2timersremake.view;

import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;

/**
 * Created by DominikZoran on 29.09.2016..
 */
public interface EventsView {

    void setAdapterItems(List<WorldEventModel> eventsList);
}
