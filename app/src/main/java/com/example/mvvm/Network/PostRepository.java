package com.example.mvvm.Network;

import android.util.Log;
import android.widget.TextView;

import com.example.mvvm.Model.Posts;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private JsonPlaceHolder jsonPlaceHolder ;

    public PostRepository() {
        jsonPlaceHolder = ApiResponse.getJsonResponse().create(JsonPlaceHolder.class);
    }

    public MutableLiveData<List<Posts>> requestPosts() {
        final MutableLiveData<List<Posts>> mutableLiveData = new MutableLiveData<>();

        jsonPlaceHolder.getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful() && response.body()!=null ) {
                    Log.e("Message", "Posts Size="+response.body().size() );
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Log.e("Message", "Message : ="+t.getMessage() );
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<Posts> updatePost() {
        final MutableLiveData<Posts> mutableLiveData = new MutableLiveData<>();

        jsonPlaceHolder.updatePost(new Posts("Husnain" , null , 2)).enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
