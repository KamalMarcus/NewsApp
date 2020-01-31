package com.kamal.myawesomenewsapp.data.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.kamal.myawesomenewsapp.model.NewsModel;

import java.util.List;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

@Dao
public interface NewsDao {
    @Insert
    void cacheNews(List<NewsModel> newsModels);

    @Query("SELECT * FROM news")
    List<NewsModel> getCachedNews();

    @Delete
    void deleteCachedList(List<NewsModel> newsModels);
}
