package fr.scootop.app.shortlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.scootop.R;
import fr.scootop.data.model.ShortlistCollectionItem;

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
