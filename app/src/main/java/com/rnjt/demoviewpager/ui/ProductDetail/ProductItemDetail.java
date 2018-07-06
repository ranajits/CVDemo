package com.rnjt.demoviewpager.ui.ProductDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.rnjt.demoviewpager.ui.ProductDetail.adapter.ImagePagerAdapter;
import com.rnjt.demoviewpager.R;
import com.rnjt.demoviewpager.Views.CirclePageIndicator;
import com.rnjt.demoviewpager.ui.Cart.CartActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductItemDetail extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager fl_imageswipe;
    private ImagePagerAdapter imageadapter;
    private CirclePageIndicator pagerIndicator;
    ArrayList<Map<String, String>> mediaarray = new ArrayList<>();
    private LinearLayout layout_cart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        setSupportActionBar(toolbar);
        layout_cart=(LinearLayout)findViewById(R.id.layout_cart);
        fl_imageswipe = (ViewPager) findViewById(R.id.viewPager);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fillArray();
        imageadapter = new ImagePagerAdapter(ProductItemDetail.this, mediaarray, getSupportFragmentManager());

        fl_imageswipe.setAdapter(imageadapter);
        pagerIndicator=(CirclePageIndicator)findViewById(R.id.pagerIndicator);
        pagerIndicator.setViewPager(fl_imageswipe);
        layout_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ProductItemDetail.this,CartActivity.class);
                startActivity(i);

            }
        });


    }

    private void fillArray() {
        Map<String, String> map = new HashMap<>();
        map.put("thumbnail","https://img4.craftsvilla.com/C/V/CV-36286-MANUS43822633470-1529310784-Craftsvilla_1.jpg");
        map.put("caption", "");
        mediaarray.add(map);

        map.put("thumbnail","https://img4.craftsvilla.com/C/V/CV-36286-MANUS43822633470-1529310784-Craftsvilla_1.jpg");
        map.put("caption", "");
        mediaarray.add(map);

        map.put("thumbnail","https://img4.craftsvilla.com/C/V/CV-36286-MANUS43822633470-1529310784-Craftsvilla_1.jpg");
        map.put("caption", "");
        mediaarray.add(map);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
