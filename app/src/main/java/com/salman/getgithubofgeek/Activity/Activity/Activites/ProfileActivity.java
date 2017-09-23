package com.salman.getgithubofgeek.Activity.Activity.Activites;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.salman.getgithubofgeek.Activity.Activity.Adapters.PagerAdapter;
import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.Fail;
import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.ProfileInfo;
import com.salman.getgithubofgeek.Activity.Activity.Network.Api;
import com.salman.getgithubofgeek.Activity.Activity.Network.RetrofitApiClient;

import com.salman.getgithubofgeek.R;
import com.squareup.picasso.Picasso;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends Fragment {

    ImageView imageView;
    TextView name;
    TextView bio;
    TextView company;
    TextView website;
    TextView location;

    TextView companyView;
    TextView websiteView;
    TextView locationView;

    String na;
    ProgressDialog progressDialog;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_profile, container, false);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Fetching Data, Please Wait !");
        progressDialog.show();

        name = rootView.findViewById(R.id.name);
        bio = rootView.findViewById(R.id.bio);
        imageView=rootView.findViewById(R.id.githubImageView);
        company = rootView.findViewById(R.id.company);
        website = rootView.findViewById(R.id.website);
        location=rootView.findViewById(R.id.location);
        companyView=rootView.findViewById(R.id.companyView);
        websiteView=rootView.findViewById(R.id.webView);
        locationView=rootView.findViewById(R.id.locationView);
        view = rootView.findViewById(R.id.view);
        view.setVisibility(View.GONE);


        Logger.addLogAdapter(new AndroidLogAdapter());

        //getting data from MainActivity
        Bundle bundle = this.getArguments();
        String username = bundle.getString("NAME");

        Api api = RetrofitApiClient.getClient().create(Api.class);
        Call<ProfileInfo> call = api.getUserData(username);
        call.enqueue(new Callback<ProfileInfo>() {
            @Override
            public void onResponse(Call<ProfileInfo> call, Response<ProfileInfo> response) {
                if (response.code() == 200) {
                    progressDialog.dismiss();
                    view.setVisibility(View.VISIBLE);

                    final ProfileInfo profileInfo = response.body();

                    companyView.setText("I work in");
                    websiteView.setText("Visit my Website");
                    locationView.setText("I live in");


                    Picasso.with(getContext()).load(profileInfo.getAvatar_url()).into(imageView);
                    name.setText(profileInfo.getName());
                    bio.setText(profileInfo.getBio());
                    company.setText(profileInfo.getCompany());
                    website.setText(profileInfo.getBlog());
                    location.setText(profileInfo.getLocation());


                    //showing website on myblog textView
                    final String web = profileInfo.getBlog();
                    website.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + web)));
                        }
                    });
                }else {
                    progressDialog.setTitle("No user found");
                    progressDialog.setMessage("Please try again later");
                    Toast.makeText(getContext(),"User not found",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ProfileInfo> call, Throwable t) {

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
        return rootView;
    }




}