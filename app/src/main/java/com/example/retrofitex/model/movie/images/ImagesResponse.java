package com.example.retrofitex.model.movie.images;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImagesResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("backdrops")
    @Expose
    private List<BackDrop> backdrops = null;
    @SerializedName("posters")
    @Expose
    private List<Poster> posters = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BackDrop> getBackDrops() {
        return backdrops;
    }

    public void setBackDrops(List<BackDrop> backdrops) {
        this.backdrops = backdrops;
    }

    public List<Poster> getPosters() {
        return posters;
    }

    public void setPosters(List<Poster> posters) {
        this.posters = posters;
    }

    @Override
    public String toString() {
        return "ImagesResponse{" +
                "id=" + id +
                ", backdrops=" + backdrops +
                ", posters=" + posters +
                '}';
    }


}
