package hr.etfos.d1babic.guildwars2timersremake.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.common.Constants;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;

/**
 * Created by DominikZoran on 24.09.2016..
 */
public class EventsDatabase extends SQLiteOpenHelper {

    private static EventsDatabase singleInstance;

    private static final int DATABASE_VERSION = 1;

    public EventsDatabase(Context context) {
        super(context, Constants.DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized EventsDatabase getInstance(Context context) {
        if(singleInstance == null) {
            singleInstance = new EventsDatabase(context.getApplicationContext());
        }
        return singleInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Constants.CREATE_EVENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Constants.DROP_EVENTS_TABLE);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<WorldEventModel> getEvents() {
        ArrayList<WorldEventModel> eventsList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, null, null, null, null, null);

        if(cursor.moveToFirst()) {
            do {
                WorldEventModel event = new WorldEventModel(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor
                        .getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor
                        .getInt(7));
                eventsList.add(event);
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return eventsList;
    }

    public List<WorldEventModel> getSubscribedEvents() {
        ArrayList<WorldEventModel> subscribedEventsList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, null, null, null, null, null);

        if(cursor.moveToFirst()) {
            do {
                if(cursor.getInt(7) == 1) {
                    WorldEventModel subscribedEvent = new WorldEventModel(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
                            cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                            cursor.getInt(7));
                    subscribedEventsList.add(subscribedEvent);
                }
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return subscribedEventsList;
    }

    public void subscribeToEvent(String title) {
        this.getWritableDatabase().execSQL("UPDATE " + Constants.TABLE_NAME + " SET " + Constants.KEY_EVENT_SUBSCRIPTION +
                "=1" + " WHERE " + Constants.KEY_EVENT_TITLE + "='" + title + "'");
    }

    public void unsubscribeEvent(String title) {
        this.getWritableDatabase().execSQL("UPDATE " + Constants.TABLE_NAME + " SET " + Constants.KEY_EVENT_SUBSCRIPTION +
                "=0" + " WHERE " + Constants.KEY_EVENT_TITLE + "='" + title + "'");
    }

    public void populateTable() {
        //Taidha
        WorldEventModel populate = new WorldEventModel("Admiral Taidha Covington", R.drawable.taidha, "Bloodtide Coast", "Kill Admiral Taidha Covington is a level 50 group event that occurs on Laughing Gull Island. It is the final event of the area's The Campaign Against Taidha Covington meta event.", "00:00", "03:00", 0);
        addEvent(populate);
        //Svanir
        populate = new WorldEventModel("Svanir Shaman Chief", R.drawable.svanir, "Wayfarer Foothills", "Kill the Svanir shaman chief to break his control over the ice elemental is a level 10 event in Wayfarer Foothills. Upon completion, a large chest spawns.", "00:15", "02:00", 0);
        addEvent(populate);
        //Megadestroyer
        populate = new WorldEventModel("Megadestroyer", R.drawable.megadestroyer, "Mount Maelstrom", "Kill the megadestroyer before it blows everyone up is a level 66 group event in Mount Maelstrom. It is the final event of the meta event The Battle for Mount Maelstrom.", "00:30", "03:00", 0);
        addEvent(populate);
        //Fire Elemental
        populate = new WorldEventModel("Fire Elemental", R.drawable.elemental, "Metrica Province", "Destroy the fire elemental created from chaotic energy fusing with the C.L.E.A.N. 5000's energy core is a level 15 group event that occurs in Thaumanova Reactor.", "00:45", "02:00", 0);
        addEvent(populate);
        //The Shatterer
        populate = new WorldEventModel("The Shatterer", R.drawable.shatterer, "Blazeridge Steppes", "Slay the Shatterer is a group event that occurs in the Lowland Burns. It occurs as the final part of the meta event Kralkatorrik's Legacy.", "01:00", "03:00", 0);
        addEvent(populate);
        //Great Jungle Wurm
        populate = new WorldEventModel("Great Jungle Wurm", R.drawable.greatwurm, "Caledon Forest", "Defeat the great jungle wurm is a level 15 group event that occurs in Wychmire Swamp. It is the last part of The Battle for Wychmire Swamp, and a Swamp Chest will spawn upon completion.", "01:15", "02:00", 0);
        addEvent(populate);
        //Modniir Ulgoth
        populate = new WorldEventModel("Modniir Ulgoth", R.drawable.modniir, "Harathi Hinterlands", "Defeat Ulgoth the Modniir and his minions is a level 43 group event in Modniir Gorge.Defeat Ulgoth the Modniir and his minions is a level 43 group event in Modniir Gorge.", "01:30", "03:00", 0);
        addEvent(populate);
        //Shadow Behemoth
        populate = new WorldEventModel("Shadow Behemoth", R.drawable.behemoth, "Queensdale", "Defeat the shadow behemoth is a level 15 event that takes place in Godslost Swamp. While being fought, underworld portals appear, spawning Shades and Aatxes.", "01:45", "02:00", 0);
        addEvent(populate);
        //Golem Mark II
        populate = new WorldEventModel("Golem Mark II", R.drawable.golem, "Mount Maelstrom", "Defeat the Inquest's golem Mark II is a level 68 event that occurs in Whitland Flats.", "02:00", "03:00", 0);
        addEvent(populate);
        //Claw of Jormag
        populate = new WorldEventModel("Claw of Jormag", R.drawable.jormag, "Frostgorge Sound", "Defeat the Claw of Jormag is a level 80 event in Frostwalk Tundra. It is the last event in Breaking the Claw of Jormag where players face down the Claw of Jormag. Upon the dragon's defeat, the Frost Chest will spawn for players.", "02:30", "03:00", 0);
        addEvent(populate);
        //Tequatl the Sunless
        populate = new WorldEventModel("Tequatl the Sunless", R.drawable.tequatl, "Sparkfly Fen", "Defeat Tequatl the Sunless is a level 65 group event that occurs on the Splintered Coast in Sparkfly Fen. The event begins with Tequatl the Sunless flying out of the water, eventually landing in front of the player and beginning combat.", "00:00", null, 0);
        addEvent(populate);
        //Evolved Jungle Wurm
        populate = new WorldEventModel("Triple Trouble", R.drawable.evolvedwurm, "Bloodtide Coast", "Triple Trouble is a meta event that takes place in the Bloodtide Coast.", "01:00", null, 0);
        addEvent(populate);
        //Karka Queen
        populate = new WorldEventModel("Karka Queen", R.drawable.karka, "Southsun Cove", "The Legendary Karka Queen is a world boss in Southsun Cove. When its event triggers, players are given 15 minutes to reclaim 4 settlements (if those settlements are contested by karka invasions or crazed wildlife) and kill the Queen. Once all of them are controlled by the Lionguard, the Karka Queen spawns.", "02:00", null, 0);
        addEvent(populate);
    }

    public void addEvent(WorldEventModel event) {

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_EVENT_TITLE, event.getTitle());
        values.put(Constants.KEY_EVENT_ICON, event.getIcon());
        values.put(Constants.KEY_EVENT_LOCATION, event.getLocation());
        values.put(Constants.KEY_EVENT_DESCRIPTION, event.getDescription());
        values.put(Constants.KEY_EVENT_OCCURRENCE, event.getOccurrence());
        values.put(Constants.KEY_EVENT_OCCURRENCE_SHIFT, event.getOccurrenceShift());
        values.put(Constants.KEY_EVENT_SUBSCRIPTION, event.getSubscription());

        this.getWritableDatabase().insert(Constants.TABLE_NAME, Constants.KEY_EVENT_TITLE, values);
    }

}
