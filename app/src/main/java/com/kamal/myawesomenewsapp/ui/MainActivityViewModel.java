package com.kamal.myawesomenewsapp.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kamal.myawesomenewsapp.data.ApiClient;
import com.kamal.myawesomenewsapp.data.NewsResponseBody;
import com.kamal.myawesomenewsapp.model.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<List<NewsModel>>newsLiveData=new MutableLiveData<>();

    public void getNews(){
        Call<NewsResponseBody> allNews = ApiClient.getInstance().getAllNews("مصر", "2019-12-26", "publishedAt");
        allNews.enqueue(new Callback<NewsResponseBody>() {
            @Override
            public void onResponse(Call<NewsResponseBody> call, Response<NewsResponseBody> response) {
                newsLiveData.setValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NewsResponseBody> call, Throwable t) {

            }
        });
    }
}
