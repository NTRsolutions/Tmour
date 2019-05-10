package com.sismatix.tmour.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.sismatix.tmour.Fregment.OrderDetails;
import com.sismatix.tmour.Fregment.ProductDetails;
import com.sismatix.tmour.Model.Library_model;
import com.sismatix.tmour.R;


public class Library_adapter extends RecyclerView.Adapter<Library_adapter.MyViewHolder> {
    private Context context;
    private List<Library_model> models;
    int textqut = 1;


    public Library_adapter(Context context, List<Library_model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_row, parent, false);//library_row

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Library_model product_model = models.get(position);

        holder.lv_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new ProductDetails();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fram_layout, myFragment).addToBackStack(null).commit();
            }
        });

        holder.iv_product_quantity_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // holder.iv_cart_quantity_increase.setEnabled(false);

                // int textqut = Integer.parseInt(holder.tv_cart_quantity_total.getText().toString());

                //quantity = textqut + 1;
                // int Result = textqut + 1;
                textqut = textqut + 1;
                //  itemid_cart = cart_model.ge();
                // quoteid_cart = Login_preference.getquote_id(context);
                Log.e("result",""+textqut);
                holder.tv_product_quantity_total.setText(String.valueOf(textqut));

            }
        });

        holder.iv_product_quantity_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  holder.iv_cart_quantity_decrease.setEnabled(false);
                // int textqut = Integer.parseInt(holder.tv_cart_quantity_total.getText().toString());
                //   int textqut = 1;
                // itemid_cart = cart_model.getItemid();
                // quoteid_cart = Login_preference.getquote_id(context);
                if (textqut != 0) {
                    // int Result = textqut - 1;
                    textqut = textqut - 1;
                    if (textqut == 0) {
                        textqut = 1;
                        Log.e("result",""+textqut);
                        holder.tv_product_quantity_total.setText(String.valueOf(textqut));
                        //   callAppUpdateCart(Result, itemid_cart, quoteid_cart, view, holder);
                        // product_total = product_total - current_price;
                    } else {
                        Log.e("result",""+textqut);
                        holder.tv_product_quantity_total.setText(String.valueOf(textqut));
                        //  callAppUpdateCart(Result, itemid_cart, quoteid_cart, view, holder);
                    }
                } else {
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return models.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_product_quantity_increase,iv_product_quantity_decrease;
        TextView tv_library_date, tv_library_title, tv_library_link,tv_more,tv_library_desc,tv_product_quantity_total;
        LinearLayout lv_products;

        public MyViewHolder(View view) {
            super(view);
            tv_library_date = (TextView) view.findViewById(R.id.tv_library_date);
            tv_library_title = (TextView) view.findViewById(R.id.tv_library_title);
            tv_library_link = (TextView) view.findViewById(R.id.tv_library_link);
            tv_more = (TextView) view.findViewById(R.id.tv_more);
            lv_products = (LinearLayout) view.findViewById(R.id.lv_products);
            tv_library_desc = (TextView) view.findViewById(R.id.tv_library_desc);
            tv_product_quantity_total = (TextView) view.findViewById(R.id.tv_product_quantity_total);
            iv_product_quantity_increase = (ImageView) view.findViewById(R.id.iv_product_quantity_increase);
            iv_product_quantity_decrease = (ImageView) view.findViewById(R.id.iv_product_quantity_decrease);


        }
    }


}






