package com.salman.getgithubofgeek.Activity.Activity.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.FollowersModelClass;

import com.salman.getgithubofgeek.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Salman on 9/21/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecViewHolder> {

    List<FollowersModelClass> list;
    Context context;

    public RecyclerViewAdapter(List<FollowersModelClass> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.followers,parent,false);

        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {

        FollowersModelClass items = list.get(position);
        holder.followersTextView.setText(items.getLogin());
        Picasso.with(holder.followersImageView.getContext())
                .load(items.getAvatarUrl())
                .into(holder.followersImageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
