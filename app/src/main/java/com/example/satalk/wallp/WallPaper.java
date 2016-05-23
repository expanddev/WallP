package com.example.satalk.wallp;

import android.app.WallpaperManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class WallPaper extends AppCompatActivity {

    final static private int[] mColors =
            {Color.BLUE, Color.GREEN, Color.RED, Color.LTGRAY, Color.MAGENTA, Color.CYAN,
                    Color.YELLOW, Color.WHITE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_paper);

        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();
        final ImageView imageView = (ImageView) findViewById(R.id.imageview);
        imageView.setDrawingCacheEnabled(true);
        //imageView.setImageDrawable(wallpaperDrawable);

        //.....
        Button buttonSetWallpaper = (Button)findViewById(R.id.loadwallpaper);
        ImageView imageView2 = (ImageView)findViewById(R.id.imageview);
        imageView2.setImageResource(R.drawable.image1);
        //........

        Button randomize = (Button) findViewById(R.id.randomize);
        randomize.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int mColor = (int) Math.floor(Math.random() * mColors.length);
                wallpaperDrawable.setColorFilter(mColors[mColor], PorterDuff.Mode.MULTIPLY);
                imageView.setImageDrawable(wallpaperDrawable);
                imageView.invalidate();
            }
        });

        Button setWallpaper = (Button) findViewById(R.id.setwallpaper);
        setWallpaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    wallpaperManager.setBitmap(imageView.getDrawingCache());
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //---------



        buttonSetWallpaper.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());
                try {
                    myWallpaperManager.setBitmap(imageView.getDrawingCache());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }});
        //---------

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wall_paper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
