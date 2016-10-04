package hr.etfos.d1babic.guildwars2timersremake.ui.events.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;
import hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment.EventsViewHolder;
import hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment.ItemClickListener;

/**
 * Created by DominikZoran on 26.09.2016..
 */

public class EventsListViewAdapter extends BaseAdapter{

    private final List<WorldEventModel> eventsList = new ArrayList<>();
    private final ItemClickListener itemListener;

    public EventsListViewAdapter(ItemClickListener itemClickListener) {
        this.itemListener = itemClickListener;
    }

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
            viewHolder = new EventsViewHolder(view, itemListener);

            view.setTag(viewHolder);
        } else {
            viewHolder = (EventsViewHolder) view.getTag();
        }

        if (viewHolder != null) {
            viewHolder.icon.setImageResource(eventsList.get(position).getIcon());
            viewHolder.title.setText(eventsList.get(position).getTitle());
            viewHolder.location.setText("Location: " + eventsList.get(position).getLocation());
            viewHolder.description.setText("Description: " + eventsList.get(position).getDescription());
            viewHolder.time.setText(eventsList.get(position).calculateAndDisplay());
        }

        Collections.sort(eventsList, new compareMilliseconds());

        return view;
    }

    public class compareMilliseconds implements Comparator<WorldEventModel> {

        @Override
        public int compare(WorldEventModel lhs, WorldEventModel rhs) {
            int c;
            c = lhs.getTimeRemainingInMilliseconds() < rhs.getTimeRemainingInMilliseconds() ? -1 : lhs
                    .getTimeRemainingInMilliseconds() == rhs.getTimeRemainingInMilliseconds() ? 0 : 1;
            if(c == 0) {
                c = lhs.getTitle().compareTo(rhs.getTitle());
            }
            return c;
        }
    }

}
