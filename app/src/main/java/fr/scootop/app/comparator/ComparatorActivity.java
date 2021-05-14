package fr.scootop.app.comparator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import fr.scootop.R;

public class ComparatorActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    int DataPlayerI[] = {70,40,80,45,79,84,36,95,74,15,62,14,87,76,92,88,77,20};
    int DataPlayerII[] = {89,40,80,45,79,84,36,95,74,15,62,14,87,76,92,88,77};
    String Labels[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparator);

        recyclerView = findViewById(R.id.Comparator_label);
        Labels = getResources().getStringArray(R.array.comparator_label);

        RecyclerView.Adapter ComparatorAdatper = new ComparatorAdapter(this,Labels,DataPlayerI,DataPlayerII);
        recyclerView.setAdapter(ComparatorAdatper);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));}
}