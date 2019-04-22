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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;
import tmour.sismatix.com.tmour.Adapter.Offers_Adapter;
import tmour.sismatix.com.tmour.Adapter.Product_Details_Images_Adapter;
import tmour.sismatix.com.tmour.Model.Offers_Model;
import tmour.sismatix.com.tmour.Model.Product_Details_images_Model;
import tmour.sismatix.com.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetails extends Fragment {

    android.support.v7.widget.Toolbar toolbar_prod_details;
    RecyclerView recyclerview_pro_det_images;
    private static List<Product_Details_images_Model> product_details_images_models = new ArrayList<Product_Details_images_Model>();
    private static Product_Details_Images_Adapter product_details_images_adapter;

    TextView text_order_id, tv_wishlist, tv_share, tv_add_det_title, tv_add_details, tv_store_title, tv_store,
            tv_status_title, tv_status, tv_bethe, tv_write_rev,tv_green,tv_add_to_cart,tv_add_to_wishlist;

    public ProductDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_product_details, container, false);
        AllocateMemory(v);
        setTypeface();
        setHasOptionsMenu(true);
        Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.Agwadates));

        toolbar_prod_details.setTitle(getResources().getString(R.string.Agwadates));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_prod_details);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < 5; i++) {
            product_details_images_models.add(new Product_Details_images_Model(""));
        }

        product_details_images_adapter.notifyDataSetChanged();

        return v;
    }

    private void AllocateMemory(View v) {
        toolbar_prod_details = (android.support.v7.widget.Toolbar) v.findViewById(R.id.toolbar_prod_details);
        recyclerview_pro_det_images = (RecyclerView) v.findViewById(R.id.recyclerview_pro_det_images);

        product_details_images_adapter = new Product_Details_Images_Adapter(getActivity(), product_details_images_models);
        recyclerview_pro_det_images.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerview_pro_det_images.setAdapter(product_details_images_adapter);

        text_order_id = (TextView) v.findViewById(R.id.text_order_id);
        tv_wishlist = (TextView) v.findViewById(R.id.tv_wishlist);
        tv_share = (TextView) v.findViewById(R.id.tv_share);
        tv_add_det_title = (TextView) v.findViewById(R.id.tv_add_det_title);
        tv_add_details = (TextView) v.findViewById(R.id.tv_add_details);
        tv_store = (TextView) v.findViewById(R.id.tv_store);
        tv_status_title = (TextView) v.findViewById(R.id.tv_status_title);
        tv_status = (TextView) v.findViewById(R.id.tv_status);
        tv_bethe = (TextView) v.findViewById(R.id.tv_bethe);
        tv_write_rev = (TextView) v.findViewById(R.id.tv_write_rev);
        tv_store_title = (TextView) v.findViewById(R.id.tv_store_title);
        tv_green = (TextView) v.findViewById(R.id.tv_green);
        tv_add_to_cart = (TextView) v.findViewById(R.id.tv_add_to_cart);
        tv_add_to_wishlist = (TextView) v.findViewById(R.id.tv_add_to_wishlist);

    }

    private void setTypeface() {
        text_order_id.setTypeface(Navigation_drawer_activity.roboto_black);
        tv_wishlist.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_share.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_green.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_add_det_title.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_add_details.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_store.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_status_title.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_status.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_bethe.setTypeface(Navigation_drawer_activity.roboto_medium);
        tv_write_rev.setTypeface(Navigation_drawer_activity.cairo_bold);
        tv_store_title.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_store_title.setTypeface(Navigation_drawer_activity.cairo_bold);
        tv_add_to_wishlist.setTypeface(Navigation_drawer_activity.cairo_bold);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.cart:
                //pushFragment(new Search_freg(),"Search");
                return true;

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
        inflater.inflate(R.menu.menu_cart, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
