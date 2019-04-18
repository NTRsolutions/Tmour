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
import tmour.sismatix.com.tmour.Model.MyOrder_Model;
import tmour.sismatix.com.tmour.Model.Offers_Model;
import tmour.sismatix.com.tmour.R;

public class MyOrders_Adapter extends RecyclerView.Adapter<MyOrders_Adapter.MyViewHolder> {
    Context context;
    private List<MyOrder_Model> myOrderModels;

    public MyOrders_Adapter(FragmentActivity context, List<MyOrder_Model> myOrderModels) {
        this.context = context;
        this.myOrderModels = myOrderModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.myorders_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final MyOrder_Model myOrder_model = myOrderModels.get(position);

        holder.tv_customer_name.setTypeface(Navigation_drawer_activity.roboto_bold);
        holder.tv_order_date.setTypeface(Navigation_drawer_activity.roboto_bold);
        holder.tv_order_time.setTypeface(Navigation_drawer_activity.roboto_bold);
        holder.tv_order_id.setTypeface(Navigation_drawer_activity.roboto_medium);
        holder.text_order_id.setTypeface(Navigation_drawer_activity.roboto_medium);
        holder.tv_order_status.setTypeface(Navigation_drawer_activity.roboto_bold);

        /*holder.tv_customer_name.setText(myOrder_model.getCustomer_name());
        holder.tv_order_date.setText(myOrder_model.getOrder_date());
        holder.tv_order_time.setText(myOrder_model.getOrder_time());
        holder.tv_order_id.setText(myOrder_model.getOrder_id());
        holder.tv_order_status.setText(myOrder_model.getOrder_status());

        Glide.with(context).load(myOrder_model.getOrder_image()).into(holder.iv_order);*/

    }

    @Override
    public int getItemCount() {
        return myOrderModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_order;
        TextView tv_customer_name, tv_order_date, tv_order_time, tv_order_id,tv_order_status,text_order_id;

        public MyViewHolder(@NonNull View view) {
            super(view);

            iv_order = (ImageView)view.findViewById(R.id.iv_order);

            tv_customer_name = (TextView)view.findViewById(R.id.tv_customer_name);
            tv_order_date = (TextView)view.findViewById(R.id.tv_order_date);
            tv_order_time = (TextView)view.findViewById(R.id.tv_order_time);
            tv_order_id = (TextView)view.findViewById(R.id.tv_order_id);
            tv_order_id = (TextView)view.findViewById(R.id.tv_order_id);
            text_order_id = (TextView)view.findViewById(R.id.text_order_id);
            tv_order_status = (TextView)view.findViewById(R.id.tv_order_status);
        }
    }
}