package com.example.retrofitex.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.retrofitex.Config;
import com.example.retrofitex.R;
import com.example.retrofitex.adapter.MoviesAdapter;
import com.example.retrofitex.model.movies.MovieItem;
import com.example.retrofitex.model.movies.MoviesResponse;
import com.example.retrofitex.rest.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Context context;
    private RecyclerView recyclerView = null;
    private List<MovieItem> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getApplicationContext();
        //
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        API.movies().topRated(Config.API_KEY).enqueue(new retrofit2.Callback<MoviesResponse>(){
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                Log.e(TAG,call.request().toString());
                movies=response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies,R.layout.list_item_movie,getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), ActivityMovieDetails.class);
                        intent.putExtra("movieId", movies.get(position).getId());
                        startActivity(intent);
                    }
                }, 400);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{
            private GestureDetector gestureDetector;
            private ClickListener clickListener;

            public RecyclerTouchListener(Context context,final RecyclerView recyclerView,final ClickListener clickListener){
                this.clickListener = clickListener;
                gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }


                    @Override
                    public void onLongPress(MotionEvent e) {
                        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                        if (child != null && clickListener != null) {
                            clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                        }
                    }

                });
            }


        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child=recyclerView.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clickListener!=null && gestureDetector.onTouchEvent(e)){
                clickListener.onClick(child,rv.getChildAdapterPosition(child));
            }

                return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
    public interface ClickListener{
        public void onClick(View view,int position);
        public void onLongClick(View view,int position);
    }
}