package fr.scootop.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import fr.scootop.R;


public class VideosPlayeurs extends YouTubeBaseActivity {

    Button Play;
    private YouTubePlayerView YouTubePlayeurView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);


        //YouTubePlayeurView = (YouTubePlayerView) findViewById(R.id.youtube_View);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("_dBz4dTZocg");


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        Play = (Button) findViewById(R.id.player_inviter);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                YouTubePlayeurView.initialize("AIzaSyA0u3ulUbte4DO0Ax_1cJ-gjFaiJWMSI9w", onInitializedListener);
            }
        });

        //Intent intent = getIntent();

    }

}
