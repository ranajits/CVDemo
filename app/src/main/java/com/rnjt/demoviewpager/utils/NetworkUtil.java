package com.rnjt.demoviewpager.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkUtil {

    public static boolean isNetworkAvailable(Context context, boolean showToast) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        if (showToast) {
            Toast.makeText(context, "Try again", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
