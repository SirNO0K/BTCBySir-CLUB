package com.sirclub.btcbysir_club;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.sirclub.btcbysir_club.BX.BxControlFragment;
import com.sirclub.btcbysir_club.COINS.CoinsControlFragment;
import com.sirclub.btcbysir_club.Utils.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip mTabLayout;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setUpTabLayout();
    }

    private void setUpTabLayout() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);

        mTabLayout = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mTabLayout.setViewPager(mViewPager);
        mTabLayout.setBackgroundColor(0xFF6B6B6B);
    }


    private void setupViewPager(ViewPager viewPager) {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mSectionsPagerAdapter.AddFrag(new DashBoardFragment(), R.drawable.dashboard_logo);
        mSectionsPagerAdapter.AddFrag(new BxControlFragment(), R.drawable.bx_logo);
        mSectionsPagerAdapter.AddFrag(new CoinsControlFragment(), R.drawable.coins_logo);

        viewPager.setAdapter(mSectionsPagerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
