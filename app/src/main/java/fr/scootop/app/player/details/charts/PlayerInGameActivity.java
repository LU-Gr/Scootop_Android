package fr.scootop.app.player.details.charts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fr.scootop.R;

public class PlayerInGameActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int DataPlayerI[] = {70,40,80,45,79,84,36,95,74,15,62,14,87,76,92,88};
    String Labels[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_in_game);

        recyclerView = findViewById(R.id.PlayerCharts_label);
        Labels = getResources().getStringArray(R.array.comparator_label);

        RecyclerView.Adapter InGameAdatper = new InGameAdapter(this,Labels,DataPlayerI);
        recyclerView.setAdapter(InGameAdatper);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));}
}