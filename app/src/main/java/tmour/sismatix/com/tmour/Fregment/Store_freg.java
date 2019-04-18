package tmour.sismatix.com.tmour.Fregment;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;
import tmour.sismatix.com.tmour.Adapter.Store_area_Adapter;
import tmour.sismatix.com.tmour.Adapter.Store_image_adapter;
import tmour.sismatix.com.tmour.CheckNetwork;
import tmour.sismatix.com.tmour.Model.Store_area_Model;
import tmour.sismatix.com.tmour.Model.Store_image_model;
import tmour.sismatix.com.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Store_freg extends Fragment {

    RecyclerView recycler_store_area,recycler_store_image;
    View view;
    LinearLayout lv_categories,lv_search_store;
    TextView tv_store_categories,tv_store_search;

    Store_image_adapter image_adapter;
    private List<Store_image_model> store_image_model = new ArrayList<Store_image_model>();
    private List<Store_area_Model> store_area_Model = new ArrayList<Store_area_Model>();

    Toolbar toolbar_store;
    Store_area_Adapter store_area_adapter;

    public Store_freg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_store_freg, container, false);
        Allocate_Memory(view);
        Attach_recyclerview();
        setHasOptionsMenu(true);

        Navigation_drawer_activity.changeToolbarFont(toolbar_store,getActivity());


        toolbar_store.setTitle(getResources().getString(R.string.area_name_placed));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_store);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);




        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            CALL_STORE_IMAGE_API();
            CALL_STORE_AREA_API();

        } else {
            Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
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
        toolbar_store=(Toolbar) view.findViewById(R.id.toolbar_store);

        tv_store_categories.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_store_search.setTypeface(Navigation_drawer_activity.roboto_bold);

    }

}
