package com.example.retrofitex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitex.R;
import com.example.retrofitex.model.movie.GenreItem;

import java.util.List;

public class GenresAdapter  extends RecyclerView.Adapter<GenresAdapter.GenreViewHolder> {

    private static final String TAG = GenresAdapter.class.getSimpleName();
    private List<GenreItem> genres;
    private int rowLayout;
    private Context context;

    public GenresAdapter(List<GenreItem> genres, int rowLayout, Context context) {
        this.genres = genres;
        this.rowLayout = rowLayout;
        this.context = context;
    }



    @NonNull
    @Override
    public GenresAdapter.GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);

        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
            holder.genreName.setText(this.genres.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    public static class GenreViewHolder extends RecyclerView.ViewHolder{
            TextView genreName;
            public GenreViewHolder(View v){
                super(v);
                genreName=(TextView)v.findViewById(R.id.genreName);
            }
    }
}
