package com.example.wallpaperapp;

import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Objects;

public class FullScreen extends AppCompatActivity {
    SwipeRefreshLayout refreshLayout;
    PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        Objects.requireNonNull(getSupportActionBar()).hide();

        photoView = findViewById(R.id.photoView);
        refreshLayout = findViewById(R.id.refreshLayout);

        refreshLayout.setColorSchemeColors(Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Picasso.get().load(getIntent().getStringExtra("original")).into(photoView);
                refreshLayout.setRefreshing(false);
            }
        });
        Picasso.get().load(getIntent().getStringExtra("original")).into(photoView);
    }

    public void setWallpaper(View view) {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        Bitmap bitmap = ((BitmapDrawable) photoView.getDrawable()).getBitmap();
        try {
            wallpaperManager.setBitmap(bitmap);
            finish();
            Toast.makeText(this, "Wallpaper set successfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadWallpaper(View view) {
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(getIntent().getStringExtra("original"));
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        downloadManager.enqueue(request);
        Toast.makeText(this, "Download Starting", Toast.LENGTH_SHORT).show();
    }
}