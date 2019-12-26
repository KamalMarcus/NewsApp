package com.kamal.myawesomenewsapp.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

public interface ApiInterface {
    @GET("everything")
    Call<NewsResponseBody>getNews(@Query("q")String search,@Query("from")String fromDate,@Query("sortBy")String sortBy,@Query("apiKey")String apiKey);
}
