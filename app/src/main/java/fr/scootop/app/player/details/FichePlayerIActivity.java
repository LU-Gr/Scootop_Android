package fr.scootop.app.player.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.tabs.TabLayout;

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