package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Adapter.OrderSummary_Adapter;
import com.sismatix.tmour.Adapter.Payment_Method_Adapter;
import com.sismatix.tmour.Model.OrderSummary_Model;
import com.sismatix.tmour.Model.Payment_Method_Model;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Checkout extends Fragment {

    android.support.v7.widget.Toolbar toolbar_checkout;

    TextView tv_shipping_title, tv_change, confirm_add, tv_co_cust_name, disc_vou_title, tv_redeem, tv_paywith_title, tv_subt_title,
            tv_subtotall, tv_del_free_tile, tv_delfree, tv_tot_title, tv_kwd_title, tv_tot, tv_placeorder;
    EditText et_voucher;

    RecyclerView recyclerview_order_checkout;
    private static List<OrderSummary_Model> orderSummary_models = new ArrayList<OrderSummary_Model>();
    private static OrderSummary_Adapter orderSummary_adapter;

    RecyclerView payment_method_recyclerview;
    Payment_Method_Adapter payment_method_adapter;
    private List<Payment_Method_Model> payment_method_models = new ArrayList<Payment_Method_Model>();

    public Checkout() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_checkout, container, false);

        AllocateMemory(v);
        setTypeface();
        setHasOptionsMenu(true);

        toolbar_checkout = (Toolbar) v.findViewById(R.id.toolbar_checkout);
        toolbar_checkout.setTitle(getResources().getString(R.string.checkout));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_checkout);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < 5; i++) {
            orderSummary_models.add(new OrderSummary_Model("", "",
                    ""));
        }

        orderSummary_adapter.notifyDataSetChanged();

        for (int i = 0; i < 2; i++) {
            payment_method_models.add(new Payment_Method_Model("", ""));
        }

        payment_method_adapter.notifyDataSetChanged();

        return v;
    }

    private void AllocateMemory(View v) {
        recyclerview_order_checkout = (RecyclerView) v.findViewById(R.id.recyclerview_order_checkout);

        orderSummary_adapter = new OrderSummary_Adapter(getActivity(), orderSummary_models);
        recyclerview_order_checkout.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerview_order_checkout.setAdapter(orderSummary_adapter);

        payment_method_recyclerview = (RecyclerView) v.findViewById(R.id.payment_method_recyclerview);

        payment_method_adapter = new Payment_Method_Adapter(getActivity(), payment_method_models);
        payment_method_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        payment_method_recyclerview.setAdapter(payment_method_adapter);

        et_voucher = (EditText) v.findViewById(R.id.et_voucher);
        tv_shipping_title = (TextView) v.findViewById(R.id.tv_shipping_title);
        tv_change = (TextView) v.findViewById(R.id.tv_change);
        confirm_add = (TextView) v.findViewById(R.id.confirm_add);
        tv_co_cust_name = (TextView) v.findViewById(R.id.tv_co_cust_name);
        disc_vou_title = (TextView) v.findViewById(R.id.disc_vou_title);
        tv_redeem = (TextView) v.findViewById(R.id.tv_redeem);
        tv_subt_title = (TextView) v.findViewById(R.id.tv_subt_title);
        tv_subtotall = (TextView) v.findViewById(R.id.tv_subtotall);
        tv_delfree = (TextView) v.findViewById(R.id.tv_delfree);
        tv_tot_title = (TextView) v.findViewById(R.id.tv_tot_title);
        tv_kwd_title = (TextView) v.findViewById(R.id.tv_kwd_title);
        tv_tot = (TextView) v.findViewById(R.id.tv_tot);
        tv_placeorder = (TextView) v.findViewById(R.id.tv_placeorder);
        tv_shipping_title = (TextView) v.findViewById(R.id.tv_shipping_title);
        tv_shipping_title = (TextView) v.findViewById(R.id.tv_shipping_title);
        tv_paywith_title = (TextView) v.findViewById(R.id.tv_paywith_title);
        tv_del_free_tile = (TextView) v.findViewById(R.id.tv_del_free_tile);
    }

    private void setTypeface() {
        et_voucher.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_shipping_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_change.setTypeface(Navigation_drawer_activity.roboto_bold);
        confirm_add.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_co_cust_name.setTypeface(Navigation_drawer_activity.roboto_bold);
        disc_vou_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_redeem.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_subt_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_subtotall.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_delfree.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_tot_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_kwd_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_tot.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_placeorder.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_shipping_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_shipping_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_paywith_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_del_free_tile.setTypeface(Navigation_drawer_activity.roboto_bold);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case android.R.id.home:
                getActivity().onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
