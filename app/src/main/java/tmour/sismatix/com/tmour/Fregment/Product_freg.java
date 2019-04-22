package tmour.sismatix.com.tmour.Fregment;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;
import tmour.sismatix.com.tmour.Adapter.TAb_PAGER_Adapter;
import tmour.sismatix.com.tmour.CheckNetwork;
import tmour.sismatix.com.tmour.Model.Librarytablist_model;
import tmour.sismatix.com.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Product_freg extends Fragment implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener{

    AppBarLayout appbar_product;
    CollapsingToolbarLayout collapsing_toolbar;
    Toolbar toolbar;
    ImageView iv_product_header;
    android.support.v7.widget.Toolbar toolbar_product;
    View view;
    TabLayout tabs;
    ViewPager pager;
    private ArrayList<Librarytablist_model> category_list;
    //MainPagerAdapter adapter;
    //CharSequence Titles[] = {"TAB 1", "TAB 2"};
    private int noOfTabs = 10;

    public Product_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_product_freg, container, false);

        Allocate_Memory(view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar_product);

        setHasOptionsMenu(true);

        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_product);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        /*collapsing_toolbar.setTitle(getResources().getString(R.string.dates_street));
        collapsing_toolbar.setCollapsedTitleTypeface(Navigation_drawer_activity.roboto_bold);
        collapsing_toolbar.setExpandedTitleTypeface(Navigation_drawer_activity.roboto_bold);*/

        //setUpTabs();

        category_list = new ArrayList<>();

        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            CALL_CATEGORYLIST_API();
        } else {
            Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
        }

        pager.addOnPageChangeListener(this);
        tabs.addOnTabSelectedListener(this);

        return view;
    }

    private void CALL_CATEGORYLIST_API() {
       /* category_list.clear();
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> category_list_api = api.get_category_list();

        category_list_api.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("response_category", "" + response.body().toString());
                //   progressBar_home.setVisibility(View.GONE);
                JSONObject jsonObject = null;
                try {

                    jsonObject = new JSONObject(response.body().string());
                    String status = jsonObject.getString("status");
                    Log.e("status_prod_cat", "" + status);
                    String message = jsonObject.getString("msg");
                    Log.e("message", "" + message);
                    if (status.equalsIgnoreCase("success")) {
                        JSONArray data_array = jsonObject.getJSONArray("data");

                        for (int i = 0; i < data_array.length(); i++) {

                            try {

                                JSONObject category_object = data_array.getJSONObject(i);
                                Log.e("cat_main_title", "" + category_object.getString("category_title"));

                                Librarytablist_model model = new Librarytablist_model(category_object.getString("category_id"), category_object.getString("category_title"));
                                category_list.add(model);

                                Log.e("cat_list", "" + category_list);

                            } catch (Exception e) {
                                Log.e("Exception", "" + e);
                            } finally {
                            }

                        }
                        setUpViewPager();
                        tabs.setupWithViewPager(pager);

                     *//*   tabs.post(new Runnable() {
                            @Override
                            public void run() {
                                tabs.setupWithViewPager(pager);
                            }
                        });*//*

                        //   viewPager.setCurrentItem(0);

                        //setUpCustomTabs();

                    } else if (status.equalsIgnoreCase("error")) {

                    }

                } catch (Exception e) {
                    Log.e("", "" + e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

*/
        for (int i = 0; i < 10; i++) {
            Librarytablist_model model = new Librarytablist_model("1", "abc");
            category_list.add(model);
        }

        setUpViewPager();
        tabs.setupWithViewPager(pager);

    }

    private void Allocate_Memory(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        pager = (ViewPager) view.findViewById(R.id.pager);
        appbar_product = (AppBarLayout) view.findViewById(R.id.appbar_product);
        collapsing_toolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapse_toolbar);
        iv_product_header = (ImageView) view.findViewById(R.id.iv_product_header);
        toolbar_product = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar_product);
        tabs = (TabLayout) view.findViewById(R.id.tabs);
    }

    private void setUpViewPager() {
        TAb_PAGER_Adapter adapter = new TAb_PAGER_Adapter(getChildFragmentManager());
        Dynamic_Product_freg fView;
        for (int i = 0; i < category_list.size(); i++) {
            fView = new Dynamic_Product_freg();
            adapter.addFrag(fView, category_list.get(i));
            Log.e("tabtt", "" + category_list.get(i));
        }
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(category_list.size());

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.store_info_menu, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.info:
                //Toast.makeText(getActivity(), "cart Icon Click", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search_menu:
                return true;
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Log.e("tabtitle", "" + tab.getText().toString());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
