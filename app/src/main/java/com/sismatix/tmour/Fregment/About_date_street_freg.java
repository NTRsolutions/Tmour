package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class About_date_street_freg extends Fragment {

    android.support.v7.widget.Toolbar toolbar_cart;
    public About_date_street_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_about_date_street_freg, container, false);
        /*toolbar_cart = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar_cart);
        toolbar_cart.setTitle(getResources().getString(R.string.cart));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_cart);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);*/
        return view;
    }

}
