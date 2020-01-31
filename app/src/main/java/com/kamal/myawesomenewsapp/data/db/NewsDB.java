package com.kamal.myawesomenewsapp.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kamal.myawesomenewsapp.model.NewsModel;

import java.util.List;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

@Database(entities = {NewsModel.class}, version = 2)
public abstract class NewsDB extends RoomDatabase {
    public static final String DATABASE_NAME = "newsDB";

    public abstract NewsDao newsDao();
}
