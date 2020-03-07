package com.example.myspider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Adapter.ImageAdapter;
import Gson.Album;
import Gson.Image;
import Utils.HttpUtil;
import Utils.Utility;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import View.MyImageView;

public class MainActivity extends AppCompatActivity {
    //MyImageView myImageView;
    RecyclerView recyclerView;
    private List<Image> imageList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myImageView=(MyImageView)findViewById(R.id.image1);


        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        Button getimage=findViewById(R.id.get_image);
        getimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageUrl("https://handmaid.cn/loadPic?searchKey=");
            }
        });
    }

    public void getImageUrl(String address){
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"加载失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseText=response.body().string();
                final List<Album> albumList= Utility.handleAlbumResponse(responseText);
                Log.d("aaaaaa", responseText);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (albumList!=null){
                            for (Album album:albumList){
                                Image image=new Image(album.getOriginUrl());
                                imageList.add(image);


                            }
                            ImageAdapter adapter=new ImageAdapter(imageList);
                            recyclerView.setAdapter(adapter);
                        }

                    }
                });

            }
        });
    }
}
