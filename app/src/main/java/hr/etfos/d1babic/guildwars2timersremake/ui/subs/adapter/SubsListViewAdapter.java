package hr.etfos.d1babic.guildwars2timersremake.ui.subs.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.fragment.SubscriptionsViewHolder;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.fragment.UnsubscribeClickListener;

/**
 * Created by DominikZoran on 26.09.2016..
 */
public class SubsListViewAdapter extends BaseAdapter {

    private final List<WorldEventModel> subscribedEvents = new ArrayList<>();
    private final UnsubscribeClickListener listener;

    public SubsListViewAdapter(UnsubscribeClickListener listener) {
        this.listener = listener;
    }

    public void setAdapterItems(List<WorldEventModel> worldEventModelList) {
        subscribedEvents.clear();
        subscribedEvents.addAll(worldEventModelList);
        notifyDataSetChanged();
    }

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

        SubscriptionsViewHolder viewHolder;

        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subs_listview_item, viewGroup, false);
            viewHolder = new SubscriptionsViewHolder(view, listener);

            view.setTag(viewHolder);
        } else {
            viewHolder = (SubscriptionsViewHolder)view.getTag();
        }

        if(viewHolder != null) {
            viewHolder.icon.setImageResource(subscribedEvents.get(position).getIcon());
            viewHolder.title.setText(subscribedEvents.get(position).getTitle());
        }

        return view;
    }
}
