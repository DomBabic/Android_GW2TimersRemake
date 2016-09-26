package hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import hr.etfos.d1babic.guildwars2timersremake.R;

/**
 * Created by DominikZoran on 26.09.2016..
 */
public class EventsViewHolder {

    @BindView(R.id.events_item_icon)
    ImageView icon;

    @BindView(R.id.events_item_title)
    TextView title;

    @BindView(R.id.events_item_time)
    TextView time;

    @BindView(R.id.events_hidden_details)
    LinearLayout layout;

    @BindView(R.id.events_location)
    TextView location;

    @BindView(R.id.events_description)
    TextView description;

    @OnItemClick(R.id.events_listview_item)
    private void setVisible() {
        layout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.events_hide_details)
    private void setInvisible() {
        layout.setVisibility(View.GONE);
    }

    public EventsViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

}
