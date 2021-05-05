package fr.scootop.app.search;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import fr.scootop.R;
import fr.scootop.data.model.PlayerSearchItem;

public class SearchPlayerAdapter extends BaseAdapter
{
	private List<PlayerSearchItem> mPlayers;
	private LayoutInflater mInflater;

	public SearchPlayerAdapter(Context context)
	{
		mPlayers = new ArrayList<>();
		mInflater = LayoutInflater.from(context);
	}

	public void addPlayers(List<PlayerSearchItem> list)
	{
		this.addPlayers(list, 0);
	}

	public void addPlayers(List<PlayerSearchItem> list, int page)
	{
		if (page <= 0) {
			mPlayers.clear();
		}
		mPlayers.addAll(list);
		notifyDataSetChanged();
	}

	@Nullable
	public PlayerSearchItem getPlayerItem(int position)
	{
		if (mPlayers.size() > position) {
			return mPlayers.get(position);
		}
		return null;
	}

	@Override
	public int getCount()
	{
		return mPlayers.size();
	}

	@Override
	public Object getItem(int position)
	{
		return mPlayers.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		SearchPlayerItemViewHolder viewHolder;
		if (null == convertView) {
			convertView = mInflater.inflate(R.layout.row_search_main, parent, false);
			viewHolder = new SearchPlayerItemViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (SearchPlayerItemViewHolder) convertView.getTag();
		}

		viewHolder.setPlayerItem(mPlayers.get(position));
		return convertView;
	}
}
