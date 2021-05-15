package fr.scootop.app.player.details.charts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fr.scootop.R;
import fr.scootop.app.comparator.ComparatorAdapter;

public class Player_Charts_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    int DataPlayerI[] = {70,40,80,45,79,84,36,95,74,15,62,14,87,76,92,88,77,20};
    String Labels[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_charts);

        recyclerView = findViewById(R.id.PlayerCharts_label);
        Labels = getResources().getStringArray(R.array.Individuals_label);

        RecyclerView.Adapter ChartsAdatper = new ChartsAdapter(this,Labels,DataPlayerI);
        recyclerView.setAdapter(ChartsAdatper);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));}

}