package com.salman.getgithubofgeek.Activity.Activity.ModelClasses;


import com.google.gson.annotations.SerializedName;

public class ProfileInfo {

    @SerializedName("name")
    String name;
    @SerializedName("company")
    String company;
    @SerializedName("blog")
    String blog;
    @SerializedName("bio")
    String bio;
    @SerializedName("avatar_url")
    String avatar_url;
    @SerializedName("location")
    String location;

    @SerializedName("followers")
    int followers;
    @SerializedName("public_repos")
    int public_repos;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }



    public ProfileInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public ProfileInfo(String name, String company, String blog, String bio, int followers, int public_repos) {

        this.name = name;
        this.company = company;
        this.blog = blog;
        this.bio = bio;
        this.followers = followers;
        this.public_repos = public_repos;
    }
}