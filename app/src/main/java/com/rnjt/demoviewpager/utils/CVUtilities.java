package com.rnjt.demoviewpager.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;

public  class CVUtilities {
    public static float getScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float pxWidth = outMetrics.widthPixels - pxFromDp(activity.getApplicationContext(),15) ;
        return pxWidth;
    }
    public static float getScreenHeight(Context context) {
        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float pxWidth = outMetrics.heightPixels;// - pxFromDp(context,15);
        return pxWidth;
    }

    public static float getScreenWidth(Context context) {
        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float pxWidth = outMetrics.widthPixels - pxFromDp(context,15);
        return pxWidth;
    }
    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
