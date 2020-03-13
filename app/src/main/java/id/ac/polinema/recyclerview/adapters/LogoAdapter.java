package id.ac.polinema.recyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.recyclerview.R;
import id.ac.polinema.recyclerview.models.TeamLogo;

public class LogoAdapter extends RecyclerView.Adapter<LogoAdapter.LogoViewHolder> {

    private Context context;
    private List<TeamLogo> logoList;

    public LogoAdapter(Context context, List<TeamLogo> logoList) {
        this.context = context;
        this.logoList = logoList;
    }


    public class LogoViewHolder extends RecyclerView.ViewHolder{

        ImageView logoImage;
        TextView nameTeam;
        public LogoViewHolder(@NonNull View itemView) {
            super(itemView);
            logoImage = itemView.findViewById(R.id.image_logo);
            nameTeam = itemView.findViewById(R.id.text_name);

        }
    }


    @NonNull
    @Override
    public LogoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_logo, parent,false);
        return new LogoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogoAdapter.LogoViewHolder holder, int position) {
        TeamLogo item = logoList.get(position);
        holder.nameTeam.setText(item.getName());
        Picasso.get().load(item.getLogo()).into(holder.logoImage);
    }

    @Override
    public int getItemCount() {
        return (logoList !=null)?logoList.size():0;
    }


}
