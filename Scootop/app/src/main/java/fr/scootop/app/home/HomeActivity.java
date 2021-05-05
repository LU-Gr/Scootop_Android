package fr.scootop.app.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.scootop.R;
import fr.scootop.app.search.SearchActivity;

public class HomeActivity extends AppCompatActivity
{
    @BindView(R.id.home_tabs)
    TabLayout mTabLayout;

    @BindView(R.id.home_viewpager)
    ViewPager mViewPager;

    private HomeInteractor mInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);

        mInteractor = new HomeInteractor();
        mInteractor.initialize(getApplicationContext());

        HomeAdapter adapter = new HomeAdapter(getSupportFragmentManager(), mInteractor.getUser(this));
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = adapter.getCount() - 1; i >= 0; i--) {
            mTabLayout.getTabAt(i).setIcon(adapter.getPageIcon(i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.search_item:
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
