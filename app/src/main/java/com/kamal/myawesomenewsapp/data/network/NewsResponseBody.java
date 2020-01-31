package com.kamal.myawesomenewsapp.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kamal.myawesomenewsapp.model.NewsModel;

import java.util.List;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

public class NewsResponseBody {
    @Expose
    @SerializedName("articles")
    private List<NewsModel> articles;


    public List<NewsModel> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsModel> articles) {
        this.articles = articles;
    }

}
