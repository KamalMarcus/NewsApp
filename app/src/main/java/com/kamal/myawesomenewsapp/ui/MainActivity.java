package com.kamal.myawesomenewsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;

import com.kamal.myawesomenewsapp.R;
import com.kamal.myawesomenewsapp.databinding.ActivityMainBinding;
import com.kamal.myawesomenewsapp.model.NewsModel;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.rvNews.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        final NewsAdapter newsAdapter = new NewsAdapter(this);
        binding.rvNews.setAdapter(newsAdapter);

        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        viewModel.getNews();
        viewModel.newsLiveData.observe(this, new Observer<List<NewsModel>>() {
            @Override
            public void onChanged(List<NewsModel> newsModels) {
                newsAdapter.addNewsList(newsModels);
            }
        });
    }
}
