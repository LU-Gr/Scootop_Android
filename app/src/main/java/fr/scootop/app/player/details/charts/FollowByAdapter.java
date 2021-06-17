package fr.scootop.app.player.details.charts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.scootop.R;

public class FollowByAdapter extends RecyclerView.Adapter<FollowByAdapter.MyViewHolder> {

    int ClubList[] = {R.drawable.logo_tottenham, R.drawable.logo_tottenham};
    String Labels[];
    Context context;

    public FollowByAdapter(int[] clubList, String[] labels, Context context) {
        ClubList = clubList;
        Labels = labels;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.followed_by_thumbs_label_row,parent,false);
        return new FollowByAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowByAdapter.MyViewHolder holder, int position) {

        holder.ClubLabel.setText(Labels[position]);
        holder.Clublogo.setImageResource(ClubList[position]);

    }

    @Override
    public int getItemCount() {
        return ClubList.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ClubLabel;
        ImageView Clublogo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ClubLabel = itemView.findViewById(R.id.FollowByClubLabel);
            Clublogo = itemView.findViewById(R.id.FollowByClubthumbs);
        }
    }


}
