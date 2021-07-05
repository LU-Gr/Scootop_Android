package fr.scootop.app.player.details

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import fr.scootop.R
import fr.scootop.app.common.ExtraKey
import fr.scootop.app.player.details.fragment.Caracteristique
import fr.scootop.app.player.details.fragment.EtatCivil
import fr.scootop.app.player.details.fragment.FicheMain
import fr.scootop.app.player.details.fragment.Video
import fr.scootop.data.model.user.domain.Player
import fr.scootop.data.model.user.domain.PlayerSearchResult

class FichePlayerIActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiche_player_iactivity)
        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpager)
        getTabs()
        val playerItem = intent.getParcelableExtra<PlayerSearchResult>(ExtraKey.PLAYER_ITEM)
    }

    fun getTabs(): Unit {
        Handler().post {
            val p = Player()
            val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

            //Bundle bundle = new Bundle();
            //bundle.putParcelable("player",p);
            viewPagerAdapter.addFragment(FicheMain.getInstance(), "Main")
            viewPagerAdapter.addFragment(EtatCivil.getInstance(), "ECV")
            viewPagerAdapter.addFragment(Caracteristique.getInstance(), "Car")
            viewPagerAdapter.addFragment(Video.getInstance(), "Video")
            viewPager!!.adapter = viewPagerAdapter
            tabLayout!!.setupWithViewPager(viewPager)
        }
    }
}