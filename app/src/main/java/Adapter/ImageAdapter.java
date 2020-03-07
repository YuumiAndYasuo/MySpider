package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myspider.R;

import java.util.List;

import Gson.Image;
import View.MyImageView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<Image> mImageList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View imageview;
//        TextView imagetitle;
        MyImageView image;
        public ViewHolder(@NonNull View view) {
            super(view);
            imageview=view;
//            imagetitle=(TextView)view.findViewById(R.id.imagetitle);
            image=(MyImageView)view.findViewById(R.id.image);
        }
    }

    public ImageAdapter(List<Image> imageList){
        mImageList=imageList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =holder.getAdapterPosition();
                Image image=mImageList.get(position);
                Toast.makeText(v.getContext(),"你点击了view:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =holder.getAdapterPosition();
                Image image=mImageList.get(position);
                Toast.makeText(v.getContext(),"你点击了image:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        Image image=mImageList.get(position);
//        holder.imagetitle.setText(image.getTitle());
        holder.image.setImageURL(image.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }
}
