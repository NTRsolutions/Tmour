package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Strore_info_freg extends Fragment {

    Toolbar toolbar_store;
    TextView tv_dates_main_title,tv_ordering_det_title,tv_delivery_time_tile,tv_del_time,tv_min_order_title,tv_min_order,
            tv_service_ch_title,tv_service_ch,tv_preorder_title,tv_preorder,tv_other_info,tv_store_area_title,tv_store_area,
            tv_opening_hour_title,tv_opening_hour;

    public Strore_info_freg() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_strore_info_freg, container, false);

        toolbar_store = (Toolbar) view.findViewById(R.id.toolbar_store_info);
        toolbar_store.setTitle(getResources().getString(R.string.store));
        setHasOptionsMenu(true);
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_store);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        AllocateMemory(view);

        return view;
    }

    private void AllocateMemory(View view) {

        tv_dates_main_title = (TextView)view.findViewById(R.id.tv_dates_main_title);
        tv_ordering_det_title = (TextView)view.findViewById(R.id.tv_ordering_det_title);
        tv_delivery_time_tile = (TextView)view.findViewById(R.id.tv_delivery_time_tile);
        tv_del_time = (TextView)view.findViewById(R.id.tv_del_time);
        tv_min_order_title = (TextView)view.findViewById(R.id.tv_min_order_title);
        tv_min_order = (TextView)view.findViewById(R.id.tv_min_order);
        tv_service_ch_title = (TextView)view.findViewById(R.id.tv_service_ch_title);
        tv_service_ch = (TextView)view.findViewById(R.id.tv_service_ch);
        tv_preorder_title = (TextView)view.findViewById(R.id.tv_preorder_title);
        tv_preorder = (TextView)view.findViewById(R.id.tv_preorder);
        tv_other_info = (TextView)view.findViewById(R.id.tv_other_info);
        tv_store_area_title = (TextView)view.findViewById(R.id.tv_store_area_title);
        tv_store_area = (TextView)view.findViewById(R.id.tv_store_area);
        tv_opening_hour_title = (TextView)view.findViewById(R.id.tv_opening_hour_title);
        tv_opening_hour = (TextView)view.findViewById(R.id.tv_opening_hour);

        tv_dates_main_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_ordering_det_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_delivery_time_tile.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_del_time.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_min_order.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_service_ch_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_service_ch.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_preorder_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_preorder.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_other_info.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_store_area_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_store_area.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_opening_hour.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_opening_hour_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_min_order_title.setTypeface(Navigation_drawer_activity.roboto_bold);

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
