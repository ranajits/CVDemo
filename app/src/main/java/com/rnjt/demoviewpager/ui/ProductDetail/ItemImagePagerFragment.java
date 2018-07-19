
package com.rnjt.demoviewpager.ui.ProductDetail;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.rnjt.demoviewpager.R;
import com.rnjt.demoviewpager.Views.CirclePageIndicator;
import com.rnjt.demoviewpager.ui.ProductDetail.adapter.ExtendedViewPager;
import com.rnjt.demoviewpager.utils.AppConfig;

import java.util.ArrayList;



// Dialog frament consisting on Zoom pinch and image swiping

public class ItemImagePagerFragment extends DialogFragment {
    private FrameLayout btn_cancel;
    //private ArrayList<Map<String, String>> url;
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

      //  url = (ArrayList<Map<String, String>>) getArguments().getSerializable("Url");

        btn_cancel = (FrameLayout) list_root.findViewById(R.id.btn_cancel);

        ExtendedViewPager mViewPager = (ExtendedViewPager) list_root.findViewById(R.id.view_pager);

        titleIndicator = (CirclePageIndicator) list_root.findViewById(R.id.pagerIndicator);

        mViewPager.setAdapter(new TouchImageAdapter(new ArrayList<String>()));

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

        ArrayList<String> url;

        TouchImageAdapter(ArrayList<String> url) {
            this.url = AppConfig.getImageFiles();
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {

            LayoutInflater inflater = (LayoutInflater) getActivity()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.details_image, container, false);
            container.addView(view);
            return  view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
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

         }
}
