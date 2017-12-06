package com.example.android.androidtask1;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.console;
import static java.lang.System.in;

/**
 * Created by SG on 12/1/2017.
 */

public  class Utils {

    private Utils() {


    }


    public static   List<Movie> extractFeatureFromJson(String Url)
    {

        if (Url.isEmpty())
            return null;

        ArrayList<Movie> movies = new ArrayList<Movie>();


        try {
            JSONObject initial = new JSONObject(Url);
            JSONArray moviesArray = initial.getJSONArray("results");
            for (int i = 0; i < moviesArray.length(); i++)
            {
                JSONObject currentMovie = moviesArray.getJSONObject(i);
                String title = currentMovie.getString("original_title");
                int userRating = currentMovie.getInt("vote_average");
                String releaseDate = currentMovie.getString("release_date");
              String plotSynopsis  =currentMovie.getString("overview");
               String imageUrl = "https://image.tmdb.org/t/p/w500"+currentMovie.getString("poster_path");


                Movie movie  = new Movie(title,imageUrl,userRating,releaseDate,plotSynopsis);
                movies.add(movie);
            }
        }
        catch (JSONException ex)
        {
        Log.v("Extract Features","",ex);
        }

return movies;

    }





}
