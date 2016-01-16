package com.example.logic_error.comingsoon.com.example.logic_error.comingsoon.models;

/**
 * Created by logic_error on 1/11/16.
 *
 */
import com.google.gson.annotations.SerializedName;


public class Movie{

    @SerializedName("title")
    private String mTitle;

    @SerializedName("year")
    private int mYear;

    @SerializedName("thumbnail")
    private String mPosterURL;

    @SerializedName("detailed")
    private String mLargePosterURL;

    @SerializedName("synopsis")
    private String mSynopsis;

    public String getTitle() {
        return mTitle;
    }

    public int getYear() {
        return mYear;
    }

    public String getPosterURL() {
        return mPosterURL;
    }

    public String getLargePosterURL() {
        return mLargePosterURL;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

}
