package fr.scootop.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.scootop.R;

public class WhoActivity extends AppCompatActivity
{
	@BindView(R.id.who_listview)
	ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		ButterKnife.bind(this);

		String[] whoChoices = getResources().getStringArray(R.array.who_choices);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_list_item_who, whoChoices);

		mListView.setAdapter(adapter);
	}
}
