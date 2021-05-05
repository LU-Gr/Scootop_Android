package fr.scootop.app.shortlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.scootop.R;
import fr.scootop.data.model.ShortlistCollectionItem;

/**
 * Created by ludovicriviere on 14/02/2018.
 */
public class ShortlistAdapter extends RecyclerView.Adapter<ShortlistViewHolder>
{
    private List<ShortlistCollectionItem> mItems;
    private OnShortlistUserListener mListener;

    public ShortlistAdapter(OnShortlistUserListener listener)
    {
        mItems = new ArrayList<>();
        mListener = listener;
    }

    public void setItems(List<ShortlistCollectionItem> items)
    {
        mItems = items;
        notifyDataSetChanged();
    }

    @Override
    public ShortlistViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ShortlistViewHolder viewHolder = new ShortlistViewHolder(inflater.inflate(R.layout.row_shortlist_item, parent, false));
        viewHolder.setOnShortlistUserListener(mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShortlistViewHolder holder, int position)
    {
        holder.layoutItem(mItems.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mItems.size();
    }
}
