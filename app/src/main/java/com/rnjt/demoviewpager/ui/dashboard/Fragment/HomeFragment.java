package com.rnjt.demoviewpager.ui.dashboard.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnjt.demoviewpager.ui.dashboard.adapter.BannerPagerAdapter;
import com.rnjt.demoviewpager.ui.ProductDetail.adapter.ProductListAdapter;
import com.rnjt.demoviewpager.R;
import com.rnjt.demoviewpager.Views.AutoScrollViewPager;
import com.rnjt.demoviewpager.Views.CirclePageIndicator;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<String> arrayList;
    private AutoScrollViewPager banner_viewpager;
    private CirclePageIndicator pagerIndicator;
    private BannerPagerAdapter adapter;
    private ProductListAdapter productadapter;
    private LinearLayoutManager layoutmangr;
    private RecyclerView rcyProduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main,container,false);
        setBanner(view);
        rcyProduct=(RecyclerView)view.findViewById(R.id.rcyProduct);
        layoutmangr=new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        rcyProduct.setLayoutManager(layoutmangr);
        productadapter=new ProductListAdapter(getContext());
        rcyProduct.setAdapter(productadapter);
        return view;

    }

    public static HomeFragment newInstance(String text) {
        HomeFragment f = new HomeFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);

        return f;
    }


    private void setBanner(View view) {

        arrayList=new ArrayList<String>();
        arrayList.add("https://img3.craftsvilla.com/image/upload/f_auto/assets1/banner-craftsvilla/cvfeeds/1530525635_sarees_hero.jpg");
        arrayList.add("https://img3.craftsvilla.com/image/upload/f_auto/assets1/banner-craftsvilla/cvfeeds/1530525335_jewellery_hero.jpg");
        arrayList.add("https://img3.craftsvilla.com/image/upload/f_auto/assets1/banner-craftsvilla/cvfeeds/1530525404_suits_hero.jpg");
        arrayList.add("https://img3.craftsvilla.com/image/upload/f_auto/assets1/banner-craftsvilla/cvfeeds/1530525381_lehenga_hero.jpg");
        banner_viewpager = (AutoScrollViewPager)view.findViewById(R.id.baner);
        banner_viewpager.startAutoScroll(4000);
        banner_viewpager.setInterval(4000);
        banner_viewpager.setCycle(true);
        banner_viewpager.setBorderAnimation(true);
        pagerIndicator=(CirclePageIndicator)view.findViewById(R.id.pagerIndicator);
        adapter = new BannerPagerAdapter(getContext(), arrayList, banner_viewpager);
        banner_viewpager.setAdapter(adapter);
        pagerIndicator.setViewPager(banner_viewpager);
    }
}
