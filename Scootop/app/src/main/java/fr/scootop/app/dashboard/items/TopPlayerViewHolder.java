package fr.scootop.app.dashboard.items;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularimageview.CircularImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.scootop.R;
import fr.scootop.app.common.ImageHelper;
import fr.scootop.app.player.details.OnPlayerDetailsListener;
import fr.scootop.data.model.Player;

public class TopPlayerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    @BindView(R.id.top_player_avatar_imageview)
    CircularImageView mAvatarImageView;

    @BindView(R.id.top_player_name_label)
    TextView mNameLabel;

    @BindView(R.id.top_player_team_label)
    TextView mTeamLabel;

    private final OnPlayerDetailsListener mListener;
    private Player mPlayer;

    public TopPlayerViewHolder(View itemView, OnPlayerDetailsListener listener)
    {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        mListener = listener;
    }

    public void layoutPlayer(Player player)
    {
        mPlayer = player;
        mNameLabel.setText(String.format("%s %s", player.user.getFirstName(), player.user.getLastName()));

        if (player.team != null) {
            mTeamLabel.setText(player.team.name);
        } else {
            mTeamLabel.setText("");
        }

        String pictureName = player.user.getPictureName();
        if (pictureName != null) {
            Glide.with(mAvatarImageView.getContext())
                 .load(ImageHelper.INSTANCE.getUserAvatarUrl(pictureName))
                 .fitCenter()
                 .placeholder(R.mipmap.ic_default_avatar)
                 .into(mAvatarImageView);
        } else {
            mAvatarImageView.setImageResource(R.mipmap.ic_default_avatar);
        }
    }

    @Override
    public void onClick(View v)
    {
        mListener.onDisplayPlayerDetails(mPlayer);
    }
}
