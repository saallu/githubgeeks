package com.salman.getgithubofgeek.Activity.Activity.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.FollowersModelClass;
import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.ReposModelClass;
import com.salman.getgithubofgeek.R;

import java.util.List;

/**
 * Created by Salman on 9/22/2017.
 */

public class RepoAdapter extends RecyclerView.Adapter<RipoViewHolder> {

    List<ReposModelClass> list;
    Context context;

    public RepoAdapter(List<ReposModelClass> list,Context context) {
        this.list = list;
        this.context=context;
    }


    @Override
    public RipoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_layout,parent,false);

        return new RipoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RipoViewHolder holder, int position) {

        ReposModelClass re = list.get(position);
        holder.repoName.setText(re.getName());
        holder.language.setText(re.getLanguage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
