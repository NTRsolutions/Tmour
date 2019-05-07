package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Search_freg extends Fragment implements SearchView.OnQueryTextListener {

    View view;
    Toolbar toolbar_search;
    SearchView searchView;
    public Search_freg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_search_freg, container, false);
        Allocate_Memory(view);

        setHasOptionsMenu(true);

        Navigation_drawer_activity.changeToolbarFont(toolbar_search,getActivity());
        toolbar_search.setTitle(getResources().getString(R.string.search_area));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_search);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);


        searchView.setOnQueryTextListener(this);


        return view;
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


    private void Allocate_Memory(View view) {
        toolbar_search=(Toolbar)view.findViewById(R.id.toolbar_search);
        searchView=(SearchView)view.findViewById(R.id.search_view);
    }

    @Override
    public boolean onQueryTextSubmit(String newText) {

        String text = newText;
        Log.e("serch_text",""+text);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
