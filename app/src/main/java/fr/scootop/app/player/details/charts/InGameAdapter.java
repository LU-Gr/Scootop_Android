package fr.scootop.app.player.details.charts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.scootop.R;

public class InGameAdapter extends RecyclerView.Adapter<InGameAdapter.MyViewHolder> {
    int DataPlayerI[];
    String Labels[];
    Context context;

    public InGameAdapter(Context ct,String label[], int dataPlayerI[]){
        context = ct;
        Labels = label;
        DataPlayerI = dataPlayerI;
    }
    @NonNull
    @Override
    public InGameAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.in_game_player_row,parent,false);
        return new InGameAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InGameAdapter.MyViewHolder holder, int position) {
        holder.DataLabel.setText(Labels[position]);
        holder.DataValueI.setText(String.valueOf(DataPlayerI[position]));
    }

    @Override
    public int getItemCount() {
        return DataPlayerI.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView DataLabel;
        TextView DataValueI;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            DataLabel = itemView.findViewById(R.id.ChartsLabel);
            DataValueI = itemView.findViewById(R.id.Data_Value_PlayerI);
        }
    }



}
