package com.example.retrofitex.rest;

import com.example.retrofitex.model.movie.MovieResponse;
import com.example.retrofitex.model.movie.images.ImagesResponse;
import com.example.retrofitex.model.movies.MoviesResponse;
import com.example.retrofitex.model.search.SearchMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Movies {
    //Movie search auto complete
    @GET("/search/movie")
    Call<SearchMovieResponse> search(@Query("api_key") String apiKey, @Query("query") String query);


    //TOP RATED MOVIES
    @GET("movie/top_rated")
    Call<MoviesResponse>

    topRated(@Query("api_key") String apiKey);

    //MOVIE DETAIL
    @GET("/3/movie/{id}")
    Call<MovieResponse> movieDetails(@Path("id") int movieID, @Query("api_key") String apiKey);

    //MOVIE IMAGES
    @GET("/movie/{id}/images")
    Call<ImagesResponse> movieImages(@Query("api_key") String apiKey, @Path("id") int movieID);

}
