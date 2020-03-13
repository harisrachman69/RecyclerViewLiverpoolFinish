package id.ac.polinema.recyclerview.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.ac.polinema.recyclerview.R;
import id.ac.polinema.recyclerview.ViewTypeActivity;
import id.ac.polinema.recyclerview.models.TeamLogo;

public class ReversedLogoAdapter extends RecyclerView.Adapter<ReversedLogoAdapter.ViewHolder> {

    private Context context;
    private List<TeamLogo> list;
    private static final int LOGO_LEFT = 1;
    private static final int LOGO_RIGHT = 2;

    public ReversedLogoAdapter(Context context, List<TeamLogo> list) {
        this.context = context;
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView teamName;
        ImageView imageLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.text_name);
            imageLogo = itemView.findViewById(R.id.image_logo);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == LOGO_LEFT) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_logo, parent, false);
        } else if (viewType == LOGO_RIGHT) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_logo_reversed, parent, false);
        }
        return new ReversedLogoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReversedLogoAdapter.ViewHolder holder, int position) {
        TeamLogo teams = list.get(position);
        Picasso.get().load(teams.getLogo()).into(holder.imageLogo);
        holder.teamName.setText(teams.getName());

    }

    @Override
    public int getItemCount() {
        return (list !=null)?list.size():0;
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 2 == 0) ? LOGO_RIGHT : LOGO_LEFT;
    }


}
