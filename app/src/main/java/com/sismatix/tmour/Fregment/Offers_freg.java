package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
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
        Navigation_drawer_activity.tv_nav_title.setVisibility(View.VISIBLE);

        Navigation_drawer_activity.tv_nav_title.setText(getResources().getString(R.string.offers));
        if (lang_flag.equals("0")) {
            Navigation_drawer_activity.tv_nav_title.setTypeface(Navigation_drawer_activity.cairo_bold);

        } else {
            Navigation_drawer_activity.tv_nav_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
       // MenuInflater inflater = getActivity().getMenuInflater();
       // inflater.inflate(R.menu.menu_search, menu);
      //  menu.findItem(R.id.search).setEnabled(false);
        super.onCreateOptionsMenu(menu,inflater);
    }


    private void AllocateMemory(View v) {
        recycler_offers=(RecyclerView)v.findViewById(R.id.recycler_offers);

        offers_adapter = new Offers_Adapter(getActivity(), my_offers);
        recycler_offers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler_offers.setAdapter(offers_adapter);
    }

}
