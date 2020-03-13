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

import java.util.List;

import id.ac.polinema.recyclerview.R;
import id.ac.polinema.recyclerview.models.Berita;
import id.ac.polinema.recyclerview.models.TeamLogo;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private Context context;
    private List<Berita> list;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;

    public ExerciseAdapter(Context context, List<Berita> list) {
        this.context = context;
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textJudul, textKategori;
        ImageView imageLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textJudul = itemView.findViewById(R.id.text_judul);
            textKategori = itemView.findViewById(R.id.text_category);
            imageLogo = itemView.findViewById(R.id.image_logo);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == LEFT) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_exercise, parent, false);
        } else if(viewType == RIGHT){
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_exercise_reserved, parent, false);
        }

        return new ExerciseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Berita news = list.get(position);
        Picasso.get().load(news.getGambar()).into(holder.imageLogo);
        holder.textJudul.setText(news.getJudul());
        holder.textKategori.setText(news.getKategori());


    }

    @Override
    public int getItemCount() {
        return (list !=null)?list.size():0;
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 4 == 0 || position %4==3) ? RIGHT : LEFT;
    }
}
