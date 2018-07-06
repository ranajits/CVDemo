package com.rnjt.demoviewpager.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.rnjt.demoviewpager.Model.Bucket;
import com.rnjt.demoviewpager.Model.Product;

import java.util.ArrayList;

public class SessionManager {

    // Session parameters preferences string

    private static final String PREF_Product_DETAIL = "product_detail";

    // Class parameters & functions
    private static SessionManager sInstance = null;
    private Context mContext;

    public Bucket getProducts() {
        return products;
    }

    public void setProducts(Bucket products) {
        this.products = products;
    }

    Bucket products;



    private SessionManager(Context context) {
        mContext = context;
        initSessionFromPreference();
    }

    public static void init(Context context) {
        sInstance = new SessionManager(context);
    }

    public static SessionManager getInstance() {
        if (sInstance == null) {
            throw new RuntimeException("Initialize SessionManager");
        }
        return sInstance;
    }



    private SharedPreferences getSessionPreference() {
        SharedPreferences preferences = mContext.getSharedPreferences(mContext.getPackageName() + ".session", Context.MODE_PRIVATE);
        return preferences;
    }

    public void clearSession() {
        getSessionPreference().edit().clear().commit();
    }

    private void initSessionFromPreference() {
        SharedPreferences preferences = getSessionPreference();

        products = new Gson().fromJson(preferences.getString(PREF_Product_DETAIL, null), Bucket.class);


    }

    public void saveBucket(Bucket bucket){
        SharedPreferences.Editor editor = getSessionPreference().edit();
        editor.putString(PREF_Product_DETAIL, new Gson().toJson(bucket));
        editor.commit();
        initSessionFromPreference();
    }

    public void deleteBucket(){
        SharedPreferences.Editor editor = getSessionPreference().edit();
        editor.remove(PREF_Product_DETAIL);
        editor.commit();
        initSessionFromPreference();
    }


    public void addProductToBucket(Product product){
        ArrayList<Product> productsList= getProducts().getProducts();

        if(productsList!=null) {
            productsList.add(product);
        }else {
            productsList= new ArrayList<>();
            productsList.add(product);
        }
        products.setProducts(productsList);
        SharedPreferences.Editor editor = getSessionPreference().edit();
        editor.putString(PREF_Product_DETAIL, new Gson().toJson(products));
        editor.commit();
        initSessionFromPreference();
    }


    public void removeProductFromBucket(){
        ArrayList<Product> productsList= getProducts().getProducts();

        if(productsList!=null) {
            if(productsList.size()>0)
                productsList.remove(0);
        }
        products.setProducts(productsList);
        SharedPreferences.Editor editor = getSessionPreference().edit();
        editor.putString(PREF_Product_DETAIL, new Gson().toJson(products));
        editor.commit();
        initSessionFromPreference();
    }

  }
