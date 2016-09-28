package hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabasePresenter;
import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabasePresenterImpl;
import hr.etfos.d1babic.guildwars2timersremake.data.database.EventsDatabase;
import hr.etfos.d1babic.guildwars2timersremake.ui.events.adapter.EventsListViewAdapter;

/**
 * Created by DominikZoran on 22.09.2016..
 */
public class EventsFragment extends Fragment implements ItemClickListener{

    @BindView(R.id.events_listview)
    ListView eventsListView;

    private EventsListViewAdapter adapter;
    private DatabasePresenter presenter;

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
        presenter = new DatabasePresenterImpl(EventsDatabase.getInstance(getContext()));
    }

    @Override
    public void onStart() {
        super.onStart();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new EventsListViewAdapter(this);
        eventsListView.setAdapter(adapter);
        adapter.setAdapterItems(presenter.getEventsFromDatabase());
    }

    @Override
    public void onLongItemClick(String title) {
        presenter.setTitle(title);
    }
}
