package com.kamal.myawesomenewsapp.data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

public class ApiClient {
    final static String BASE_URL = "https://newsapi.org/v2/";
    static ApiClient instance = null;
    ApiInterface apiInterface;

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static ApiClient getInstance() {
        if (instance == null)
            instance = new ApiClient();
        return instance;
    }

    public Call<NewsResponseBody> getAllNews(String search, String fromDate, String sortBy) {
        return apiInterface.getNews(search, fromDate, sortBy, "a5ec0bbbc5cc463c835884804301dec2");
    }
}
