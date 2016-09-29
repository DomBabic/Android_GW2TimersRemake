package hr.etfos.d1babic.guildwars2timersremake.ui.subs.fragment;

import android.content.IntentFilter;
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
import butterknife.OnClick;
import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabaseInterface;
import hr.etfos.d1babic.guildwars2timersremake.data.database.DatabaseInterfaceImpl;
import hr.etfos.d1babic.guildwars2timersremake.data.database.EventsDatabase;
import hr.etfos.d1babic.guildwars2timersremake.model.WorldEventModel;
import hr.etfos.d1babic.guildwars2timersremake.presentation.SubscriptionsPresenter;
import hr.etfos.d1babic.guildwars2timersremake.presentation.SubscriptionsPresenterImpl;
import hr.etfos.d1babic.guildwars2timersremake.receiver.SubscriptionBroadcastListener;
import hr.etfos.d1babic.guildwars2timersremake.receiver.SubscriptionBroadcastReceiver;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.adapter.SubsListViewAdapter;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.dialog.CustomDialog;
import hr.etfos.d1babic.guildwars2timersremake.view.SubscriptionsView;

/**
 * Created by DominikZoran on 22.09.2016..
 */
public class SubscriptionsFragment extends Fragment implements SubscriptionsView, UnsubscribeClickListener, SubscriptionBroadcastListener{

    @BindView(R.id.subs_listview)
    ListView subsListView;

    @OnClick(R.id.subs_info)
    public void displayInfo() {
        CustomDialog dialog = new CustomDialog(getContext());
        dialog.show();
    }

    private SubscriptionsPresenter presenter;
    private SubsListViewAdapter adapter;
    private SubscriptionBroadcastReceiver receiver;
    private DatabaseInterface databaseInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        receiver = new SubscriptionBroadcastReceiver(this);
        getContext().registerReceiver(receiver, new IntentFilter("hr.etfos.d1babic.guildwars2timersremake" +
                ".NOTIFY_SUBS_CHANGED"));
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
        databaseInterface = new DatabaseInterfaceImpl(EventsDatabase.getInstance(getContext()));
        presenter = new SubscriptionsPresenterImpl(databaseInterface);
        presenter.setView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new SubsListViewAdapter(this);
        subsListView.setAdapter(adapter);
        presenter.getSubscribedEvents();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getContext().unregisterReceiver(receiver);
    }

    @Override
    public void setAdapterItems(List<WorldEventModel> subsList) {
        adapter.setAdapterItems(subsList);
    }

    @Override
    public void onUnsubscribeButtonClick(String title) {
        databaseInterface.setTitle(title);
        databaseInterface.unsubscribe();
        presenter.getSubscribedEvents();
    }

    @Override
    public void onBroadcastReceived() {
        presenter.getSubscribedEvents();
    }
}
