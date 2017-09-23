package com.salman.getgithubofgeek.Activity.Activity.Activites;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.salman.getgithubofgeek.Activity.Activity.Adapters.DividerItemDecoration;
import com.salman.getgithubofgeek.Activity.Activity.Adapters.RecyclerViewAdapter;
import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.FollowersModelClass;

import com.salman.getgithubofgeek.Activity.Activity.Network.Api;
import com.salman.getgithubofgeek.Activity.Activity.Network.RetrofitApiClient;
import com.salman.getgithubofgeek.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FollowersActivity extends Fragment {

    RecyclerView recyclerView;

    ProgressDialog progressDialog;
    RecyclerViewAdapter recyclerViewAdapter;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.followers_activity, container, false);
        recyclerView = rootView.findViewById(R.id.followersRecView);
        Logger.addLogAdapter(new AndroidLogAdapter());
        textView=rootView.findViewById(R.id.no);

        progressDialog = new ProgressDialog(getContext());


        Bundle bu = getArguments();
        String username = bu.getString("NAME");
        Logger.d(username);


        Api api = RetrofitApiClient.getClient().create(Api.class);
        Call<List<FollowersModelClass>> call = api.getFollowersInfo(username);
        call.enqueue(new Callback<List<FollowersModelClass>>() {
            @Override
            public void onResponse(Call<List<FollowersModelClass>> call, Response<List<FollowersModelClass>> response) {
              //  Toast.makeText(getContext(),"Success"+response.body(),Toast.LENGTH_LONG).show();

                List<FollowersModelClass> fo = response.body();

                if (fo.size() == 0){
textView.setText("No Followers to show");                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerViewAdapter = new RecyclerViewAdapter(fo,getContext());
                recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

                recyclerView.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void onFailure(Call<List<FollowersModelClass>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });



        return rootView;
    }



}
