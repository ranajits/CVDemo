/*
 * Copyright 2014 trinea.cn All right reserved. This software is the confidential and proprietary
 * information of trinea.cn ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license agreement you
 * entered into with trinea.cn.
 */

package com.rnjt.demoviewpager.ui.dashboard.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rnjt.demoviewpager.R;
import com.rnjt.demoviewpager.Views.AutoScrollViewPager;

import java.util.ArrayList;

public class BannerPagerAdapter extends PagerAdapter {


    private final ArrayList<String> arrayList;
    private Context context;

    private int size;
    AutoScrollViewPager banner_viewpage;
    public BannerPagerAdapter(Context context
            , ArrayList<String> arrayList, AutoScrollViewPager banner_viewpager) {
        this.context = context;

        this.size = 4;
        this.arrayList = arrayList;
        this.banner_viewpage=banner_viewpager;


    }

    @Override
    public int getCount() {
        return size;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public View instantiateItem(final ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.detail_image_view, container, false);

        final ImageView img = (ImageView) view.findViewById(R.id.session_photo);

        String s;

        try {

            s = arrayList.get(position);

        } catch (Exception e) {
            s = "http://";
        }

        try {


            img.setScaleType(ImageView.ScaleType.FIT_XY);

            Glide.with(context).load(Uri.parse(s)).into(img);

        } catch (Exception e) {
            e.printStackTrace();
        }


        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                resetBannerInterval(banner_viewpage);

                return false;
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  /*
                  * Call Clevertapapi
                  * */




            }
        });

        container.addView(view);
        return view;
    }

    void resetBannerInterval(AutoScrollViewPager banner_viewpage)
    {
        banner_viewpage.setInterval(4000);

    }



    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    private int getPosition(int position) {
        return position;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
