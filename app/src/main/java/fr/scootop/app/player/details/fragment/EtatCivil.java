package fr.scootop.app.player.details.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import fr.scootop.R;
import fr.scootop.data.model.user.domain.Player;

public class EtatCivil extends Fragment {


    private TextView tvName;
    private TextView tvFirstName;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.row_fiche_player_etat_civil, container,false);



        tvName = view.findViewById(R.id.Name_EC);
        tvFirstName = view.findViewById(R.id.First_Name_EC);
        ImageView ivPicture = view.findViewById(R.id.imageView5);
        TextView tvDescription = view.findViewById(R.id.description);

        Bundle bundle = getArguments();
        Player player = bundle.getParcelable("player");
        Log.i("FICHE MAIN PLAYER",player.toString());

        tvName.setText(player.getUser().getLastName());
        tvFirstName.setText(player.getUser().getFirstName());
        tvDescription.setText(player.getDescription());

        Glide.with(ivPicture.getContext())
                .load(player.getPhotoUrl())
                .fitCenter()
                .placeholder(R.mipmap.ic_default_avatar)
                .into(ivPicture);

        return view;
    }


    public static EtatCivil getInstance(){

        EtatCivil etatCivilFragment = new EtatCivil();
        return etatCivilFragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
