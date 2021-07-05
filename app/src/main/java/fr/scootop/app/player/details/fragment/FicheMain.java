package fr.scootop.app.player.details.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import fr.scootop.R;
import fr.scootop.app.common.ImageHelper;
import fr.scootop.app.interactions.AlertActivity;
import fr.scootop.app.interactions.FollowActivity;
import fr.scootop.app.interactions.InviteActivity;
import fr.scootop.app.player.details.charts.FollowByAdapter;
import fr.scootop.app.video.utils.PlayersVideosAdapter;
import fr.scootop.data.model.user.domain.Player;

public class FicheMain extends Fragment {

    private Button InviterButton;
    private Button SuivreButton;
    private Button AlerterButton;
    private TextView tvName;
    private TextView tvFirstName;
    int[] clubList = {R.drawable.logo_tottenham, R.drawable.logo_bayern,R.drawable.logo_tottenham, R.drawable.logo_bayern,R.drawable.logo_tottenham, R.drawable.logo_bayern};
    String[] labels = {"Totthenam FC","Bayern Munich FC","Totthenam FC","Bayern Munich FC","Totthenam FC","Bayern Munich FC"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.row_fiche_player_main, container,false);
        RecyclerView recyclerView = view.findViewById(R.id.FollowedByRecyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);


        RecyclerView.Adapter recyclerViewAdapter = new FollowByAdapter(clubList, labels, getActivity().getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        SuivreButton = view.findViewById(R.id.followButton);
        InviterButton = view.findViewById(R.id.inviteButtonI);
        AlerterButton = view.findViewById(R.id.alertButton);
        tvName = view.findViewById(R.id.Name_EC);
        tvFirstName = view.findViewById(R.id.First_Name_EC);
        ImageView ivPicture = view.findViewById(R.id.avatarImageView);

        Bundle bundle = getArguments();
        Player player = bundle.getParcelable("player");
        Log.i("FICHE MAIN PLAYER",player.toString());

        tvName.setText(player.getUser().getLastName());
        tvFirstName.setText(player.getUser().getFirstName());

        Glide.with(ivPicture.getContext())
                .load(player.getPhotoUrl())
                .fitCenter()
                .placeholder(R.mipmap.ic_default_avatar)
                .into(ivPicture);


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


    public static FicheMain getInstance(){

        FicheMain ficheMainFragment = new FicheMain();
        return ficheMainFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
