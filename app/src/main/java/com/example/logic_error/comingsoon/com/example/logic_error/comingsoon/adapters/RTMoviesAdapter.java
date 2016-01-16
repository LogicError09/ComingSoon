package com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.logic_error.comingsoon.R;
import com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by logic_error on 1/11/16.
 */
public class RTMoviesAdapter extends BaseAdapter {

        private Context mContext;
        private List<Movie> mMovies;

        public RTMoviesAdapter(Context context, List<Movie> movies) {
            mContext = context;
            mMovies = movies;
        }

        @Override
        public int getCount() {
            return mMovies.size();
        }

        @Override
        public Movie getItem(int position) {
            return mMovies.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Movie movie = getItem(position);

            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_item, parent, false);
                holder = new ViewHolder();
                holder.movieImageView = (ImageView) convertView.findViewById(R.id.movie_photo);
                holder.titleTextView = (TextView) convertView.findViewById(R.id.movie_title);
                holder.yearTextView = (TextView) convertView.findViewById(R.id.movie_date);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.titleTextView.setText(movie.getTitle());

            // Trigger the download of the URL asynchronously into the image view.
            Picasso.with(mContext).load(movie.getPosterURL()).into(holder.movieImageView);

            return convertView;
        }

        static class ViewHolder {
            ImageView movieImageView;
            TextView titleTextView, yearTextView;

        }

}
