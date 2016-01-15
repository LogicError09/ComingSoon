package com.example.logic_error.comingsoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
    private void loadMovies(List<Movie> movies) {
        mListItems.clear();
        mListItems.addAll(movies);
        mAdapter.notifyDataSetChanged();
    }
}
