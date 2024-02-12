package com.example.retrofitex.model.configuration;

import android.provider.MediaStore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigurationResponse {
    @SerializedName("images")
    @Expose
    private Images images;

    @SerializedName("change_keys")
    @Expose
    private List<String> changeKeys=null;

    public Images getImages(){
        return images;
    }
    public void setImages(Images image){
        this.images=images;
    }
    public List<String> getChangeKeys(){
       return changeKeys;
    }
    public void setChangeKeys(List<String> changeKeys){
        this.changeKeys=changeKeys;
    }

    @Override
    public String toString() {
        return "ConfigurationResponse{" +
                "images=" + images +
                ", changeKeys=" + changeKeys +
                '}';
    }

}
