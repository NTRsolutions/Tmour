package tmour.sismatix.com.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;
import tmour.sismatix.com.tmour.Adapter.MyOrders_Adapter;
import tmour.sismatix.com.tmour.Adapter.Offers_Adapter;
import tmour.sismatix.com.tmour.Model.MyOrder_Model;
import tmour.sismatix.com.tmour.Model.Offers_Model;
import tmour.sismatix.com.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class My_order_freg extends Fragment {

    RecyclerView recycler_myorders;
    private static List<MyOrder_Model> myOrderModels= new ArrayList<MyOrder_Model>();
    private static MyOrders_Adapter myOrders_adapter;

    public My_order_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_order_freg, container, false);
        Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.MyOrders));
        AllocateMemory(v);

        for (int i = 0; i < 5; i++) {
            myOrderModels.add(new MyOrder_Model("", "",
                    "", "", "",""));
        }

        myOrders_adapter.notifyDataSetChanged();

        return v;
    }

    private void AllocateMemory(View v) {
        recycler_myorders=(RecyclerView)v.findViewById(R.id.recycler_myorders);
        myOrders_adapter = new MyOrders_Adapter(getActivity(), myOrderModels);
        recycler_myorders.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler_myorders.setAdapter(myOrders_adapter);
    }

}
