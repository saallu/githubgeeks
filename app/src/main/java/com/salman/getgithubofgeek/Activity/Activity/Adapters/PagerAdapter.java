package com.salman.getgithubofgeek.Activity.Activity.Adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orhanobut.logger.Logger;
import com.salman.getgithubofgeek.Activity.Activity.Activites.FollowersActivity;
import com.salman.getgithubofgeek.Activity.Activity.Activites.ProfileActivity;
import com.salman.getgithubofgeek.Activity.Activity.Activites.PublicRepos;

/**
 * Created by Salman on 9/19/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    String nameString;

    public PagerAdapter(FragmentManager fm,String nameString) {
        super(fm);
        this.nameString = nameString;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProfileActivity profileActivity=new ProfileActivity();
                Bundle bundle=new Bundle();
                bundle.putString("NAME",nameString);
                profileActivity.setArguments(bundle);
                return profileActivity;
            case 1:
                FollowersActivity followersActivity=new FollowersActivity();
                Bundle bundlee=new Bundle();
                bundlee.putString("NAME",nameString);
                followersActivity.setArguments(bundlee);
                return followersActivity;
                case 2:
                PublicRepos publicRepos=new PublicRepos();
                    Bundle bundl=new Bundle();
                    bundl.putString("NAME",nameString);
                    publicRepos.setArguments(bundl);
                return publicRepos;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Profile Info";
            case 1:
                return "Followers";
            case 2:
                return "Public Repos";
        }
        return null;
    }
}