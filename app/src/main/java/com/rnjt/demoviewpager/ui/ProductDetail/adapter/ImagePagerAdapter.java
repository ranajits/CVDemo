/*
 * Copyright 2014 trinea.cn All right reserved. This software is the confidential and proprietary
 * information of trinea.cn ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license agreement you
 * entered into with trinea.cn.
 */

package com.rnjt.demoviewpager.ui.ProductDetail.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rnjt.demoviewpager.R;
import com.rnjt.demoviewpager.ui.ProductDetail.ItemImagePagerFragment;
import com.rnjt.demoviewpager.ui.ProductDetail.ProductItemDetail;
import com.rnjt.demoviewpager.utils.AppConfig;
import com.rnjt.demoviewpager.utils.CVUtilities;

import java.util.ArrayList;
import java.util.Map;

public class ImagePagerAdapter extends PagerAdapter {

    private final float screenWidth;

    FragmentManager fragmentManager;
    private Context context;
    private ArrayList<Map<String, String>> imageIdList;
    private int size;

    public ImagePagerAdapter(Context context, ArrayList<Map<String, String>> imageIdList,
                             FragmentManager fragmentManager) {
        this.context = context;
        this.imageIdList = imageIdList;
        this.size = imageIdList.size();

        this.fragmentManager = fragmentManager;

        screenWidth = CVUtilities.getScreenWidth((ProductItemDetail) context);

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
    public View instantiateItem(ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.details_image_layout_view, container, false);

        final ImageView img = (ImageView) view.findViewById(R.id.session_photo);

        try {
            Glide.with(context).load(Uri.parse(AppConfig.getImageFiles().get(0))).into(img);

        } catch (Exception e) {

        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ItemImagePagerFragment frag = new ItemImagePagerFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Url", imageIdList);

                frag.setArguments(bundle);
                frag.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
                frag.show(fragmentManager, "ShopImagePagerFragment");

            }
        });

        container.addView(view);
        return view;
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
        container   .removeView((View) object);
    }


}
