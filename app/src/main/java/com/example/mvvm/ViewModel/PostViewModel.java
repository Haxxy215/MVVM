package com.example.mvvm.ViewModel;

import com.example.mvvm.Model.Posts;
import com.example.mvvm.Network.PostRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class PostViewModel {

    private PostRepository postRepository;
    private MutableLiveData<List<Posts>> mutableLiveData;
    private MutableLiveData<Posts> updatePost;

    public PostViewModel(){
        postRepository = new PostRepository();
    }

    public LiveData<List<Posts>> getPosts() {
        if(mutableLiveData==null){
            mutableLiveData = postRepository.requestPosts();
        }
        return mutableLiveData;
    }

    public LiveData<Posts> updatePost() {
        if(updatePost==null){
            updatePost = postRepository.updatePost();
        }
        return updatePost;
    }

}
