package fr.scootop.app.player.details

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
import kotlinx.android.synthetic.main.old_activity_player_details.*

class FichePlayerActivity : AppCompatActivity(), PlayerDetailsView {

    private val mInteractor by lazy {
        PlayerDetailsInteractor(PlayerDetailsPresenter(this), this)
    }

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var playerItem: PlayerSearchResult? = null

    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiche_player_iactivity)
        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpager)

        playerItem = intent.getParcelableExtra(ExtraKey.PLAYER_ITEM)
        val playerId = playerItem!!.id
    }

    override fun getContext(): Context {
        TODO("Not yet implemented")
    }

    override fun displayPlayer(player: Player) {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        //Bundle bundle = new Bundle();
        //bundle.putParcelable("player",p);
        val a = Intent(this, FicheMain::class.java)
        a.putExtra("Player",playerItem)
        viewPagerAdapter.addFragment(FicheMain.getInstance(), "Main")
        viewPagerAdapter.addFragment(EtatCivil.getInstance(), "ECV")
        viewPagerAdapter.addFragment(Caracteristique.getInstance(), "Car")
        viewPagerAdapter.addFragment(Video.getInstance(), "Video")
        viewPager!!.adapter = viewPagerAdapter
        tabLayout!!.setupWithViewPager(viewPager)
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayInfo(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun hideInviteAction() {
        inviteButton.visibility = View.GONE
    }

    override fun displayLoading() {
        if (mProgressDialog != null) {
            mProgressDialog?.show()
        } else {
            mProgressDialog = ProgressDialog.show(this, getString(R.string.dialog_loading_title), getString(R.string.dialog_loading_message), true)
        }
    }

    override fun hideLoading() {
        mProgressDialog?.hide()
    }
}