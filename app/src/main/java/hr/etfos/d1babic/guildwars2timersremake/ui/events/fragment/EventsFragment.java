package hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabaseInterface;
import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabaseInterfaceImpl;
import hr.etfos.d1babic.guildwars2timersremake.data.database.EventsDatabase;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;
import hr.etfos.d1babic.guildwars2timersremake.presentation.EventsPresenter;
import hr.etfos.d1babic.guildwars2timersremake.presentation.EventsPresenterImpl;
import hr.etfos.d1babic.guildwars2timersremake.ui.events.adapter.EventsListViewAdapter;
import hr.etfos.d1babic.guildwars2timersremake.view.EventsView;

/**
 * Created by DominikZoran on 22.09.2016..
 */
public class EventsFragment extends Fragment implements ItemClickListener, EventsView {

    @BindView(R.id.events_listview)
    ListView eventsListView;

    private EventsListViewAdapter adapter;
    private EventsPresenter presenter;
    private DatabaseInterface databaseInterface;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.events_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        initPresenter();
    }

    private void initUI(View view) {
        ButterKnife.bind(this, view);
    }

    private void initPresenter() {
        databaseInterface = new DatabaseInterfaceImpl(EventsDatabase.getInstance(getContext()));
        presenter = new EventsPresenterImpl(databaseInterface);
        presenter.setView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new EventsListViewAdapter(this);
        eventsListView.setAdapter(adapter);
        presenter.getAllEvents();
    }

    @Override
    public void onLongItemClick(String title) {
        databaseInterface.setTitle(title);
        databaseInterface.subscribe();
        intent = new Intent();
        intent.setAction("hr.etfos.d1babic.guildwars2timersremake.NOTIFY_SUBS_CHANGED");
        getContext().sendBroadcast(intent);
    }

    @Override
    public void setAdapterItems(List<WorldEventModel> eventsList) {
        adapter.setAdapterItems(eventsList);
    }
}
