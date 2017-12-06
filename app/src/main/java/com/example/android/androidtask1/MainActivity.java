package com.example.android.androidtask1;

import android.content.Context;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;


import android.app.LoaderManager;
import android.content.Loader;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{
private static final String url = "https://api.themoviedb.org/3/movie/popular?api_key=37d390e3d5e8ee678ad4b99cebe05ad5&language=en-US";


   private  GridLayoutManager mGridLayoutManager;
    private MovieAdapter mAdapter;
    private RecyclerView mRecyclerView;
    LoaderManager mLoaderManager;
    private static final int MOVIE_LOADER_ID = 1;
    List<Movie> mMovies;
   private TextView mNoInternet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNoInternet = (TextView)findViewById(R.id.TextNoInternet);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mGridLayoutManager = new GridLayoutManager(getApplicationContext(),3,GridLayoutManager.VERTICAL,false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mGridLayoutManager);



       ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected())
       {

           mLoaderManager = getLoaderManager();
           mLoaderManager.initLoader(MOVIE_LOADER_ID, null, this);

       }
       else
        {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            mNoInternet.setText("No Internet Connection");

       }



    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new MovieLoader(this,url);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

        mMovies = Utils.extractFeatureFromJson(data);
        mAdapter = new MovieAdapter(MainActivity.this, mMovies);
        mRecyclerView.setAdapter(mAdapter);
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }


}
