package hr.etfos.d1babic.guildwars2timersremake.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.etfos.d1babic.guildwars2timersremake.R;
import hr.etfos.d1babic.guildwars2timersremake.common.Constants;
import hr.etfos.d1babic.guildwars2timersremake.data.database.EventsDatabase;
import hr.etfos.d1babic.guildwars2timersremake.presentation.MainPresenter;
import hr.etfos.d1babic.guildwars2timersremake.presentation.MainPresenterImpl;
import hr.etfos.d1babic.guildwars2timersremake.ui.events.fragment.EventsFragment;
import hr.etfos.d1babic.guildwars2timersremake.ui.main.adapter.ViewPagerAdapter;
import hr.etfos.d1babic.guildwars2timersremake.ui.subs.fragment.SubscriptionsFragment;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    ViewPagerAdapter viewPagerAdapter;

    SharedPreferences preferences;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initAdapter();
    }

    private void initUI() {
        ButterKnife.bind(this);

        initToolbar();
        initTabLayout();
        setupViewPager(viewPager);
    }

    private void initToolbar() {
        actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
            actionBar.setDisplayUseLogoEnabled(true);
        }
    }

    private void initTabLayout() {
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        if(viewPager != null) {
            viewPager.setOffscreenPageLimit(Constants.viewPagerTabLimit);
        }
    }

    private void initAdapter() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new EventsFragment(), Constants.KEY_EVENTS_FRAGMENT_TITLE);
        viewPagerAdapter.addFragment(new SubscriptionsFragment(), Constants.KEY_SUBS_FRAGMENT_TITLE);

        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkIfFirstRun();
    }

    private void checkIfFirstRun() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        presenter = new MainPresenterImpl(preferences);

        if(presenter.checkFirstRun()) {
            EventsDatabase.getInstance(this).populateTable();
            presenter.setFirstRun();
        }

    }
}
