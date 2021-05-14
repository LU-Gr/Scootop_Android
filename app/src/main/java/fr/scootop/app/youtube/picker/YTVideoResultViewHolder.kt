package fr.scootop.app.youtube.picker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import fr.scootop.R
import fr.scootop.data.model.youtube.YTSearchResult

class YTVideoResultViewHolder(val view: View) {

    var item: YTSearchResult? = null
        set(value) {
            val videoThumbnail = view.findViewById<ImageView>(R.id.videoThumbnail)

            value?.let {
                it.snippet?.thumbnails?.let {
                    Glide.with(videoThumbnail.context)
                        .load(it.default?.url)
                        .into(videoThumbnail)
                }

                view.findViewById<TextView>(R.id.videoTitle)?.text = it.snippet?.title
                view.findViewById<TextView>(R.id.videoDescription)?.text = it.snippet?.description
            } ?: run {
                videoThumbnail.setImageResource(0)
                view.findViewById<TextView>(R.id.videoTitle)?.text = ""
                view.findViewById<TextView>(R.id.videoDescription)?.text = ""
            }
        }
}