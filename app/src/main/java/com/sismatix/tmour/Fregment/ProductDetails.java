package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Adapter.Offers_Adapter;
import com.sismatix.tmour.Adapter.Product_Details_Images_Adapter;
import com.sismatix.tmour.CheckNetwork;
import com.sismatix.tmour.Model.Offers_Model;
import com.sismatix.tmour.Model.Product_Details_images_Model;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetails extends Fragment {

    android.support.v7.widget.Toolbar toolbar_prod_details;
    RecyclerView recyclerview_pro_det_images;
    private static List<Product_Details_images_Model> product_details_images_models = new ArrayList<Product_Details_images_Model>();
    private static Product_Details_Images_Adapter product_details_images_adapter;
    ImageView iv_pdetail_quantity_increase,iv_pdetail_quantity_decrease;

    TextView text_order_id,tv_pro_to_title, tv_wishlist, tv_share, tv_add_det_title, tv_add_details, tv_store_title, tv_store,
            tv_status_title, tv_status, tv_bethe, tv_write_rev,tv_green,tv_add_to_cart,tv_add_to_wishlist,tv_pdetail_quantity_total;

    int textqut = 1;
    String lang_flag;
    public ProductDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_product_details, container, false);
        lang_flag = Login_preference.get_Lang_flag(getContext());

        AllocateMemory(v);
        setTypeface();
        setHasOptionsMenu(true);
       // Navigation_drawer_activity.toolbar.setTitle(getResources().getString(R.string.Agwadates));

        tv_pro_to_title.setText(getResources().getString(R.string.Agwadates));
        //toolbar_prod_details.setTitle(getResources().getString(R.string.Agwadates));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_prod_details);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);




        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            CALL_product_detail_API();
        } else {
            Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }





        //increse decrese

        iv_pdetail_quantity_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // holder.iv_cart_quantity_increase.setEnabled(false);

                // int textqut = Integer.parseInt(holder.tv_cart_quantity_total.getText().toString());

                //quantity = textqut + 1;
                // int Result = textqut + 1;
                textqut = textqut + 1;
                //  itemid_cart = cart_model.ge();
                // quoteid_cart = Login_preference.getquote_id(context);
                Log.e("result",""+textqut);
                tv_pdetail_quantity_total.setText(String.valueOf(textqut));

            }
        });

        iv_pdetail_quantity_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  holder.iv_cart_quantity_decrease.setEnabled(false);
                // int textqut = Integer.parseInt(holder.tv_cart_quantity_total.getText().toString());
                //   int textqut = 1;
                // itemid_cart = cart_model.getItemid();
                // quoteid_cart = Login_preference.getquote_id(context);
                if (textqut != 0) {
                    // int Result = textqut - 1;
                    textqut = textqut - 1;
                    if (textqut == 0) {
                        textqut = 1;
                        Log.e("result",""+textqut);
                        tv_pdetail_quantity_total.setText(String.valueOf(textqut));
                        //   callAppUpdateCart(Result, itemid_cart, quoteid_cart, view, holder);
                        // product_total = product_total - current_price;
                    } else {
                        Log.e("result",""+textqut);
                        tv_pdetail_quantity_total.setText(String.valueOf(textqut));
                        //  callAppUpdateCart(Result, itemid_cart, quoteid_cart, view, holder);
                    }
                } else {
                }
            }
        });

        return v;
    }

    private void CALL_product_detail_API() {
        for (int i = 0; i < 5; i++) {
            product_details_images_models.add(new Product_Details_images_Model(""));
        }

        product_details_images_adapter.notifyDataSetChanged();

    }

    private void AllocateMemory(View v) {
        toolbar_prod_details = (android.support.v7.widget.Toolbar) v.findViewById(R.id.toolbar_prod_details);
        recyclerview_pro_det_images = (RecyclerView) v.findViewById(R.id.recyclerview_pro_det_images);

        product_details_images_adapter = new Product_Details_Images_Adapter(getActivity(), product_details_images_models);
        recyclerview_pro_det_images.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerview_pro_det_images.setAdapter(product_details_images_adapter);

        iv_pdetail_quantity_increase = (ImageView) v.findViewById(R.id.iv_pdetail_quantity_increase);
        iv_pdetail_quantity_decrease = (ImageView) v.findViewById(R.id.iv_pdetail_quantity_decrease);
        tv_pdetail_quantity_total = (TextView) v.findViewById(R.id.tv_pdetail_quantity_total);
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
        tv_pro_to_title = (TextView) v.findViewById(R.id.tv_pro_to_title);

    }

    private void setTypeface() {

        if (lang_flag.equals("0")){
            text_order_id.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_wishlist.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_share.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_green.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_add_det_title.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_add_details.setTypeface(Navigation_drawer_activity.cairo_regular);
            tv_store.setTypeface(Navigation_drawer_activity.cairo_regular);
            tv_status_title.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_status.setTypeface(Navigation_drawer_activity.cairo_regular);
            tv_bethe.setTypeface(Navigation_drawer_activity.cairo_semibold);
            tv_write_rev.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_store_title.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_add_to_wishlist.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_add_to_cart.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_pro_to_title.setTypeface(Navigation_drawer_activity.cairo_bold);
            Navigation_drawer_activity.tv_nav_title.setTypeface(Navigation_drawer_activity.cairo_bold);
        }else {
            text_order_id.setTypeface(Navigation_drawer_activity.roboto_black);
            tv_wishlist.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_share.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_green.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_add_det_title.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_pro_to_title.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_add_details.setTypeface(Navigation_drawer_activity.roboto_regular);
            tv_store.setTypeface(Navigation_drawer_activity.roboto_regular);
            tv_status_title.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_status.setTypeface(Navigation_drawer_activity.roboto_regular);
            tv_bethe.setTypeface(Navigation_drawer_activity.roboto_medium);
            tv_write_rev.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_store_title.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_add_to_wishlist.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_add_to_cart.setTypeface(Navigation_drawer_activity.cairo_bold);
            Navigation_drawer_activity.tv_nav_title.setTypeface(Navigation_drawer_activity.cairo_bold);
        }
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
