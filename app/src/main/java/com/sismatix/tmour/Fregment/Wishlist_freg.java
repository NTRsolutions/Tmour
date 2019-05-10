package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Wishlist_freg extends Fragment {

        View v;

    public Wishlist_freg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_wishlist_freg, container, false);
        setHasOptionsMenu(true);
        Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.offers));


        return v;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        // inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
