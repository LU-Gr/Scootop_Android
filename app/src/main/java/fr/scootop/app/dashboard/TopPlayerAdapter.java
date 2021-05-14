package fr.scootop.app.dashboard;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import fr.scootop.R;
import fr.scootop.app.dashboard.items.BestVideoViewHolder;
import fr.scootop.app.dashboard.items.TopPlayerViewHolder;
import fr.scootop.app.dashboard.items.TopPlayersViewHolder;
import fr.scootop.app.player.details.OnPlayerDetailsListener;
import fr.scootop.data.model.Board;
import fr.scootop.data.model.Player;

public class TopPlayerAdapter extends RecyclerView.Adapter<TopPlayerViewHolder>
{
    private List<Player> mPlayers = new ArrayList<>();
    private OnPlayerDetailsListener mDetailsListener;

    public TopPlayerAdapter(@NonNull List<Player> players, OnPlayerDetailsListener listener)
    {
        mPlayers = players;
        mDetailsListener = listener;
    }

    @Override
    public TopPlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TopPlayerViewHolder(inflater.inflate(R.layout.card_item_top_player, parent, false), mDetailsListener);
    }

    @Override
    public void onBindViewHolder(TopPlayerViewHolder holder, int position)
    {
        holder.layoutPlayer(mPlayers.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mPlayers.size();
    }
}
