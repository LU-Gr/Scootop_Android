package fr.scootop.app.video.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import fr.scootop.R;

public class PlayersVideosAdapter extends RecyclerView.Adapter<PlayersVideosAdapter.ViewHolder>{

    private String[] videoIds;
    private Lifecycle lifecycle;

    public PlayersVideosAdapter(String[] videoIds, Lifecycle lifecycle) {
        this.videoIds = videoIds;
        this.lifecycle = lifecycle;
    }

    @NonNull
    @Override
    public PlayersVideosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_player_video_item, parent, false);
        lifecycle.addObserver(youTubePlayerView);

        return new ViewHolder(youTubePlayerView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.cueVideo(videoIds[position]);

    }

    @Override
    public int getItemCount() {
        return videoIds.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private YouTubePlayerView youTubePlayerView;
        private YouTubePlayer youTubePlayer;
        private String currentVideoId;

        ViewHolder(YouTubePlayerView playerView) {
            super(playerView);
            youTubePlayerView = playerView;

            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer initializedYouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer;
                    youTubePlayer.cueVideo(currentVideoId, 0);
                }
            });
        }

        void cueVideo(String videoId) {
            currentVideoId = videoId;

            if(youTubePlayer == null)
                return;

            youTubePlayer.cueVideo(videoId, 0);
        }
    }
}
