package com.topfactory.memoapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        initData();
    }

    /**
     * 레이아웃 초기화
     */
    private void initLayout(){

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
    }

    /**
     * 데이터 초기화
     */
    private void initData(){

        List<Album> albumList = new ArrayList<Album>();

        for (int i =0; i<20; i ++){

            Album album = new Album();
            album.setTitle("씨앤블루");
            album.setArtist("정용화");
            album.setImage(R.drawable.photo);
            albumList.add(album);
        }

        mRecyclerView.setAdapter(new MyRecyclerAdapter(albumList,R.layout.activity_row));

        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

}
