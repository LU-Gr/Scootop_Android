package fr.scootop.app.youtube.picker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import fr.scootop.R
import fr.scootop.data.model.youtube.YTSearchResult
import kotlin.properties.Delegates

class YTVideoPickerAdapter(val context: Context) : BaseAdapter() {

    var items: Array<YTSearchResult> = emptyArray()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: YTVideoResultViewHolder by Delegates.notNull() //; //= YTVideoResultViewHolder(null)
        var view: View by Delegates.notNull() //; // = View(context)

        convertView?.let {
            holder = it.tag as YTVideoResultViewHolder
            view = it
        } ?: run {
            view = LayoutInflater.from(context).inflate(R.layout.row_search_youtube_result, parent, false)
            holder = YTVideoResultViewHolder(view)
            view.tag = holder
        }

        holder.item = items[position]
        return view
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}