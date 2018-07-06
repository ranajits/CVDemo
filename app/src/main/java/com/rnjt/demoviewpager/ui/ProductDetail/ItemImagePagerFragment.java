
package com.rnjt.demoviewpager.ui.ProductDetail;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.rnjt.demoviewpager.ui.ProductDetail.adapter.ExtendedViewPager;
import com.rnjt.demoviewpager.R;
import com.rnjt.demoviewpager.Views.CirclePageIndicator;
import com.rnjt.demoviewpager.Views.TouchImageView;

import java.util.ArrayList;
import java.util.Map;



// Dialog frament consisting on Zoom pinch and image swiping

public class ItemImagePagerFragment extends DialogFragment {
    private FrameLayout btn_cancel;
    private ArrayList<Map<String, String>> url;
    private CirclePageIndicator titleIndicator;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View list_root = inflater.inflate(R.layout.fragment_image_pager, container, false);

        url = (ArrayList<Map<String, String>>) getArguments().getSerializable("Url");

        btn_cancel = (FrameLayout) list_root.findViewById(R.id.btn_cancel);

        ExtendedViewPager mViewPager = (ExtendedViewPager) list_root.findViewById(R.id.view_pager);

        titleIndicator = (CirclePageIndicator) list_root.findViewById(R.id.pagerIndicator);

        mViewPager.setAdapter(new TouchImageAdapter(url));

        titleIndicator.setViewPager(mViewPager);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().cancel();
                getDialog().dismiss();

            }
        });

        return list_root;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Window window = getDialog().getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        window.getAttributes().windowAnimations = R.style.DialogAnimation;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.gravity = Gravity.CENTER;

        window.setAttributes(wlp);

    }

    class TouchImageAdapter extends PagerAdapter {

        ArrayList<Map<String, String>> url;

        TouchImageAdapter(ArrayList<Map<String, String>> url) {
            this.url = url;
        }

        @Override
        public int getCount() {
            return url.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            final TouchImageView img = new TouchImageView(container.getContext());

          String  s = "https://img4.craftsvilla.com/C/V/CV-35639-MCRAF60196707760-1523083565-Craftsvilla_1.jpg";
            Glide.with(getActivity()).load(Uri.parse(s)).into(img);
            container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            return img;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
