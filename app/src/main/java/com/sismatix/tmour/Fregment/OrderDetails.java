package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Adapter.Offers_Adapter;
import com.sismatix.tmour.Adapter.OrderSummary_Adapter;
import com.sismatix.tmour.Model.Offers_Model;
import com.sismatix.tmour.Model.OrderSummary_Model;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderDetails extends Fragment {

    TextView tv_os_customer_name, tv_os_order_date, tv_os_order_time, text_os_order_id, tv_os_order_id, tv_os_order_status, tv_os_shipping_title,
            tv_os_cust_name, tv_os_confirm_add, tv_os_order_sum_title, tv_subtotal_title, tv_subtotal, tv_disc_title, tv_discount, tv_ser_ch_title,
            tv_ser_charge, tv_vat_title, tv_vat, tv_total_title, tv_os_total, tv_pay_met_title, tv_paymethod, tv_del_time_tile, tv_deli_time;

    RecyclerView recyclerview_ordersummary;
    private static List<OrderSummary_Model> orderSummary_models = new ArrayList<OrderSummary_Model>();
    private static OrderSummary_Adapter orderSummary_adapter;

    public OrderDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order_details, container, false);

        Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.orderdet_title));
        AllocateMemory(v);
        setTypeFace();

        for (int i = 0; i < 5; i++) {
            orderSummary_models.add(new OrderSummary_Model("", "",
                    ""));
        }

        orderSummary_adapter.notifyDataSetChanged();

        return v;
    }

    private void setTypeFace() {
        tv_os_customer_name.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_os_order_date.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_os_order_time.setTypeface(Navigation_drawer_activity.roboto_bold);
        text_os_order_id.setTypeface(Navigation_drawer_activity.roboto_medium);
        tv_os_order_id.setTypeface(Navigation_drawer_activity.roboto_medium);
        tv_os_order_status.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_os_shipping_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_os_cust_name.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_os_confirm_add.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_os_order_sum_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_subtotal_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_subtotal.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_disc_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_discount.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_ser_ch_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_ser_charge.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_vat_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_vat.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_total_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_os_total.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_pay_met_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_paymethod.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_del_time_tile.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_deli_time.setTypeface(Navigation_drawer_activity.roboto_bold);

    }

    private void AllocateMemory(View v) {
        recyclerview_ordersummary = (RecyclerView) v.findViewById(R.id.recyclerview_ordersummary);

        orderSummary_adapter = new OrderSummary_Adapter(getActivity(), orderSummary_models);
        recyclerview_ordersummary.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerview_ordersummary.setAdapter(orderSummary_adapter);

        tv_os_customer_name = (TextView) v.findViewById(R.id.tv_os_customer_name);
        tv_os_order_date = (TextView) v.findViewById(R.id.tv_os_order_date);
        tv_os_order_time = (TextView) v.findViewById(R.id.tv_os_order_time);
        text_os_order_id = (TextView) v.findViewById(R.id.text_os_order_id);
        tv_os_order_id = (TextView) v.findViewById(R.id.tv_os_order_id);
        tv_os_order_status = (TextView) v.findViewById(R.id.tv_os_order_status);
        tv_os_shipping_title = (TextView) v.findViewById(R.id.tv_os_shipping_title);
        tv_os_cust_name = (TextView) v.findViewById(R.id.tv_os_cust_name);
        tv_os_confirm_add = (TextView) v.findViewById(R.id.tv_os_confirm_add);
        tv_os_order_sum_title = (TextView) v.findViewById(R.id.tv_os_order_sum_title);
        tv_subtotal_title = (TextView) v.findViewById(R.id.tv_subtotal_title);
        tv_subtotal = (TextView) v.findViewById(R.id.tv_subtotal);
        tv_disc_title = (TextView) v.findViewById(R.id.tv_disc_title);
        tv_discount = (TextView) v.findViewById(R.id.tv_discount);
        tv_ser_ch_title = (TextView) v.findViewById(R.id.tv_ser_ch_title);
        tv_ser_charge = (TextView) v.findViewById(R.id.tv_ser_charge);
        tv_vat_title = (TextView) v.findViewById(R.id.tv_vat_title);
        tv_vat = (TextView) v.findViewById(R.id.tv_vat);
        tv_total_title = (TextView) v.findViewById(R.id.tv_total_title);
        tv_os_total = (TextView) v.findViewById(R.id.tv_os_total);
        tv_pay_met_title = (TextView) v.findViewById(R.id.tv_pay_met_title);
        tv_paymethod = (TextView) v.findViewById(R.id.tv_paymethod);
        tv_del_time_tile = (TextView) v.findViewById(R.id.tv_del_time_tile);
        tv_deli_time = (TextView) v.findViewById(R.id.tv_deli_time);
    }

}
