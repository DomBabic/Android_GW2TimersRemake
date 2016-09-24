package hr.etfos.d1babic.guildwars2timersremake.common;

/**
 * Created by DominikZoran on 22.09.2016..
 */
public class Constants {

    //ViewPager tabs info
    public static final int viewPagerTabLimit = 2;
    public static final String KEY_EVENTS_FRAGMENT_TITLE = "Events";
    public static final String KEY_SUBS_FRAGMENT_TITLE = "Subscriptions";

    //Database
    public static final String DATABASE_NAME = "event_database";
    public static final String TABLE_NAME = "events";

    public static final String KEY_ID = "_id";
    public static final String KEY_EVENT_TITLE = "event_title";
    public static final String KEY_EVENT_ICON = "icon";
    public static final String KEY_EVENT_LOCATION = "location";
    public static final String KEY_EVENT_DESCRIPTION = "description";
    public static final String KEY_EVENT_OCCURRENCE = "occurrence";
    public static final String KEY_EVENT_OCCURRENCE_SHIFT = "occurrence_shift";
    public static final String KEY_EVENT_SUBSCRIPTION = "subscription";
    public static final String CREATE_EVENTS_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "(" + Constants.KEY_ID +
            " INTEGER " + "PRIMARY KEY AUTOINCREMENT, " + Constants.KEY_EVENT_TITLE + " TEXT," + Constants
            .KEY_EVENT_ICON + " " + "INTEGER," + Constants.KEY_EVENT_LOCATION + " TEXT," + Constants
            .KEY_EVENT_DESCRIPTION + " TEXT," + Constants.KEY_EVENT_OCCURRENCE + " TEXT," + Constants
            .KEY_EVENT_OCCURRENCE_SHIFT + " TEXT," + Constants.KEY_EVENT_SUBSCRIPTION + " INTEGER" + ")";
    public static final String DROP_EVENTS_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
