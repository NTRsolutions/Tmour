package tmour.sismatix.com.tmour.Adapter;

import android.content.Context;
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
import tmour.sismatix.com.tmour.Model.Cart_Model;
import tmour.sismatix.com.tmour.Model.MyOrder_Model;
import tmour.sismatix.com.tmour.R;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.MyViewHolder> {
    Context context;
    private List<Cart_Model> cartModels;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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

    }

    @Override
    public int getItemCount() {
        return cartModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_cart;
        TextView tv_customer_name, tv_cart_qty, tv_cart_quantity_total, tv_item_price,tv_cart_price,tv_tot,tv_total;

        public MyViewHolder(@NonNull View view) {
            super(view);

            iv_cart = (ImageView)view.findViewById(R.id.iv_cart);

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