package fr.scootop.app.dashboard

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import com.google.android.youtube.player.YouTubeStandalonePlayer
import fr.scootop.BuildConfig
import fr.scootop.R
import fr.scootop.app.common.ExtraKey
import fr.scootop.app.player.details.OnPlayerDetailsListener
import fr.scootop.app.player.details.PlayerDetailsActivity
import fr.scootop.app.post.create.CreatePostActivity
import fr.scootop.app.video.OnPlayVideoListener
import fr.scootop.data.model.Board
import fr.scootop.data.model.Player
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(), DashboardView, OnPlayerDetailsListener, OnPlayVideoListener {

    private val interactor = DashboardInteractor(DashboardPresenter(this))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        fab.setOnClickListener {
            startActivity(Intent(context, CreatePostActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        interactor.fetchBoard()
    }

    override fun showEmptyState() {
        recyclerView.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showBoard(board: Board) {
        recyclerView.adapter = DashboardAdapter(board, this, this)
        recyclerView.visibility = View.VISIBLE
        recyclerView.smoothScrollToPosition(0)
    }

    override fun onDisplayPlayerDetails(player: Player) {
        val intent = Intent(context, PlayerDetailsActivity::class.java)
        intent.putExtra(ExtraKey.PLAYER_ID, player.id)
        startActivity(intent)
    }

    override fun onPlayYoutubeVideo(videoId: String) {
        val activity = activity
        if (activity != null) {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, BuildConfig.YT_DEV_KEY, videoId)
            startActivity(intent)
        }
    }
}
