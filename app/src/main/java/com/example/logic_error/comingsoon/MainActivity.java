package com.example.logic_error.comingsoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.RTInterface.RTService;
import com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.adapters.RTMoviesAdapter;
import com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.service.RottenTomatoes;
import com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.models.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private List<Movie> mListItems;
    private RTMoviesAdapter mAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mListItems = new ArrayList<Movie>();
        ListView listView = (ListView)findViewById(R.id.movie_list_view);
        mAdapter = new RTMoviesAdapter(this, mListItems);
        listView.setAdapter(mAdapter);

        RTService rtService = RottenTomatoes.getService();
        rtService.getMoviesFromRT(new Callback<List<Movie>>() {
            @Override
            public void success(List<Movie> movies, Response response) {
                Log.d(TAG, "First Movie title: " + movies.get(0).getTitle());

                loadMovies(movies);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error: " + error);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = mListItems.get(position);
                final View poster = findViewById(R.id.movie_poster);


                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra("title", movie.getTitle());
                intent.putExtra("year",movie.getYear());
                intent.putExtra("imageurl", movie.getLargePosterURL());
                intent.putExtra("synopsis", movie.getSynopsis());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, poster, "poster");
                startActivity(intent, options.toBundle());


            }
        });
    }
    private void loadMovies(List<Movie> movies) {
        mListItems.clear();
        mListItems.addAll(movies);
        mAdapter.notifyDataSetChanged();
    }

}
