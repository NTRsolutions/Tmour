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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Activity.RecyclerItemClickListener;
import com.sismatix.tmour.Adapter.Product_Details_Images_Adapter;
import com.sismatix.tmour.CheckNetwork;
import com.sismatix.tmour.Model.Product_Details_images_Model;
import com.sismatix.tmour.R;
import com.sismatix.tmour.Retrofit.ApiClient;
import com.sismatix.tmour.Retrofit.ApiInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetails extends Fragment {

    android.support.v7.widget.Toolbar toolbar_prod_details;
    RecyclerView recyclerview_pro_det_images;
    private static List<Product_Details_images_Model> product_details_images_models = new ArrayList<Product_Details_images_Model>();
    private static Product_Details_Images_Adapter product_details_images_adapter;
    ImageView iv_main;

    TextView text_order_id, tv_wishlist, tv_share, tv_add_det_title, tv_add_details, tv_store_title, tv_store,
            tv_status_title, tv_status, tv_bethe, tv_write_rev, tv_green, tv_add_to_cart, tv_add_to_wishlist;

    String posss;
    Bundle bundle;

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

        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            callprod_details_imagesApi();
        } else {
            Toast.makeText(getContext(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }
        if(bundle!=null){
            String image_uel = bundle.getString("image_uel");
            Log.e("image_uellll",""+image_uel);
        }
        recyclerview_pro_det_images.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerview_pro_det_images, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.e("imagee_poss",""+position);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );

        return v;
    }

    private void callprod_details_imagesApi() {

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        final Call<ResponseBody> wishlist = api.getimages();
        wishlist.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("responseeeeee_wishlist", "" + response.body().toString());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response.body().string());
                    String contacts = jsonObject.getString("contacts");
                    Log.e("status_con", "" + contacts);

                    JSONArray jsonArray = jsonObject.getJSONArray("contacts");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {

                            JSONObject contacts_object = jsonArray.getJSONObject(i);

                            String name = contacts_object.getString("name");
                            Log.e("nameeee", "" + name);

                            product_details_images_models.add(new Product_Details_images_Model(contacts_object.getString("profile_pic")));
                        } catch (Exception e) {
                            Log.e("Exception", "" + e);
                        } finally {
                            product_details_images_adapter.notifyDataSetChanged();
                        }
                    }

                } catch (Exception e) {
                    Log.e("", "" + e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        /*for (int i = 0; i < 5; i++) {
            product_details_images_models.add(new Product_Details_images_Model(""));
        }

        product_details_images_adapter.notifyDataSetChanged();*/
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

        iv_main = (ImageView)v.findViewById(R.id.iv_main);

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
