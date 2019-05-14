package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Adapter.Cart_Adapter;
import com.sismatix.tmour.Adapter.MyOrders_Adapter;
import com.sismatix.tmour.CheckNetwork;
import com.sismatix.tmour.Model.Cart_Model;
import com.sismatix.tmour.Model.MyOrder_Model;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cart_freg extends Fragment implements View.OnClickListener {

    View view;
    android.support.v7.widget.Toolbar toolbar_cart;
    public static List<Cart_Model> cartList = new ArrayList<Cart_Model>();
    public static Cart_Adapter cart_adapter;
    RecyclerView recyclerview_cart;
    LinearLayout lv_checkout,lv_add_item;
    String lang_flag;
    TextView tv_cart_checkout, tv_cart_additem, tv_cart_price, tv_kw, tv_cart_subtotal, tv_order_time, tv_customer_name, tv_cart_to_title;

    public Cart_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart_freg, container, false);
        //Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.cart));
        lang_flag = Login_preference.get_Lang_flag(getActivity());

        AllocateMemory(view);
        setHasOptionsMenu(true);
        setTypeface();

        //  toolbar_cart.setTitle(getResources().getString(R.string.cart));
        tv_cart_to_title.setText(getResources().getString(R.string.cart));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_cart);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);


        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            CALL_CART_API();
        } else {
            Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }


        lv_add_item.setOnClickListener(this);
        lv_checkout.setOnClickListener(this);

        return view;
    }

    private void CALL_CART_API() {
        for (int i = 0; i < 5; i++) {
            cartList.add(new Cart_Model("", "",
                    "", ""));
        }

        cart_adapter.notifyDataSetChanged();

    }

    private void setTypeface() {
        if (lang_flag.equals("0")) {
            tv_cart_checkout.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_cart_additem.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_cart_price.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_kw.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_kw.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_cart_subtotal.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_order_time.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_customer_name.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_cart_to_title.setTypeface(Navigation_drawer_activity.cairo_bold);
        } else {
            tv_cart_checkout.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_cart_additem.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_cart_price.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_kw.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_kw.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_cart_subtotal.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_order_time.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_customer_name.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_cart_to_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        }
    }

    private void pushFragment(Fragment fragment, String add_to_backstack) {
        if (fragment == null)
            return;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.main_fram_layout, fragment);
                ft.addToBackStack(add_to_backstack);
                ft.commit();
            }
        }
    }

    private void AllocateMemory(View view) {
        recyclerview_cart = (RecyclerView) view.findViewById(R.id.recyclerview_cart);
        cart_adapter = new Cart_Adapter(getActivity(), cartList);
        recyclerview_cart.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerview_cart.setAdapter(cart_adapter);
        lv_checkout = (LinearLayout)view.findViewById(R.id.lv_checkout);
        lv_add_item = (LinearLayout)view.findViewById(R.id.lv_add_item);
        toolbar_cart = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar_cart);


        tv_cart_checkout = (TextView) view.findViewById(R.id.tv_cart_checkout);
        tv_cart_additem = (TextView) view.findViewById(R.id.tv_cart_additem);
        tv_cart_price = (TextView) view.findViewById(R.id.tv_kw);
        tv_kw = (TextView) view.findViewById(R.id.tv_cart_checkout);
        tv_cart_subtotal = (TextView) view.findViewById(R.id.tv_cart_subtotal);
        tv_order_time = (TextView) view.findViewById(R.id.tv_order_time);
        tv_customer_name = (TextView) view.findViewById(R.id.tv_customer_name);
        tv_cart_to_title = (TextView) view.findViewById(R.id.tv_cart_to_title);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
       ///inflater.inflate(R.menu.menu_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClick(View view) {
        if(view==lv_add_item)
        {
            pushFragment(new Product_freg(),"product");

        }else if(view==lv_checkout)
        {
            pushFragment(new Checkout(),"checkout");

        }
    }
}
