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
import com.sismatix.tmour.Adapter.MyOrders_Adapter;
import com.sismatix.tmour.Adapter.Offers_Adapter;
import com.sismatix.tmour.CheckNetwork;
import com.sismatix.tmour.Model.MyOrder_Model;
import com.sismatix.tmour.Model.Offers_Model;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class My_order_freg extends Fragment {

    RecyclerView recycler_myorders;
    private static List<MyOrder_Model> myOrderModels= new ArrayList<MyOrder_Model>();
    private static MyOrders_Adapter myOrders_adapter;
    String lang_flag;
    public My_order_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_order_freg, container, false);
       // Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.MyOrders));


        AllocateMemory(v);
        setHasOptionsMenu(true);
        setTypface();


        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            CALL_Order_API();
        } else {
            Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }



        return v;
    }

    private void CALL_Order_API() {
        for (int i = 0; i < 5; i++) {
            myOrderModels.add(new MyOrder_Model("", "",
                    "", "", "",""));
        }

        myOrders_adapter.notifyDataSetChanged();

    }

    private void setTypface() {
        lang_flag = Login_preference.get_Lang_flag(getContext());
        Navigation_drawer_activity.tv_nav_title.setVisibility(View.VISIBLE);

        Navigation_drawer_activity.tv_nav_title.setText(getResources().getString(R.string.MyOrders));
        if (lang_flag.equals("0")) {
            Navigation_drawer_activity.tv_nav_title.setTypeface(Navigation_drawer_activity.cairo_bold);

        } else {
            Navigation_drawer_activity.tv_nav_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        // inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    private void AllocateMemory(View v) {
        recycler_myorders=(RecyclerView)v.findViewById(R.id.recycler_myorders);
        myOrders_adapter = new MyOrders_Adapter(getActivity(), myOrderModels);
        recycler_myorders.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler_myorders.setAdapter(myOrders_adapter);
    }

}
