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

import java.util.List;

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;
import tmour.sismatix.com.tmour.Model.Offers_Model;
import tmour.sismatix.com.tmour.Model.OrderSummary_Model;
import tmour.sismatix.com.tmour.R;

public class OrderSummary_Adapter extends RecyclerView.Adapter<OrderSummary_Adapter.MyViewHolder> {
    Context context;
    private List<OrderSummary_Model> orderSummary_models;

    public OrderSummary_Adapter(FragmentActivity context, List<OrderSummary_Model> orderSummary_models) {
        this.context = context;
        this.orderSummary_models = orderSummary_models;
    }

    @NonNull
    @Override
    public OrderSummary_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.order_summary_row, viewGroup, false);
        return new OrderSummary_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderSummary_Adapter.MyViewHolder holder, int position) {
        final OrderSummary_Model orderSummary_model = orderSummary_models.get(position);

        holder.text_os_order_qty.setTypeface(Navigation_drawer_activity.roboto_bold);
        holder.tv_os_order_name.setTypeface(Navigation_drawer_activity.roboto_bold);
        holder.tv_os_price.setTypeface(Navigation_drawer_activity.roboto_bold);
        holder.tv_x.setTypeface(Navigation_drawer_activity.roboto_bold);

       /* holder.text_os_order_qty.setText(orderSummary_model.getOrder_qty());
        holder.tv_os_order_name.setText(orderSummary_model.getOrder_title());
        holder.tv_os_price.setText(orderSummary_model.getOrder_tot());*/

    }

    @Override
    public int getItemCount() {
        return orderSummary_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_os_order_qty, tv_os_order_name, tv_os_price,tv_x;

        public MyViewHolder(@NonNull View view) {
            super(view);

            text_os_order_qty = (TextView)view.findViewById(R.id.text_os_order_qty);
            tv_os_order_name = (TextView)view.findViewById(R.id.tv_os_order_name);
            tv_os_price = (TextView)view.findViewById(R.id.tv_os_price);
            tv_x = (TextView)view.findViewById(R.id.tv_x);
        }
    }
}