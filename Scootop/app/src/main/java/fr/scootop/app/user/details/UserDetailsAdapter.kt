package fr.scootop.app.user.details

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import java.util.ArrayList

import fr.scootop.R
import fr.scootop.app.shortlist.OnShortlistUserListener
import fr.scootop.app.shortlist.ShortlistViewHolder
import fr.scootop.data.model.ShortlistCollectionItem

class UserDetailsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mItems: List<ShortlistCollectionItem>? = null

    init {
        mItems = ArrayList()
    }

    fun setItems(items: List<ShortlistCollectionItem>) {
        mItems = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortlistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = ShortlistViewHolder(inflater.inflate(R.layout.row_shortlist_item, parent, false))
        //viewHolder.setOnShortlistUserListener(mListener)
        return viewHolder
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return mItems!!.size
    }
}
