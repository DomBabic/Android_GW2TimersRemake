package hr.etfos.d1babic.guildwars2timersremake.presentation;

import android.content.SharedPreferences;

/**
 * Created by DominikZoran on 28.09.2016..
 */
public class MainPresenterImpl implements MainPresenter {

    SharedPreferences preferences;

    public MainPresenterImpl(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public boolean checkFirstRun() {
        return preferences.getBoolean("firstrun", true);
    }

    @Override
    public void setFirstRun() {
        preferences.edit().putBoolean("firstrun", false).apply();
    }
}
