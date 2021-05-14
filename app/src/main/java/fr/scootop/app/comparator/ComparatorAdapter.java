package fr.scootop.app.comparator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.scootop.R;

public class ComparatorAdapter extends RecyclerView.Adapter<ComparatorAdapter.MyViewHolder> {


    int DataPlayerI[];
    int DataPlayerII[];
    String Labels[];
    Context context;

    public ComparatorAdapter(Context ct,String label[], int dataPlayerI[], int dataPlayerII[]){
        context = ct;
        Labels = label;
        DataPlayerI = dataPlayerI;
        DataPlayerII = dataPlayerII;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.comparator_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComparatorAdapter.MyViewHolder holder, int position) {
    holder.DataLabel.setText(Labels[position]);
    holder.DataValueI.setText(String.valueOf(DataPlayerI[position]));
    holder.DataValueII.setText(String.valueOf(DataPlayerII[position]));
    }

    @Override
    public int getItemCount() {
        return DataPlayerII.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView DataLabel;
        TextView DataValueI;
        TextView DataValueII;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            DataLabel = itemView.findViewById(R.id.ChartsLabel);
            DataValueI = itemView.findViewById(R.id.Data_Value_PlayerI);
            DataValueII = itemView.findViewById(R.id.Data_Value_PlayerII);
        }
    }
}
