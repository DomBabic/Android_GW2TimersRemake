package hr.etfos.d1babic.guildwars2timersremake.ui.events.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEvent;
import hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment.EventsViewHolder;

/**
 * Created by DominikZoran on 26.09.2016..
 */

public class EventsListViewAdapter extends BaseAdapter{

    private final ArrayList<WorldEvent> eventsList = new ArrayList<>();

    EventsViewHolder viewHolder;

    @Override
    public int getCount() {
        return eventsList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events_listview_item, viewGroup, false);
            viewHolder = new EventsViewHolder(view);

            view.setTag(viewHolder);
        } else {
            viewHolder = (EventsViewHolder) view.getTag();
        }

        //TODO: Assign item's view values using presenter

        return view;
    }
}
