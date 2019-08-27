package com.sourav.developer.networkcallretro;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.sourav.developer.networkcallretro.databinding.MainActivityBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    NewRecyclerAdapter adapter;
    MainActivityBinding activityBinding;
    JsonPlaceHolderApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        activityBinding.recycler.setLayoutManager(new LinearLayoutManager(this));        adapter = new NewRecyclerAdapter();
        adapter = new NewRecyclerAdapter();

        activityBinding.recycler.setHasFixedSize(true);


        Retrofit retrofit = RetrofitService.getInstance();

        api = retrofit.create(JsonPlaceHolderApi.class);
        getPosts();
        //getComments();
        //createPosts();

        //updatePost();
        //deletePost();



    }

    private void deletePost() {
        Call<Void> call = api.deletePost(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Toast.makeText(MainActivity.this, "Deleted",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void updatePost() {

        Post post = new Post(15, null, "Sourav");
        Map<String, String> headers = new HashMap<>();
        headers.put("map-Header1", "Sourav");
        headers.put("map-header2", "Android Enthusiast");
        Call<Post> call = api.patchPost(headers,5,post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()){
                    return;
                }

                adapter.setPostData(response.body());
                activityBinding.recycler.setAdapter(adapter);
                activityBinding.recycler.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void createPosts() {
        Post post = new Post(25, "New Title", "New Text");
        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "27");
        fields.put("title", "Android Developer Sourav");
        Call<Post> call = api.createPost(fields);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    return;
                }
                Post postResponse = response.body();
                activityBinding.recycler.setAdapter(adapter);
                adapter.setPostData(postResponse);
                activityBinding.recycler.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call = api.getComments("post/3/comments");
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                List<Comment> comments = response.body();

                activityBinding.recycler.setAdapter(adapter);
                adapter.setComments(comments);
                activityBinding.recycler.setHasFixedSize(true);

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void getPosts() {
        Map<String,String> parameters = new HashMap<>();
        parameters.put("userId","1");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");

        Call<List<Post>> call = api.getPosts(parameters);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()){
                    return;
                }
                List<Post> posts = response.body();

                activityBinding.recycler.setAdapter(adapter);
                adapter.setData(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }


}
