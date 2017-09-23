package com.salman.getgithubofgeek.Activity.Activity.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.salman.getgithubofgeek.R;

/**
 * Created by Salman on 9/22/2017.
 */

public class RipoViewHolder extends RecyclerView.ViewHolder {

    TextView repoName ,language;

    public RipoViewHolder(View itemView) {
        super(itemView);
        repoName =  itemView.findViewById(R.id.repoName);
        language = itemView.findViewById(R.id.language);
    }
}
