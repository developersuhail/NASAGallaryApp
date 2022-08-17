package com.example.nasapictureapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.nasapictureapp.CommonClass;
import com.example.nasapictureapp.R;
import com.example.nasapictureapp.adapter.FullScreenAdapter;
import com.example.nasapictureapp.adapter.ImagesAdapter;
import com.example.nasapictureapp.databinding.ActivityImageFullScreenBinding;
import com.example.nasapictureapp.interfacess.RecyclerviewItemClickInterface;
import com.example.nasapictureapp.model.PhotoModel;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ImageFullScreenActivity extends AppCompatActivity {

    private ActivityImageFullScreenBinding binding;
    private FullScreenAdapter imagesAdapter;
    private ArrayList<PhotoModel> photoModelArrayList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_image_full_screen);

        photoModelArrayList.addAll(CommonClass.updatePhotoData());

        setAdapter();
    }

    private void setAdapter() {
        imagesAdapter = new FullScreenAdapter(ImageFullScreenActivity.this,"FULL",photoModelArrayList,new RecyclerviewItemClickInterface() {
            @Override
            public void onItemClick(int position) {

            }
        });
        binding.recyclerViewHorizontel.setHasFixedSize(true);
        binding.recyclerViewHorizontel.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        binding.recyclerViewHorizontel.setAdapter(imagesAdapter);
    }

}