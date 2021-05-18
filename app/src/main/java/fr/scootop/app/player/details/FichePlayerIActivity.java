package fr.scootop.app.player.details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import fr.scootop.R;
import fr.scootop.app.player.details.fragment.Caracteristique;
import fr.scootop.app.player.details.fragment.EtatCivil;
import fr.scootop.app.player.details.fragment.FicheMain;
import fr.scootop.app.player.details.fragment.Video;

public class FichePlayerIActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_player_iactivity);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        getTabs();

    }


    public void getTabs(){

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

                viewPagerAdapter.addFragment(FicheMain.getInstance(),"Main");
                viewPagerAdapter.addFragment(EtatCivil.getInstance(),"ECV");
                viewPagerAdapter.addFragment(Caracteristique.getInstance(),"Car");
                viewPagerAdapter.addFragment(Video.getInstance(),"Video");

                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

            }
        });
    }
}