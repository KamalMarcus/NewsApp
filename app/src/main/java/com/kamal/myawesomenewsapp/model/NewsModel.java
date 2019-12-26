package com.kamal.myawesomenewsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kamal Marcus.
 * kamalmarcus94@gmail.com
 * +201015793659
 */

public class NewsModel {
    @Expose
    @SerializedName("content")
    private String content;
    @Expose
    @SerializedName("publishedAt")
    private String publishedAt;
    @Expose
    @SerializedName("urlToImage")
    private String urltoimage;
    @Expose
    @SerializedName("url")
    private String url;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("author")
    private String author;
    @Expose
    @SerializedName("source")
    private Source source;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrltoimage() {
        return urltoimage;
    }

    public void setUrltoimage(String urltoimage) {
        this.urltoimage = urltoimage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public static class Source {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("id")
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
