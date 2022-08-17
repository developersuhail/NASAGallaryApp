package com.example.nasapictureapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.nasapictureapp.CommonClass;
import com.example.nasapictureapp.R;
import com.example.nasapictureapp.adapter.ImagesAdapter;
import com.example.nasapictureapp.databinding.ActivityMainBinding;
import com.example.nasapictureapp.interfacess.RecyclerviewItemClickInterface;
import com.example.nasapictureapp.model.PhotoModel;
import com.google.gson.Gson;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ImagesAdapter imagesAdapter;
    private ArrayList<PhotoModel> photoModelArrayList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        photoModelArrayList.addAll(CommonClass.updatePhotoData());
        Log.e("LISTDATA",new Gson().toJson(photoModelArrayList));
        setAdapter();
    }

    private void setAdapter() {
        imagesAdapter = new ImagesAdapter(MainActivity.this,"Not Full",photoModelArrayList,new RecyclerviewItemClickInterface() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(MainActivity.this,ImageFullScreenActivity.class);
                startActivity(intent);
            }
        });
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        binding.recyclerView.setAdapter(imagesAdapter);
    }


}