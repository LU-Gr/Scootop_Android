package fr.scootop.app.dashboard;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.scootop.R;
import fr.scootop.app.dashboard.items.BestVideoViewHolder;
import fr.scootop.app.dashboard.items.TopPlayersViewHolder;
import fr.scootop.app.player.details.OnPlayerDetailsListener;
import fr.scootop.app.video.OnPlayVideoListener;
import fr.scootop.data.model.Board;

public class DashboardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    interface ViewType
    {
        int BEST_VIDEO = 0;
        int TOP_PLAYERS = 1;
    }

    @NonNull
    private Board mBoard;
    private List<Integer> mItemTypes = new ArrayList<>();

    private OnPlayVideoListener mPlayVideoListener;
    private OnPlayerDetailsListener mPlayerDetailsListener;

    DashboardAdapter(@NonNull Board board, OnPlayVideoListener playVideoListener, OnPlayerDetailsListener playerDetailsListener)
    {
        mBoard = board;
        mPlayVideoListener = playVideoListener;
        mPlayerDetailsListener = playerDetailsListener;
        mItemTypes.clear();

        if (board.video != null) {
            mItemTypes.add(ViewType.BEST_VIDEO);
        }
        if (board.players != null && !board.players.isEmpty()) {
            mItemTypes.add(ViewType.TOP_PLAYERS);
        }
    }

    @Override
    public int getItemViewType(int position)
    {
        return mItemTypes.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (ViewType.BEST_VIDEO == viewType) {
            return new BestVideoViewHolder(inflater.inflate(R.layout.row_best_video, parent, false), mPlayVideoListener);
        } else if (ViewType.TOP_PLAYERS == viewType) {
            return new TopPlayersViewHolder(inflater.inflate(R.layout.row_top_players, parent, false), mPlayerDetailsListener);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof BestVideoViewHolder && mBoard.video != null) {
            ((BestVideoViewHolder) holder).layoutVideo(mBoard.video);
        } else if (holder instanceof TopPlayersViewHolder && mBoard.players != null) {
            ((TopPlayersViewHolder) holder).layoutPlayers(mBoard.players);
        }
    }

    @Override
    public int getItemCount()
    {
        return mItemTypes.size();
    }
}
