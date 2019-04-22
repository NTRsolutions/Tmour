package tmour.sismatix.com.tmour.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;
import tmour.sismatix.com.tmour.Model.Offers_Model;
import tmour.sismatix.com.tmour.Model.Product_Details_images_Model;
import tmour.sismatix.com.tmour.R;

public class Product_Details_Images_Adapter extends RecyclerView.Adapter<Product_Details_Images_Adapter.MyViewHolder> {
    Context context;
    private List<Product_Details_images_Model> product_details_images_models;

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
    public void onBindViewHolder(@NonNull Product_Details_Images_Adapter.MyViewHolder holder, int position) {
        final Product_Details_images_Model product_details_images_model = product_details_images_models.get(position);

        /*Glide.with(context).load(product_details_images_model.getProd_det_image()).into(holder.iv_offers);*/

    }

    @Override
    public int getItemCount() {
        return product_details_images_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_offers;

        public MyViewHolder(@NonNull View view) {
            super(view);
            iv_offers = (ImageView)view.findViewById(R.id.iv_offers);
        }
    }
}