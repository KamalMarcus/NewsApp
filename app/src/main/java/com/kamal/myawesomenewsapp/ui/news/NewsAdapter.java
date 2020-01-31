package com.kamal.myawesomenewsapp.ui.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kamal.myawesomenewsapp.R;
import com.kamal.myawesomenewsapp.databinding.ListItemNewsBinding;
import com.kamal.myawesomenewsapp.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<NewsModel> newsList = new ArrayList<>();
    Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemNewsBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_news, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModel newsModel = newsList.get(position);
        holder.binding.tvTitle.setText(newsModel.getTitle());
        holder.binding.tvContent.setText(newsModel.getDescription());
        Glide.with(context).load(newsModel.getUrltoimage()).into(holder.binding.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListItemNewsBinding binding;

        public ViewHolder(ListItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void addNewsList(List<NewsModel> newsList) {
        this.newsList = newsList; //1234567
        notifyDataSetChanged();
    }
}
