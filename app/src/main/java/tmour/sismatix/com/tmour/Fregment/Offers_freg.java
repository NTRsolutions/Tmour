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
import tmour.sismatix.com.tmour.Adapter.Offers_Adapter;
import tmour.sismatix.com.tmour.Model.Offers_Model;
import tmour.sismatix.com.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Offers_freg extends Fragment {

    RecyclerView recycler_offers;
    private static List<Offers_Model> my_offers = new ArrayList<Offers_Model>();
    private static Offers_Adapter offers_adapter;

    public Offers_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_offers_freg, container, false);
        Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.offers));
        AllocateMemory(v);

        for (int i = 0; i < 5; i++) {
            my_offers.add(new Offers_Model("", "",
                    "", "", ""));
        }

        offers_adapter.notifyDataSetChanged();

        return v;
    }

    private void AllocateMemory(View v) {
        recycler_offers=(RecyclerView)v.findViewById(R.id.recycler_offers);

        offers_adapter = new Offers_Adapter(getActivity(), my_offers);
        recycler_offers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler_offers.setAdapter(offers_adapter);
    }

}
