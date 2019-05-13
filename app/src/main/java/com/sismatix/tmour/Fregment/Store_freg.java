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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Adapter.Store_area_Adapter;
import com.sismatix.tmour.Adapter.Store_image_adapter;
import com.sismatix.tmour.CheckNetwork;
import com.sismatix.tmour.Model.Store_area_Model;
import com.sismatix.tmour.Model.Store_image_model;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Store_freg extends Fragment {

    RecyclerView recycler_store_area,recycler_store_image;
    View view;
    LinearLayout lv_categories,lv_search_store;
    TextView tv_store_categories,tv_store_search,tv_store_to_title;

    Store_image_adapter image_adapter;
    private List<Store_image_model> store_image_model = new ArrayList<Store_image_model>();
    private List<Store_area_Model> store_area_Model = new ArrayList<Store_area_Model>();

    Toolbar toolbar_store;
    Store_area_Adapter store_area_adapter;
    String lang_flag;

    public Store_freg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_store_freg, container, false);

        lang_flag = Login_preference.get_Lang_flag(getContext());

        Allocate_Memory(view);
        Attach_recyclerview();
        setHasOptionsMenu(true);

        Navigation_drawer_activity.changeToolbarFont(toolbar_store,getActivity());


        //toolbar_store.setTitle(getResources().getString(R.string.area_name_placed));
        tv_store_to_title.setText(getResources().getString(R.string.area_name_placed));
      //  Navigation_drawer_activity.tv_nav_title.setText(getResources().getString(R.string.area_name_placed));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_store);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            CALL_STORE_IMAGE_API();
            CALL_STORE_AREA_API();

        } else {
            Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }

        if (lang_flag.equals("0")){
            tv_store_categories.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_store_search.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_store_to_title.setTypeface(Navigation_drawer_activity.cairo_bold);
            Navigation_drawer_activity.tv_nav_title.setTypeface(Navigation_drawer_activity.cairo_bold);
        }else {
            tv_store_categories.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_store_search.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_store_to_title.setTypeface(Navigation_drawer_activity.roboto_bold);
            Navigation_drawer_activity.tv_nav_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        }

        return view;
    }

    private void CALL_STORE_AREA_API() {
        for (int i=0;i<10;i++)
        {
            store_area_Model.add(new Store_area_Model("","","","","",""));
        }
    }

    private void CALL_STORE_IMAGE_API() {

        for (int i=0;i<10;i++)
        {
            store_image_model.add(new Store_image_model(""));
        }
    }

    private void Attach_recyclerview() {

        image_adapter = new Store_image_adapter(getActivity(), store_image_model);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        recycler_store_image.setLayoutManager(layoutManager);
        recycler_store_image.setAdapter(image_adapter);


        store_area_adapter = new Store_area_Adapter(getActivity(), store_area_Model);
        LinearLayoutManager layoutManager1=new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recycler_store_area.setLayoutManager(layoutManager1);
        recycler_store_area.setAdapter(store_area_adapter);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case android.R.id.home:
                // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
                // if this doesn't work as desired, another possibility is to call `finish()` here.
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void Allocate_Memory(View view) {

        recycler_store_area=(RecyclerView)view.findViewById(R.id.recycler_store_area);
        recycler_store_image=(RecyclerView)view.findViewById(R.id.recycler_store_image);
        lv_categories=(LinearLayout)view.findViewById(R.id.lv_categories);
        lv_search_store=(LinearLayout)view.findViewById(R.id.lv_search_store);
        tv_store_categories=(TextView)view.findViewById(R.id.tv_store_categories);
        tv_store_search=(TextView)view.findViewById(R.id.tv_store_search);
        tv_store_to_title=(TextView)view.findViewById(R.id.tv_store_to_title);
        toolbar_store=(Toolbar) view.findViewById(R.id.toolbar_store);

    }

}
