package com.example.android.androidtask1;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by SG on 12/1/2017.
 */

public class Movie implements Serializable {

    private String mTitle;
    private String mImage;
    private int mUserRating;
    private String mReleaseDate;
    private String mPlotSynopsis;

    public Movie(String title, String image, int userRating, String releaseDate,String plotSynopsis) {
        mTitle = title;
        mImage = image;
        mUserRating = userRating;
        mReleaseDate = releaseDate;
        mPlotSynopsis = plotSynopsis;
    }

    public String getPlotSynopsis() {
        return mPlotSynopsis;
    }

    public void setPlotSynopsis(String plotSynopsis) {
        mPlotSynopsis = plotSynopsis;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public int getUserRating() {
        return mUserRating;
    }

    public void setUserRating(int userRating) {
        mUserRating = userRating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }
}
