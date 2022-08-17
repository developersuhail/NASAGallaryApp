package com.example.nasapictureapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nasapictureapp.R;
import com.example.nasapictureapp.databinding.PhotoItemBinding;
import com.example.nasapictureapp.interfacess.RecyclerviewItemClickInterface;
import com.example.nasapictureapp.model.PhotoModel;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {


    private Context context;
    private ArrayList<PhotoModel> PhotoModelArrayList;

    private RecyclerviewItemClickInterface recyclerviewItemClickInterface;
    private String from;
    public ImagesAdapter(Context context,String from, ArrayList<PhotoModel> PhotoModelArrayList,RecyclerviewItemClickInterface recyclerviewItemClickInterface) {

        this.context = context;
        this.from = from;
        this.PhotoModelArrayList = PhotoModelArrayList;
        this.recyclerviewItemClickInterface=recyclerviewItemClickInterface;
    }

    @NonNull
    @Override
    public ImagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                View view = layoutInflater.inflate(R.layout.photo_item, parent, false);

        ImagesAdapter.ViewHolder viewHolder = new ImagesAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ImagesAdapter.ViewHolder holder, final int position) {

//        if (PhotoModelArrayList.get(position).getUrl()!=null)
//        holder.photoItemBinding.imgPhoto.setImageURI(Uri.parse(PhotoModelArrayList.get(position).getUrl()));
        if (PhotoModelArrayList.get(position).getUrl()!=null) {
            Glide.with(context).load(PhotoModelArrayList.get(position).getUrl())
                    .placeholder(R.drawable.plceholder)
                    .into(holder.photoItemBinding.imgPhoto);
        }

        holder.itemView.setOnClickListener(v ->
                recyclerviewItemClickInterface.onItemClick(position)
        );

    }

    @Override
    public int getItemCount() {
       return PhotoModelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        PhotoItemBinding photoItemBinding;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            photoItemBinding = DataBindingUtil.bind(itemView);
        }
    }
}