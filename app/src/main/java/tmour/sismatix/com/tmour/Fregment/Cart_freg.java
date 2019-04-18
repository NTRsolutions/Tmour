package tmour.sismatix.com.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;
import tmour.sismatix.com.tmour.Adapter.Cart_Adapter;
import tmour.sismatix.com.tmour.Adapter.MyOrders_Adapter;
import tmour.sismatix.com.tmour.Model.Cart_Model;
import tmour.sismatix.com.tmour.Model.MyOrder_Model;
import tmour.sismatix.com.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cart_freg extends Fragment {

    View view;
    android.support.v7.widget.Toolbar toolbar_cart;
    public static List<Cart_Model> cartList = new ArrayList<Cart_Model>();
    public static Cart_Adapter cart_adapter;
    RecyclerView recyclerview_cart;

    public Cart_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart_freg, container, false);
        //Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.cart));

        AllocateMemory(view);
        setHasOptionsMenu(true);

        toolbar_cart = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar_cart);
        toolbar_cart.setTitle(getResources().getString(R.string.cart));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_cart);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < 5; i++) {
            cartList.add(new Cart_Model("", "",
                    "", ""));
        }

        cart_adapter.notifyDataSetChanged();

        return view;
    }

    private void AllocateMemory(View view) {
        recyclerview_cart = (RecyclerView) view.findViewById(R.id.recyclerview_cart);
        cart_adapter = new Cart_Adapter(getActivity(), cartList);
        recyclerview_cart.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerview_cart.setAdapter(cart_adapter);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_edit, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
