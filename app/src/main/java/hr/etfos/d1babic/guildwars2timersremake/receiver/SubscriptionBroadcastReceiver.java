package hr.etfos.d1babic.guildwars2timersremake.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by DominikZoran on 29.09.2016..
 */
public class SubscriptionBroadcastReceiver extends BroadcastReceiver {

    private SubscriptionBroadcastListener listener;

    public SubscriptionBroadcastReceiver(SubscriptionBroadcastListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        listener.onBroadcastReceived();
    }

}
