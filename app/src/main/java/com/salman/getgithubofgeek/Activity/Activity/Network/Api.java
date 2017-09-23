package com.salman.getgithubofgeek.Activity.Activity.Network;

import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.FollowersModelClass;
import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.ProfileInfo;
import com.salman.getgithubofgeek.Activity.Activity.ModelClasses.ReposModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

/**
 * Created by Salman on 9/19/2017.
 */

public interface Api {

    @GET("users/{userName}")
    Call<ProfileInfo> getUserData(@Path("userName") String userName);

    @GET("users/{userName}/followers")
    Call<List<FollowersModelClass>> getFollowersInfo(@Path("userName") String  userName);

    @GET("users/{userName}/repos")
    Call<List<ReposModelClass>> getrepos(@Path("userName") String userName);

}
