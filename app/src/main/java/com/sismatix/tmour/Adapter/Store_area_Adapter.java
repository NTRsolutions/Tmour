package com.sismatix.tmour.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Fregment.OrderDetails;
import com.sismatix.tmour.Model.Store_area_Model;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;


public class Store_area_Adapter extends RecyclerView.Adapter<Store_area_Adapter.MyViewHolder> {

    private List<Store_area_Model> model;
    private Context context;
    LayoutInflater inflater;
    public static String name, image;


    public Store_area_Adapter(Context context, List<Store_area_Model> model) {
        this.context = context;
        this.model = model;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Store_area_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.store_row, parent, false);
        return new Store_area_Adapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(Store_area_Adapter.MyViewHolder holder, final int position) {

        final Store_area_Model store_model = model.get(position);

        String lang_flag = Login_preference.get_Lang_flag(context);

        if (lang_flag.equals("0")){
            holder.tv_store_delivery.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_store_minimum.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_store_avg_min.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_store_avg_text.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_store_pay_method.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_pay_store_text.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_rating_count.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_store_desc.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_store_new.setTypeface(Navigation_drawer_activity.cairo_bold);
            holder.tv_store_name.setTypeface(Navigation_drawer_activity.cairo_bold);
        }else {
            holder.tv_store_delivery.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_store_minimum.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_store_avg_min.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_store_avg_text.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_store_pay_method.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_pay_store_text.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_rating_count.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_store_desc.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_store_new.setTypeface(Navigation_drawer_activity.roboto_bold);
            holder.tv_store_name.setTypeface(Navigation_drawer_activity.roboto_bold);
        }

        holder.lv_store_area_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new OrderDetails();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fram_layout, myFragment).addToBackStack(null).commit();*/
            }
        });

        LayerDrawable star = (LayerDrawable) holder.ratingBar.getProgressDrawable();
        star.getDrawable(2).setColorFilter(Color.parseColor("#F49F31"), PorterDuff.Mode.SRC_ATOP);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv_store_image_area;
        LinearLayout lv_store_area_click,lv_new;
        RatingBar ratingBar;
        TextView tv_store_delivery,tv_store_minimum,tv_store_avg_min,tv_store_avg_text,
                tv_store_pay_method,tv_pay_store_text,tv_rating_count,tv_store_desc
        ,tv_store_new,tv_store_name ;


        public MyViewHolder(View itemView) {
            super(itemView);


            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
            lv_store_area_click = (LinearLayout) itemView.findViewById(R.id.lv_store_area_click);
            lv_new = (LinearLayout) itemView.findViewById(R.id.lv_new);
            iv_store_image_area = (ImageView) itemView.findViewById(R.id.iv_store_image_area);

            tv_store_delivery = (TextView) itemView.findViewById(R.id.tv_store_delivery);
            tv_store_minimum = (TextView) itemView.findViewById(R.id.tv_store_minimum);
            tv_store_avg_min = (TextView) itemView.findViewById(R.id.tv_store_avg_min);
            tv_store_avg_text = (TextView) itemView.findViewById(R.id.tv_store_avg_text);
            tv_store_pay_method = (TextView) itemView.findViewById(R.id.tv_store_pay_method);
            tv_pay_store_text = (TextView) itemView.findViewById(R.id.tv_pay_store_text);
            tv_rating_count = (TextView) itemView.findViewById(R.id.tv_rating_count);
            tv_store_desc = (TextView) itemView.findViewById(R.id.tv_store_desc);
            tv_store_new = (TextView) itemView.findViewById(R.id.tv_store_new);
            tv_store_name = (TextView) itemView.findViewById(R.id.tv_store_name);


        }
    }
}








