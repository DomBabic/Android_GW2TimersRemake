package hr.etfos.d1babic.guildwars2timersremake.ui.subs.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.fragment.SubscriptionsViewHolder;

/**
 * Created by DominikZoran on 26.09.2016..
 */
public class SubsListViewAdapter extends BaseAdapter {

    private final ArrayList<WorldEventModel> subscribedEvents = new ArrayList<>();

    SubscriptionsViewHolder viewHolder;

    @Override
    public int getCount() {
        return subscribedEvents.size();
    }

    @Override
    public Object getItem(int position) {
        return subscribedEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subs_listview_item, viewGroup, false);
            viewHolder = new SubscriptionsViewHolder(view);

            view.setTag(viewHolder);
        } else {
            viewHolder = (SubscriptionsViewHolder)view.getTag();
        }

        //TODO: Handle dataset change

        return view;
    }
}
