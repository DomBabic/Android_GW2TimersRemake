package hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.etfos.d1babic.guildwars2timersremake.R;

/**
 * Created by DominikZoran on 26.09.2016..
 */
public class EventsViewHolder {

    @BindView(R.id.events_item_icon)
    public ImageView icon;

    @BindView(R.id.events_item_title)
    public TextView title;

    @BindView(R.id.events_item_time)
    public TextView time;

    @BindView(R.id.events_hidden_details)
    public LinearLayout layout;

    @BindView(R.id.events_location)
    public TextView location;

    @BindView(R.id.events_description)
    public TextView description;

    @OnClick(R.id.events_listview_item)
    public void setVisible() {
        layout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.events_hide_details)
    public void setInvisible() {
        layout.setVisibility(View.GONE);
    }

    public EventsViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

}
