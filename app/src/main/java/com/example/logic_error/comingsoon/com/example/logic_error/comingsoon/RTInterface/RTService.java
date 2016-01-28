package com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.RTInterface;

/**
 * Created by logic_error on 1/11/16.
 */

import com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.models.Movie;
import com.example.logic_error.comingsoon.config.Config;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


public interface RTService {

    @GET("/lists/movies/upcoming.json?apikey=" + Config.CLIENT_ID)
    void getMoviesFromRT(
            Callback<List<Movie>> callback );

}
