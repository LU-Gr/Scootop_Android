package fr.scootop.app.shortlist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mikhaellopez.circularimageview.CircularImageView
import fr.scootop.R
import fr.scootop.app.common.ImageHelper
import fr.scootop.data.definition.UserType

import fr.scootop.data.model.ShortlistCollectionItem
import kotlinx.android.synthetic.main.activity_player_details.*

import kotterknife.bindView

class ShortlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val avatarImageView: CircularImageView by bindView(R.id.avatarImageView)
    val playerNameLabel: TextView by bindView(R.id.playerNameLabel)

    private var mShortlistUserListener: OnShortlistUserListener? = null
    private var mItem: ShortlistCollectionItem? = null

    init {
        itemView.setOnClickListener {
            val userType = mItem?.shortlistedUser?.type
            val typeId = mItem?.shortlistedUser?.typeId

            if (userType != null && typeId != null) {
                val type = UserType.from(userType)

                if (type == UserType.Player) {
                    mShortlistUserListener?.onDisplayPlayer(typeId)
                }
            }
        }
    }

    fun setOnShortlistUserListener(listener: OnShortlistUserListener) {
        mShortlistUserListener = listener
    }

    fun layoutItem(item: ShortlistCollectionItem) {
        val user = item.shortlistedUser

        playerNameLabel.text = "${user.firstName} ${user.lastName}"

        val pictureName = user.pictureName
        if (pictureName != null) {
            Glide.with(itemView.context)
                .load(ImageHelper.getUserAvatarUrl(pictureName))
                .fitCenter()
                .placeholder(R.mipmap.ic_default_avatar)
                .into(avatarImageView)
        } else {
            avatarImageView.setImageResource(R.mipmap.ic_default_avatar)
        }

        mItem = item
    }
}
