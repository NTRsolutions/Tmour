package com.sismatix.tmour.Adapter;

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


import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Model.Offers_Model;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;

public class Offers_Adapter extends RecyclerView.Adapter<Offers_Adapter.MyViewHolder> {
    Context context;
    private List<Offers_Model> myoffersModels;

    public Offers_Adapter(FragmentActivity context, List<Offers_Model> myoffersModels) {
        this.context = context;
        this.myoffersModels = myoffersModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.offers_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Offers_Model offers_model = myoffersModels.get(position);

        String lang_flag = Login_preference.get_Lang_flag(context);

        if (lang_flag.equals("0")){
            holder.tv_offers_discount.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_offers_description.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_offers_price.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_orders_fake_price.setTypeface(Navigation_drawer_activity.cairo_bold);
        }else {
            holder.tv_offers_discount.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_offers_description.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_offers_price.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_orders_fake_price.setTypeface(Navigation_drawer_activity.cairo_bold);
        }

        holder.tv_orders_fake_price.setPaintFlags(holder.tv_orders_fake_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        /*holder.tv_offers_discount.setText(offers_model.getDiscount());
        holder.tv_offers_description.setText(offers_model.getDescription());
        holder.tv_offers_price.setText(offers_model.getPrice());
        holder.tv_orders_fake_price.setText(offers_model.getFake_price());
        holder.tv_orders_fake_price.setPaintFlags(holder.tv_orders_fake_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Glide.with(context).load(offers_model.getDates_image()).into(holder.iv_offers);*/

    }

    @Override
    public int getItemCount() {
        return myoffersModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_offers;
        TextView tv_offers_discount, tv_offers_description, tv_offers_price, tv_orders_fake_price;

        public MyViewHolder(@NonNull View view) {
            super(view);
            iv_offers = (ImageView)view.findViewById(R.id.iv_offers);

            tv_offers_discount = (TextView)view.findViewById(R.id.tv_offers_discount);
            tv_offers_description = (TextView)view.findViewById(R.id.tv_offers_description);
            tv_offers_price = (TextView)view.findViewById(R.id.tv_offers_price);
            tv_orders_fake_price = (TextView)view.findViewById(R.id.tv_orders_fake_price);
        }
    }
}
