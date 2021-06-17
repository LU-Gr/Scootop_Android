package fr.scootop.app.player.details.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View.OnClickListener;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import fr.scootop.R;
import fr.scootop.app.comparator.ComparatorActivity;
import fr.scootop.app.interactions.AlertActivity;
import fr.scootop.app.interactions.FollowActivity;
import fr.scootop.app.interactions.InviteActivity;
import fr.scootop.app.video.utils.PlayersVideosAdapter;
import fr.scootop.app.video.utils.VideoFragment;
import fr.scootop.app.video.utils.VideoIdsProvider;

public class Video extends Fragment implements OnClickListener {

    private YouTubePlayerView youTubePlayerView;
    private Button playNextVideoButton;
    private Button InviterButton;
    private Button SuivreButton;
    private Button AlerterButton;
    Button Play;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.row_fiche_player_videos, container,false);

        if (savedInstanceState == null) {
            Fragment newFragment = new VideoFragment();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.add(R.id.ytThumbnailViewI, newFragment).commit();
        }


        RecyclerView recyclerView = view.findViewById(R.id.otherVideosRecyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        String[] videoIds = {"cCNmMm3Tbzo", "IPdUshUP8BE", "fnUqm4FfAA4", "5DhINO-NFbg","1ciOnOwl9k4","CAnuIkvGyKQ","Oi-G_ZTiIqU","qYUPZXMjAIQ"};

        RecyclerView.Adapter recyclerViewAdapter = new PlayersVideosAdapter(videoIds, this.getLifecycle());
        recyclerView.setAdapter(recyclerViewAdapter);

        //Play = (Button) view.findViewById(R.id.inviteButtonI);
        /*Play.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {


            }
        });*/

        SuivreButton = view.findViewById(R.id.followButton);
        InviterButton = view.findViewById(R.id.inviteButtonI);
        AlerterButton = view.findViewById(R.id.alertButton);

        SuivreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ComparateIntent = new Intent(getActivity().getApplicationContext(), FollowActivity.class);
                startActivity(ComparateIntent);
            }
        });

        InviterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ComparateIntent = new Intent(getActivity().getApplicationContext(), InviteActivity.class);
                startActivity(ComparateIntent);
            }
        });

        AlerterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ComparateIntent = new Intent(getActivity().getApplicationContext(), AlertActivity.class);
                startActivity(ComparateIntent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static Video getInstance(){

        Video videoFragment = new Video();
        return videoFragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {

    }
}
