package hr.etfos.d1babic.guildwars2timersremake.ui.events.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;
import hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment.EventsViewHolder;

/**
 * Created by DominikZoran on 26.09.2016..
 */

public class EventsListViewAdapter extends BaseAdapter{

    private final List<WorldEventModel> eventsList = new ArrayList<>();

    public void setAdapterItems(List<WorldEventModel> worldEventModelList) {
        eventsList.clear();
        eventsList.addAll(worldEventModelList);
        notifyDataSetChanged();
    }

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

        EventsViewHolder viewHolder;

        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events_listview_item, viewGroup, false);
            viewHolder = new EventsViewHolder(view);

            view.setTag(viewHolder);
        } else {
            viewHolder = (EventsViewHolder) view.getTag();
        }

        if (viewHolder != null) {
            viewHolder.icon.setImageResource(eventsList.get(position).getIcon());
            viewHolder.title.setText(eventsList.get(position).getTitle());
            viewHolder.time.setText(Long.toString(eventsList.get(position).getTimeRemaining()));
            viewHolder.location.setText("Location: " + eventsList.get(position).getLocation());
            viewHolder.description.setText("Description: " + eventsList.get(position).getDescription());
        }

        return view;
    }
}
