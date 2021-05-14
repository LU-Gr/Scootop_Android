package fr.scootop.app.dashboard.items;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.scootop.BuildConfig;
import fr.scootop.R;
import fr.scootop.app.video.OnPlayVideoListener;
import fr.scootop.data.model.Video;

public class BestVideoViewHolder extends RecyclerView.ViewHolder
{
    @BindView(R.id.row_best_video_title)
    TextView mTitleLabel;

    @BindView(R.id.row_best_video_thumbnail)
    YouTubeThumbnailView mThumbnailView;

    @Nullable
    private OnPlayVideoListener mPlayVideoListener;

    @Nullable
    private Video mVideo;

    public BestVideoViewHolder(View itemView, OnPlayVideoListener playVideoListener)
    {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mPlayVideoListener = playVideoListener;
    }

    public void layoutVideo(final Video video)
    {
        mVideo = video;
        mTitleLabel.setText(video.getComment());

        mThumbnailView.initialize(BuildConfig.YT_DEV_KEY, new YouTubeThumbnailView.OnInitializedListener()
        {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView,
                                                YouTubeThumbnailLoader youTubeThumbnailLoader)
            {
                youTubeThumbnailLoader.setVideo(video.getYoutubeId());
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView,
                                                YouTubeInitializationResult youTubeInitializationResult)
            {
            }
        });
    }

    @OnClick(R.id.row_best_video_play_button)
    public void onPlayVideo()
    {
        if (mVideo != null && mPlayVideoListener != null) {
            mPlayVideoListener.onPlayYoutubeVideo(mVideo.getYoutubeId());
        }
    }
}
