package com.example.android.androidtask1;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import static android.R.attr.data;
import static android.R.attr.id;
import static android.R.attr.imageButtonStyle;
import static android.R.attr.resource;
import static android.R.attr.width;

/**
 * Created by SG on 12/1/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private final LayoutInflater mInflator;
    private Context mContext;
    List<Movie> mData = Collections.emptyList();


    public MovieAdapter(Context context, List<Movie> movies) {
        mInflator =  LayoutInflater.from(context);
        mData=movies;
        mContext= context;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflator.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder = new  MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Movie currentMovie = mData.get(position);

        Picasso.with(mContext).load(currentMovie.getImage()).into(holder.movieImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Details.class);
                intent.putExtra("MovieObj",currentMovie);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImageView;


        public MyViewHolder(View itemView) {
            super(itemView);

            movieImageView = (ImageView)itemView.findViewById(R.id.image);
        }

    }
}
