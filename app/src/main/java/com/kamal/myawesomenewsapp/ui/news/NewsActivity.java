package com.kamal.myawesomenewsapp.ui.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import com.kamal.myawesomenewsapp.R;
import com.kamal.myawesomenewsapp.data.db.NewsDB;
import com.kamal.myawesomenewsapp.databinding.ActivityMainBinding;
import com.kamal.myawesomenewsapp.databinding.ActivityNewsBinding;
import com.kamal.myawesomenewsapp.model.NewsModel;
import com.kamal.myawesomenewsapp.utils.Constants;
import com.kamal.myawesomenewsapp.utils.SharedPrefManager;

import java.util.List;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_news);
        binding.rvNews.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        final NewsAdapter newsAdapter = new NewsAdapter(this);
        binding.rvNews.setAdapter(newsAdapter);
        NewsViewModel viewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        NewsDB newsDB = Room.databaseBuilder(NewsActivity.this, NewsDB.class, NewsDB.DATABASE_NAME).build();

        new AsyncTask<Void, Void, List<NewsModel>>() {
            @Override
            protected List<NewsModel> doInBackground(Void... voids) {
                return newsDB.newsDao().getCachedNews();
            }

            @Override
            protected void onPostExecute(List<NewsModel> newsModels) {
                super.onPostExecute(newsModels);
                newsAdapter.addNewsList(newsModels);
            }
        }.execute();

        viewModel.getNews(getIntent().getStringExtra(Constants.INTENT_SEARCH_WORD));
        viewModel.newsLiveData.observe(this, new Observer<List<NewsModel>>() {
            @Override
            public void onChanged(List<NewsModel> newsModels) {
                newsAdapter.addNewsList(newsModels);
                AsyncTask.execute(() -> {
                    newsDB.newsDao().deleteCachedList(newsDB.newsDao().getCachedNews());
                    newsDB.newsDao().cacheNews(newsModels);
                });

            }
        });
    }
}
