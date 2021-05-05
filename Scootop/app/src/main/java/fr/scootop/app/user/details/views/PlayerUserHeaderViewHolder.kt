package fr.scootop.app.user.details.views

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mikhaellopez.circularimageview.CircularImageView
import fr.scootop.R
import fr.scootop.app.common.ImageHelper
import fr.scootop.data.model.Player
import kotterknife.bindView

class PlayerUserHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val avatarImageView: CircularImageView by bindView(R.id.avatarImageView)
    val aboutButton: Button by bindView(R.id.aboutButton)
    val nameLabel: TextView by bindView(R.id.nameLabel)
    val positionLabel: TextView by bindView(R.id.positionLabel)
    val teamNameLabel: TextView by bindView(R.id.teamNameLabel)

    var player: Player? = null
        set(value) {
            value?.let {

                it.user.pictureName?.let {
                    Glide.with(itemView.context)
                        .load(ImageHelper.getUserAvatarUrl(it))
                        .fitCenter()
                        .placeholder(R.mipmap.ic_default_avatar)
                        .into(avatarImageView)
                } ?: run {
                    avatarImageView.setImageResource(R.mipmap.ic_default_avatar)
                }

                nameLabel.text = "${it.user.firstName} ${it.user.lastName}"
                positionLabel.text = it.favoritePosition?.name ?: ""
                teamNameLabel.text = it.team?.name ?: ""
            }
        }

}