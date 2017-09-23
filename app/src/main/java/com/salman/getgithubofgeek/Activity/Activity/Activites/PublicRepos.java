package com.salman.getgithubofgeek.Activity.Activity.Activites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.salman.getgithubofgeek.Activity.Activity.Adapters.DividerItemDecoration;
import com.salman.getgithubofgeek.Activity.Activity.Adapters.RepoAdapter;
import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.ProfileInfo;
import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.ReposModelClass;
import com.salman.getgithubofgeek.Activity.Activity.Network.Api;
import com.salman.getgithubofgeek.Activity.Activity.Network.RetrofitApiClient;
import com.salman.getgithubofgeek.R;

import java.util.List;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Salman on 9/19/2017.
 */

public class PublicRepos extends Fragment {

    RecyclerView rec;
    RepoAdapter repoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.publicrepos_activity, container, false);
        rec=rootView.findViewById(R.id.recView);

        Bundle bu = this.getArguments();
        String s = bu.getString("NAME");

        Api api = RetrofitApiClient.getClient().create(Api.class);
       Call<List<ReposModelClass>> call = api.getrepos(s);
        call.enqueue(new Callback<List<ReposModelClass>>() {
            @Override
            public void onResponse(Call<List<ReposModelClass>> call, Response<List<ReposModelClass>> response) {
                List<ReposModelClass> re = response.body();
                repoAdapter = new RepoAdapter(re,getContext());
                rec.setLayoutManager(new LinearLayoutManager(getContext()));
                rec.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

                rec.setAdapter(repoAdapter);
            }

            @Override
            public void onFailure(Call<List<ReposModelClass>> call, Throwable t) {

            }
        });







        return rootView;
    }
}
