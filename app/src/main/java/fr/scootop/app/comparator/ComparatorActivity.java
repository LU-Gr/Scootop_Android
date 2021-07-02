package fr.scootop.app.comparator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fr.scootop.R;
import fr.scootop.data.model.user.domain.FicheJoueur;

public class ComparatorActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    int data_player_1[] = {70,40,80,45,79,84,36,95,74,15,62,14,87,76,92,88,77,20};
    int data_player_2[] = {89,40,80,45,79,84,36,95,74,15,62,14,87,76,92,88,77};
    String Labels[];
    List<FicheJoueur> players = new ArrayList<>(); //API CALL


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparator);

        recyclerView = findViewById(R.id.Comparator_label);
        Labels = getResources().getStringArray(R.array.comparator_label);

        FicheJoueur ficheJoueur_1 = players.get(0);
        FicheJoueur ficheJoueur_2 = players.get(0);

        data_player_1 = new int[]{
                0,//average
                ficheJoueur_1.getNbMatchPlayed(),
                ficheJoueur_1.getNbMatchWon(),
                ficheJoueur_1.getNbShoots(),
                ficheJoueur_1.getNbShootsInBox(),
                ficheJoueur_1.getNbPasses(),
                ficheJoueur_1.getNbSuccededPasses(),
                ficheJoueur_1.getNbSkills(),
                ficheJoueur_1.getNbSucceededSkills(),
                ficheJoueur_1.getNbBallsPlayed(),
                ficheJoueur_1.getNbBallsLost(),
                ficheJoueur_1.getNbBallsRecuperes(),
                ficheJoueur_1.getNbMinutePlayed(),
                ficheJoueur_1.getNbGoals(),
                ficheJoueur_1.getNbAssists(),
                0,//fouls
                0//fouls against ?
        };

        data_player_2 = new int[]{
                0,//average
                ficheJoueur_2.getNbMatchPlayed(),
                ficheJoueur_2.getNbMatchWon(),
                ficheJoueur_2.getNbShoots(),
                ficheJoueur_2.getNbShootsInBox(),
                ficheJoueur_2.getNbPasses(),
                ficheJoueur_2.getNbSuccededPasses(),
                ficheJoueur_2.getNbSkills(),
                ficheJoueur_2.getNbSucceededSkills(),
                ficheJoueur_2.getNbBallsPlayed(),
                ficheJoueur_2.getNbBallsLost(),
                ficheJoueur_2.getNbBallsRecuperes(),
                ficheJoueur_2.getNbMinutePlayed(),
                ficheJoueur_2.getNbGoals(),
                ficheJoueur_2.getNbAssists(),
                0,//fouls
                0//fouls against ?
        };

        RecyclerView.Adapter ComparatorAdatper = new ComparatorAdapter(this,Labels, data_player_1, data_player_2);
        recyclerView.setAdapter(ComparatorAdatper);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));}
}