package com.sismatix.tmour.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import com.sismatix.tmour.Fregment.ProductDetails;
import com.sismatix.tmour.Model.Product_Details_images_Model;
import com.sismatix.tmour.R;

public class Product_Details_Images_Adapter extends RecyclerView.Adapter<Product_Details_Images_Adapter.MyViewHolder> {
    Context context;
    private List<Product_Details_images_Model> product_details_images_models;
    String pos;

    public Product_Details_Images_Adapter(FragmentActivity context, List<Product_Details_images_Model> product_details_images_models) {
        this.context = context;
        this.product_details_images_models = product_details_images_models;
    }

    @NonNull
    @Override
    public Product_Details_Images_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.prod_det_images_row, viewGroup, false);
        return new Product_Details_Images_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Product_Details_Images_Adapter.MyViewHolder holder, final int position) {
        final Product_Details_images_Model product_details_images_model = product_details_images_models.get(position);

        final String image_u = product_details_images_model.getProd_det_image();

        Log.e("mmmmmmm",""+image_u);

        holder.lv_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pos = String.valueOf(position);
                Toast.makeText(context,pos, Toast.LENGTH_SHORT).show();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new ProductDetails();
                Bundle b=new Bundle();
                b.putString("image_uel",image_u);
                Log.e("i_url",""+image_u);
                myFragment.setArguments(b);
                activity.getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fram_layout, myFragment).addToBackStack(null).commit();
            }
        });

        Glide.with(context).load(product_details_images_model.getProd_det_image()).into(holder.iv_offers);

    }

    @Override
    public int getItemCount() {
        return product_details_images_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_offers;
        LinearLayout lv_images;

        public MyViewHolder(@NonNull View view) {
            super(view);
            iv_offers = (ImageView)view.findViewById(R.id.iv_order);
            lv_images = (LinearLayout)view.findViewById(R.id.lv_images);
        }
    }
}