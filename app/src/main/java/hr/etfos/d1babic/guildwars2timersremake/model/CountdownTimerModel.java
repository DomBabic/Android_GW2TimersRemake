package hr.etfos.d1babic.guildwars2timersremake.model;

import android.os.CountDownTimer;

import java.util.concurrent.TimeUnit;

import hr.etfos.d1babic.guildwars2timersremake.view.EventsAdapterView;

/**
 * Created by DominikZoran on 01.10.2016..
 */
public class CountdownTimerModel extends CountDownTimer{

    private EventsAdapterView view;

    public CountdownTimerModel(long millisUntilFinished, long countDownInterval) {
        super(millisUntilFinished, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        view.setRemainingTime(String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % TimeUnit.MINUTES.toSeconds(1)));
    }

    @Override
    public void onFinish() {
        cancel();
    }

    public void setView(EventsAdapterView view) {
        this.view = view;
    }

}
