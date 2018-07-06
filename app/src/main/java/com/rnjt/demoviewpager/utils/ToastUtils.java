package com.rnjt.demoviewpager.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String msg, boolean longToast) {
        Toast.makeText(context, msg, longToast ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int resId, boolean longToast) {
        Toast.makeText(context, resId, longToast ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }

}
