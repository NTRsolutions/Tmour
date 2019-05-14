package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Adapter.Offers_Adapter;
import com.sismatix.tmour.CheckNetwork;
import com.sismatix.tmour.Model.Offers_Model;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Offers_freg extends Fragment {

    RecyclerView recycler_offers;
    private static List<Offers_Model> my_offers = new ArrayList<Offers_Model>();
    private static Offers_Adapter offers_adapter;
    String lang_flag;
    Toolbar toolbar_offer;
    TextView tv_offer_title;

    public Offers_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_offers_freg, container, false);
        setHasOptionsMenu(true);
        AllocateMemory(v);
        setTypface();
        // Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.offers));



        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            CALL_Offer_API();
        } else {
            Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }



        return v;
    }

    private void CALL_Offer_API() {
        for (int i = 0; i < 5; i++) {
            my_offers.add(new Offers_Model("", "",
                    "", "", ""));
        }

        offers_adapter.notifyDataSetChanged();

    }

    private void setTypface() {
        lang_flag = Login_preference.get_Lang_flag(getContext());

        tv_offer_title.setText(getResources().getString(R.string.offers));
        if (lang_flag.equals("0")) {
            tv_offer_title.setTypeface(Navigation_drawer_activity.cairo_bold);

        } else {
            tv_offer_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        }

        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_offer);
        if (toolbar_offer != null) {
            ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                    .setDisplayHomeAsUpEnabled(true);

            toolbar_offer.setNavigationIcon(R.drawable.ic_menu_white_36dp);
        }
        toolbar_offer.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Navigation_drawer_activity) getActivity()).getmDrawerLayout()
                        .openDrawer(GravityCompat.START);
            }
        });
    }
/*
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.search);
        if(item!=null)
            item.setVisible(false);
    }*/

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
       // MenuInflater inflater = getActivity().getMenuInflater();
       // inflater.inflate(R.menu.menu_search, menu);
      //  menu.findItem(R.id.search).setEnabled(false);
        super.onCreateOptionsMenu(menu,inflater);
    }

    private void AllocateMemory(View v) {
        recycler_offers=(RecyclerView)v.findViewById(R.id.recycler_offers);
        toolbar_offer=(Toolbar) v.findViewById(R.id.toolbar_offer);
        tv_offer_title=(TextView) v.findViewById(R.id.tv_offer_title);

        offers_adapter = new Offers_Adapter(getActivity(), my_offers);
        recycler_offers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler_offers.setAdapter(offers_adapter);
    }

}
