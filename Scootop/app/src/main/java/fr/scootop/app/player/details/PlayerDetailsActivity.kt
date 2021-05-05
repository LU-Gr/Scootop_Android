package fr.scootop.app.player.details

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.google.android.youtube.player.*
import fr.scootop.BuildConfig
import fr.scootop.R
import fr.scootop.app.common.ExtraKey
import fr.scootop.app.common.ImageHelper
import fr.scootop.data.model.Player
import fr.scootop.data.model.PlayerSearchItem
import fr.scootop.data.model.Video
import kotlinx.android.synthetic.main.activity_player_details.*


class PlayerDetailsActivity : YouTubeBaseActivity(), PlayerDetailsView, YouTubeThumbnailView.OnInitializedListener {

    private val mInteractor by lazy {
        PlayerDetailsInteractor(PlayerDetailsPresenter(this))
    }

    private var mYTVideoId: String? = null
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_details)
        ButterKnife.bind(this)

        playerDetailsToolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp)
        playerDetailsToolbar.setNavigationOnClickListener { onBackPressed() }
        playerDetailsToolbar.setTitle(R.string.player_details_title)

        aboutButton.setOnClickListener {
            Toast.makeText(this, "Afficher plus d'information", Toast.LENGTH_SHORT).show()
        }

        teamNameLabel.setOnClickListener {
            Toast.makeText(this, "Afficher la fiche équipe", Toast.LENGTH_SHORT).show()
        }

        ytPlayButton.setOnClickListener {
            mYTVideoId?.let {
                val intent = YouTubeStandalonePlayer.createPlaylistIntent(this@PlayerDetailsActivity, BuildConfig.YT_DEV_KEY, it)
                startActivity(intent)
            }
        }

        alertButton.setOnClickListener {
            mInteractor.alert()
        }

        followButton.setOnClickListener {
            val isFollowing = mInteractor.isFollowing()
            if (isFollowing != null) {
                AlertDialog.Builder(this)
                    .setTitle(if (isFollowing) R.string.dialog_unfollow_player_title else R.string.dialog_follow_player_title)
                    .setMessage(if (isFollowing) R.string.dialog_unfollow_player_description else R.string.dialog_follow_player_description)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setNegativeButton(R.string.action_cancel, { dialog, _ -> dialog.dismiss() })
                    .setPositiveButton(if (isFollowing) R.string.action_unfollow else R.string.action_follow,
                        { dialog, _ ->
                            dialog.dismiss()
                            if (isFollowing) {
                                mInteractor.removeToShortlist()
                            } else {
                                mInteractor.addToShortlist()
                            }
                        })
                    .show()
            }
        }

        inviteButton.setOnClickListener {
            mInteractor.invite()
        }

        if (intent?.getParcelableExtra<Parcelable>(ExtraKey.PLAYER_ITEM) != null) {
            val playerItem = intent.getParcelableExtra<PlayerSearchItem>(ExtraKey.PLAYER_ITEM)

            /** on affiche déjà quelques informations (celles que nous avons)  */
            nameLabel.text = playerItem.name
            positionLabel.text = playerItem.positionName
            teamNameLabel.text = playerItem.teamName

            /** récupération des données détaillées du joueur  */
            mInteractor.loadPlayer(playerItem.playerId)
        } else if (intent?.getIntExtra(ExtraKey.PLAYER_ID, 0) != 0) {
            val playerId = intent.getIntExtra(ExtraKey.PLAYER_ID, 0)
            mInteractor.loadPlayer(playerId)
        }

        otherVideosRecyclerView.visibility = View.GONE
    }

    override fun getContext(): Context {
        return this
    }

    override fun displayPlayer(player: Player) {
        /** ici nous avons plus d'informations, à utiliser ! */

        val isFollowing = mInteractor.isFollowing()
        if (isFollowing != null) {
            followButton.isEnabled = true
            followButton.setText(if (isFollowing) R.string.action_unfollow else R.string.action_follow)
        } else {
            followButton.isEnabled = false
        }

        val pictureName = player.user.pictureName
        if (pictureName != null) {
            Glide.with(this)
                .load(ImageHelper.getUserAvatarUrl(pictureName))
                .fitCenter()
                .placeholder(R.mipmap.ic_default_avatar)
                .into(avatarImageView)
        }

        nameLabel.text = "%s %s".format(player.user.firstName, player.user.lastName)
        positionLabel.text = player.favoritePosition?.name ?: ""
        teamNameLabel.text = player.team?.name ?: ""

        matchsGoalsLabel.text = "%d / %d".format(player.matchesCount, player.goalsCount)
        passesSkillsLabel.text = "%d / %d".format(player.passesCount, player.skillsCount)
        distinctionsLabel.text = "%d".format(player.distinctionsCount)

        if (player.videos.isEmpty()) {
            ytThumbnailView.visibility = View.GONE
            ytPlayButton.visibility = View.GONE
            noVideoLabel.visibility = View.VISIBLE
        } else {
            val firstVideo: Video = player.videos.removeAt(0)

            mYTVideoId = firstVideo.youtubeId
            videoTitleLabel.text = firstVideo.comment
            ytThumbnailView.initialize(BuildConfig.YT_DEV_KEY, this)

            ytThumbnailView.visibility = View.VISIBLE
            ytPlayButton.visibility = View.VISIBLE
            noVideoLabel.visibility = View.GONE
        }
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

    override fun onInitializationSuccess(p0: YouTubeThumbnailView?, p1: YouTubeThumbnailLoader?) {
        mYTVideoId?.let {
            p1?.setVideo(it)
        }
    }

    override fun onInitializationFailure(p0: YouTubeThumbnailView?, p1: YouTubeInitializationResult?) {}

}
