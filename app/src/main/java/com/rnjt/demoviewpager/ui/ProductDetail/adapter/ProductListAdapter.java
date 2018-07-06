package com.rnjt.demoviewpager.ui.ProductDetail.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rnjt.demoviewpager.R;
import com.rnjt.demoviewpager.ui.ProductDetail.ProductItemDetail;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private final ArrayList<String> arraylist;
    private final Context context;

    public ProductListAdapter(Context context) {
        this.context=context;
        arraylist=new ArrayList<String>();
       /* arraylist.add("https://img4.craftsvilla.com/C/V/CV-36286-MANUS43822633470-1529310784-Craftsvilla_1.jpg");
        arraylist.add("https://img4.craftsvilla.com/C/V/CV-35632-MCRAF92783279130-1502166436-Craftsvilla_1.jpg");
        arraylist.add("https://img4.craftsvilla.com/C/V/CV-35636-MCRAF64501951460-1522329426-Craftsvilla_1.jpg");
        arraylist.add("https://img4.craftsvilla.com/C/V/CV-36278-MCRAF67721449370-1524478918-Craftsvilla_1.jpg");*/
        arraylist.add("https://img4.craftsvilla.com/C/V/CV-35639-MCRAF60196707760-1523083565-Craftsvilla_1.jpg");
        arraylist.add("https://img4.craftsvilla.com/C/V/CV-35639-MCRAF60196707760-1523083565-Craftsvilla_1.jpg");
        arraylist.add("https://img4.craftsvilla.com/C/V/CV-35639-MCRAF60196707760-1523083565-Craftsvilla_1.jpg");
        arraylist.add("https://img4.craftsvilla.com/C/V/CV-35639-MCRAF60196707760-1523083565-Craftsvilla_1.jpg");
        arraylist.add("https://img4.craftsvilla.com/C/V/CV-35639-MCRAF60196707760-1523083565-Craftsvilla_1.jpg");

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemproduct,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(Uri.parse(arraylist.get(position))).into(holder.imgprouduct);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ProductItemDetail.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final View view;
        private final ImageView imgprouduct;

        public ViewHolder(View itemView) {
            super(itemView);
             view=itemView;
             imgprouduct=(ImageView)itemView.findViewById(R.id.imgprouduct);
        }
    }
}
