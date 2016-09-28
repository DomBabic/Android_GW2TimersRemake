package hr.etfos.d1babic.guildwars2timersremake.ui.subs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabasePresenter;
import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabasePresenterImpl;
import hr.etfos.d1babic.guildwars2timersremake.data.database.EventsDatabase;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.adapter.SubsListViewAdapter;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.dialog.CustomDialog;

/**
 * Created by DominikZoran on 22.09.2016..
 */
public class SubscriptionsFragment extends Fragment {

    @BindView(R.id.subs_listview)
    ListView subsListView;

    @OnClick(R.id.subs_info)
    public void displayInfo() {
        CustomDialog dialog = new CustomDialog(getContext());
        dialog.show();
    }

    private DatabasePresenter presenter;
    private SubsListViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.subs_fragment, container, false);
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
        adapter = new SubsListViewAdapter();
        subsListView.setAdapter(adapter);
        adapter.setAdapterItems(presenter.getSubsFromDatabase());
        adapter.notifyDataSetChanged();
    }
}
