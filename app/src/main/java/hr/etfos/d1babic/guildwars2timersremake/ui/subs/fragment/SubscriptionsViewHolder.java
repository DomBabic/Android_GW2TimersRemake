package hr.etfos.d1babic.guildwars2timersremake.ui.subs.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.etfos.d1babic.guildwars2timersremake.R;

/**
 * Created by DominikZoran on 26.09.2016..
 */
public class SubscriptionsViewHolder {

    @BindView(R.id.subs_item_icon)
    public ImageView icon;

    @BindView(R.id.subs_item_title)
    public TextView title;

    @OnClick(R.id.subs_item_button)
    public void removeSubscription() {
        //TODO: Create presenter to handle unsubscribing the event

    }

    public SubscriptionsViewHolder(View view) {
        ButterKnife.bind(this, view);
    }
}
