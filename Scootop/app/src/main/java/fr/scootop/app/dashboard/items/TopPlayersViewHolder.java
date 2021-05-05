package fr.scootop.app.dashboard.items;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.scootop.R;
import fr.scootop.app.dashboard.TopPlayerAdapter;
import fr.scootop.app.player.details.OnPlayerDetailsListener;
import fr.scootop.data.model.Player;
import fr.scootop.data.model.Video;

public class TopPlayersViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.top_players_recycler_view)
    RecyclerView mRecyclerView;

    private OnPlayerDetailsListener mListener;

    public TopPlayersViewHolder(View itemView, OnPlayerDetailsListener listener)
    {
        super(itemView);
        ButterKnife.bind(this, itemView);

        LinearLayoutManager llm = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(llm);

        mListener = listener;
    }

    public void layoutPlayers(List<Player> players)
    {
        TopPlayerAdapter adapter = new TopPlayerAdapter(players, mListener);
        mRecyclerView.setAdapter(adapter);
    }
}
