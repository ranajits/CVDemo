package com.rnjt.demoviewpager.ui.Cart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rnjt.demoviewpager.Model.Product;
import com.rnjt.demoviewpager.R;
import com.rnjt.demoviewpager.manager.SessionManager;
import com.rnjt.demoviewpager.ui.OrderDetail.OrderActivity;
import com.rnjt.demoviewpager.utils.AppConfig;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends AppCompatActivity {


    @BindView(R.id.imgRemove)
    ImageView imgRemove;
    @BindView(R.id.imgProduct)
    ImageView imgProduct;
    @BindView(R.id.imgAdd)
    ImageView imgAdd;

    @BindView(R.id.txtTotal1)
    TextView txtTotal1;
    @BindView(R.id.txtTotal2)
    TextView txtTotal2;
    @BindView(R.id.txtQty)
    TextView txtQty;
    @BindView(R.id.txtShipping)
    TextView txtShipping;
    @BindView(R.id.txtSubTotal)
    TextView txtSubTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Glide.with(this).load(Uri.parse(AppConfig.getImageFiles().get(0))).into(imgProduct);
        Product product= new Product();
        product.setPrice(1221);
        SessionManager.getInstance().addProductToBucket(product);
        updateUI();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        SessionManager.getInstance().clearSession();

    }

    @OnClick({R.id.txtProceed, R.id.txtProceed1})
    public void onClicks() {
        startActivity(new Intent(this, OrderActivity.class));
        finish();
    }


    @OnClick({R.id.imgAdd, R.id.imgRemove})
    public void addRemoveProducts(View view){

        switch (view.getId()){
            case R.id.imgAdd:
                Product product= new Product();
                product.setPrice(1221);
                SessionManager.getInstance().addProductToBucket(product);
                updateUI();

                break;

            case R.id.imgRemove:

                ArrayList<Product> products= SessionManager.getInstance().getBucket().getProducts();
                if(products.size()>1){
                    SessionManager.getInstance().removeProductFromBucket();
                    updateUI();
                }else {
                    finish();
                }
                break;
        }
    }

    private void updateUI(){

        ArrayList<Product> products= SessionManager.getInstance().getBucket().getProducts();
        int subTotal=0, qty=0;
        for (int i= 0; i< products.size(); i++){
            subTotal= subTotal+ products.get(i).getPrice();
            qty= qty+1;

        }
        txtSubTotal.setText("Rs. "+subTotal);
        txtQty.setText(""+qty);
        txtShipping.setText("Rs. 30");
        txtTotal1.setText("Rs. "+ (subTotal+30));
        txtTotal2.setText("Rs. "+ (subTotal+30));


    }

}
