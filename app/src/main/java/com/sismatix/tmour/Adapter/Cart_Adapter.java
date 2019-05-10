package com.sismatix.tmour.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Model.Cart_Model;
import com.sismatix.tmour.Model.MyOrder_Model;
import com.sismatix.tmour.R;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.MyViewHolder> {
    Context context;
    private List<Cart_Model> cartModels;
    int textqut = 1;
    public Cart_Adapter(FragmentActivity context, List<Cart_Model> cartModels) {
        this.context = context;
        this.cartModels = cartModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Cart_Model cart_model = cartModels.get(position);

        holder.tv_customer_name.setTypeface(Navigation_drawer_activity.roboto_bold);
        holder.tv_cart_qty.setTypeface(Navigation_drawer_activity.roboto_bold);
        holder.tv_cart_quantity_total.setTypeface(Navigation_drawer_activity.cairo_bold);
        holder.tv_item_price.setTypeface(Navigation_drawer_activity.roboto_medium);
        holder.tv_cart_price.setTypeface(Navigation_drawer_activity.roboto_medium);
        holder.tv_tot.setTypeface(Navigation_drawer_activity.roboto_medium);
        holder.tv_total.setTypeface(Navigation_drawer_activity.roboto_medium);

       /* holder.tv_customer_name.setText(cart_model.getCart_title());
        holder.tv_item_price.setText(cart_model.getCart_item_price());
        holder.tv_cart_price.setText(cart_model.getCart_total());
        Glide.with(context).load(cart_model.getCart_image()).into(holder.iv_cart);*/

       holder.iv_cart_quantity_increase.setOnClickListener(new View.OnClickListener() {
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
               holder.tv_cart_quantity_total.setText(String.valueOf(textqut));

           }
       });

        holder.iv_cart_quantity_decrease.setOnClickListener(new View.OnClickListener() {
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
                        holder.tv_cart_quantity_total.setText(String.valueOf(textqut));
                     //   callAppUpdateCart(Result, itemid_cart, quoteid_cart, view, holder);
                        // product_total = product_total - current_price;
                    } else {
                        Log.e("result",""+textqut);
                        holder.tv_cart_quantity_total.setText(String.valueOf(textqut));
                      //  callAppUpdateCart(Result, itemid_cart, quoteid_cart, view, holder);
                    }
                } else {
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_cart,iv_cart_quantity_increase,iv_cart_quantity_decrease;
        TextView tv_customer_name, tv_cart_qty, tv_cart_quantity_total, tv_item_price,tv_cart_price,tv_tot,tv_total;

        public MyViewHolder(@NonNull View view) {
            super(view);

            iv_cart = (ImageView)view.findViewById(R.id.iv_cart);
            iv_cart_quantity_decrease = (ImageView)view.findViewById(R.id.iv_cart_quantity_decrease);
            iv_cart_quantity_increase = (ImageView)view.findViewById(R.id.iv_cart_quantity_increase);

            tv_customer_name = (TextView)view.findViewById(R.id.tv_customer_name);
            tv_cart_qty = (TextView)view.findViewById(R.id.tv_cart_qty);
            tv_cart_quantity_total = (TextView)view.findViewById(R.id.tv_cart_quantity_total);
            tv_item_price = (TextView)view.findViewById(R.id.tv_item_price);
            tv_cart_price = (TextView)view.findViewById(R.id.tv_cart_price);
            tv_tot = (TextView)view.findViewById(R.id.tv_tot);
            tv_total = (TextView)view.findViewById(R.id.tv_total);
        }
    }
}