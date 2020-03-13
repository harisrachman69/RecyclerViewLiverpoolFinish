package id.ac.polinema.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.recyclerview.adapters.ExerciseAdapter;
import id.ac.polinema.recyclerview.models.Berita;
import id.ac.polinema.recyclerview.models.TeamLogo;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        RecyclerView recyclerView = findViewById(R.id.rv_teams);
        List<Berita> news = new ArrayList<>();
        news.add(new Berita("https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Logo-tirto-id.svg/215px-Logo-tirto-id.svg.png", "A City Living Under the Shadow", "RBC News"));
        news.add(new Berita("https://i7.pngguru.com/preview/419/795/707/logo-brand-washington-d-c-the-washington-post-font-others.jpg", "One Problem For Democratic Leaders", "NY Times"));
        news.add(new Berita("https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/BBC_News_2019.svg/150px-BBC_News_2019.svg.png","The Golden Secret to Better Breakfast", "BBC World"));
        news.add(new Berita("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT276eUqR79lA0TL21IZY4ng9S-ciAU6nmbzaj_uBMCqjwU2KWg", "How To Plan Your First Ski Vacation","NBC Nightly"));
        news.add(new Berita("https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Logo-tirto-id.svg/215px-Logo-tirto-id.svg.png","How To Sosial Isolation Is Killing Us","RBC News"));
        news.add(new Berita("https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/BBC_News_2019.svg/150px-BBC_News_2019.svg.png","Use Labels to Sort Messages in Facebook", "BBC World"));

        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(this,news);
        recyclerView.setAdapter(exerciseAdapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
    }
}
