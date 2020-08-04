package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvm.Model.Posts;
import com.example.mvvm.Network.ApiResponse;
import com.example.mvvm.Network.JsonPlaceHolder;
import com.example.mvvm.ViewModel.PostViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostViewModel postViewModel ;
    private TextView result;
    private Button update ;
    private List<Posts> postsList ;
    private JsonPlaceHolder jsonPlaceHolder ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel =  new PostViewModel();
        result = findViewById(R.id.result);
        update = findViewById(R.id.update);
        jsonPlaceHolder = ApiResponse.getJsonResponse().create(JsonPlaceHolder.class);
        postsList = new ArrayList<>();

        postViewModel.getPosts().observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> currencyPojos) {

                postsList = currencyPojos ;
                Toast.makeText(MainActivity.this, "Change", Toast.LENGTH_SHORT).show();
                result.setText(postsList.toString());
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postViewModel.updatePost().observe(MainActivity.this, new Observer<Posts>() {
                    @Override
                    public void onChanged(Posts posts) {

                        Toast.makeText(MainActivity.this, "Posts " + posts.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}