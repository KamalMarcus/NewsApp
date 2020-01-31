package com.kamal.myawesomenewsapp.ui.news;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kamal.myawesomenewsapp.data.network.ApiClient;
import com.kamal.myawesomenewsapp.data.network.NewsResponseBody;
import com.kamal.myawesomenewsapp.model.NewsModel;

import java.text.SimpleDateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

public class NewsViewModel extends ViewModel {
    MutableLiveData<List<NewsModel>> newsLiveData = new MutableLiveData<>();

    public void getNews(String searchWord) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Call<NewsResponseBody> allNews = ApiClient.getInstance().getAllNews(searchWord, simpleDateFormat.format(System.currentTimeMillis()), "publishedAt");
        allNews.enqueue(new Callback<NewsResponseBody>() {
            @Override
            public void onResponse(Call<NewsResponseBody> call, Response<NewsResponseBody> response) {
                newsLiveData.setValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NewsResponseBody> call, Throwable t) {
                System.out.println("Error " + t.getMessage());
            }
        });
    }
}
