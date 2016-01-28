package com.example.logic_error.comingsoon;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by logic_error on 1/26/16.
 */
public class MovieDetailActivity extends AppCompatActivity {

    public String KEY_TITLE = "title";
    public String KEY_YEAR = "year";
    public String KEY_SYNOPSIS ="synopsis";
    public String KEY_POSTER = "imageurl";

    TextView synopsisText;
    CollapsingToolbarLayout collapsingToolbar;
    ImageView posterImage;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coming_soon_movie_detail_activity);

        synopsisText = (TextView)findViewById(R.id.tvSynopsis);
        posterImage = (ImageView)findViewById(R.id.movie_poster);
        collapsingToolbar =(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);

        bundle =getIntent().getExtras();

        collapsingToolbar.setTitle(bundle.getString(KEY_TITLE) + " (" + bundle.getString(KEY_YEAR) + ")");
        synopsisText.setText(bundle.getString(KEY_SYNOPSIS));
        Picasso.with(MovieDetailActivity.this).load(KEY_POSTER).into(posterImage);




    }


}
