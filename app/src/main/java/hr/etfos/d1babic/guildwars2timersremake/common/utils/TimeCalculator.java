package hr.etfos.d1babic.guildwars2timersremake.common.utils;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by DominikZoran on 01.10.2016..
 */
public class TimeCalculator {

    Calendar calendar = Calendar.getInstance();

    public long calculateTime(String shiftFromPrevious, String repeatTime, String title) {

        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        long countdownTime;

        switch (title) {
            case "Karka Queen":
                countdownTime = 0;
                break;
            case "Tequatl the Sunless":
                countdownTime = 0;
                break;
            case "Triple Trouble":
                countdownTime = 0;
                break;
            default:
                String[] repeat = repeatTime.split(":");
                String[] start = shiftFromPrevious.split(":");
                long repeatInMillis = Integer.parseInt(repeat[0]) * 3600000;
                long startInMillis = (Integer.parseInt(start[0]) * 3600000) + (Integer.parseInt(start[1]) * 60000);
                calendar.getTimeInMillis();

                countdownTime = repeatInMillis - (((-startInMillis) + calendar.getTimeInMillis()) % repeatInMillis);
                break;
        }

        return countdownTime;
    }
}
