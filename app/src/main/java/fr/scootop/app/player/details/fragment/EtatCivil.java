package fr.scootop.app.player.details.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.scootop.R;

public class EtatCivil extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.row_fiche_player_etat_civil, container,false);
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
