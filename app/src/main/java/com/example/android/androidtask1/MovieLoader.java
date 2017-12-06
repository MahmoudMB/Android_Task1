package com.example.android.androidtask1;

import android.content.Context;
import android.content.Loader;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * Created by SG on 12/5/2017.
 */

public class MovieLoader extends Loader<String> {
    private String mUrl;
    private RequestQueue requestQueue;


    public MovieLoader(Context context,String url) {
        super(context);
        mUrl = url;
        requestQueue = Volley.newRequestQueue(context);
    }


    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String url) {
        mUrl = url;
    }


    @Override
    protected void onStartLoading() {

        forceLoad();

    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, mUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        deliverResult(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {}
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void deliverResult(String data) {
        super.deliverResult(data);
    }

    @Override
    public void stopLoading() {
        requestQueue.cancelAll(this);
        super.stopLoading();

    }

}
