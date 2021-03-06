package hr.etfos.d1babic.guildwars2timersremake.data.database;

import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;

/**
 * Created by DominikZoran on 27.09.2016..
 */
public interface DatabaseInterface {

    List<WorldEventModel> getEventsFromDatabase();

    List<WorldEventModel> getSubsFromDatabase();

    void subscribe();

    void unsubscribe();

    void setTitle(String title);
}
