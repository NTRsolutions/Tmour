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

import java.util.ArrayList;
import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Adapter.Cart_Adapter;
import com.sismatix.tmour.Model.Cart_Model;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cart_freg extends Fragment {

    View view;
    android.support.v7.widget.Toolbar toolbar_cart;
    public static List<Cart_Model> cartList = new ArrayList<Cart_Model>();
    public static Cart_Adapter cart_adapter;
    RecyclerView recyclerview_cart;
    LinearLayout lv_checkout;

    public Cart_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart_freg, container, false);
        //Navigation_drawer_acti
        // vity.toolbar.setTitle(getResources().getString(R.string.cart));

        AllocateMemory(view);
        setHasOptionsMenu(true);

        toolbar_cart = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar_cart);
        toolbar_cart.setTitle(getResources().getString(R.string.cart));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_cart);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < 5; i++) {
            cartList.add(new Cart_Model("", "",
                    "", ""));
        }

        cart_adapter.notifyDataSetChanged();

        lv_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushFragment(new Checkout(),"checkout");
            }
        });

        return view;
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
        inflater.inflate(R.menu.menu_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
