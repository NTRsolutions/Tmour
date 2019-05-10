package com.sismatix.tmour.Fregment;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.sismatix.tmour.Activity.WrapContentLinearLayoutManager;
import com.sismatix.tmour.Adapter.Library_adapter;
import com.sismatix.tmour.CheckNetwork;
import com.sismatix.tmour.Model.Library_model;
import com.sismatix.tmour.R;
import com.sismatix.tmour.Retrofit.ApiClient;
import com.sismatix.tmour.Retrofit.ApiInterface;

public class Dynamic_Product_freg extends Fragment {

    private static final String ARG_CATEGORY_ID = "section_number";
    private static final String ARG_CATEGORY_TITLE = "category_title";
    private static final String ARG_VISIBLE = "visible";

    public static List<Library_model> itemArrayList = new ArrayList<Library_model>();
    private RecyclerView recycler_product_list;

    private Library_adapter adapter;
    private String category_id, category_title;
    private ProgressBar progressBar_library,progressBar_bottom_library;
    private TextView tvNoDataFound;

    private boolean isVisible;
    public static List<String> cat_id_list = new ArrayList<String>();
    TextView textView;

    NestedScrollView nested_scroll_library;
    WrapContentLinearLayoutManager layoutManager;
    //varible for pagination
    int page_no=1,page;

    public static Dynamic_Product_freg newInstance(String sectionNumber, boolean visible, String category_title) {
        Dynamic_Product_freg fragment = new Dynamic_Product_freg();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY_ID, sectionNumber);
        args.putBoolean(ARG_VISIBLE, visible);
        args.putString(ARG_CATEGORY_TITLE, category_title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dynamic_product, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cat_id_list.clear();
        ALLOCATEMEMORY(view);

        if (getArguments() != null) {
            category_id = getArguments().getString(ARG_CATEGORY_ID, "");
            isVisible = getArguments().getBoolean(ARG_VISIBLE, false);
            category_title = getArguments().getString(ARG_CATEGORY_TITLE, "");
        }

        cat_id_list.add(category_id);
        Log.e("Tab_service_114", "" + category_id);
        textView.setText(category_id + " =" + category_title);

        for (int i = 0; i < cat_id_list.size(); i++) {

            Log.e("service_else_143", "" + cat_id_list.get(i));

            if (CheckNetwork.isNetworkAvailable(getActivity())) {
                CALL_product_LIST_API(cat_id_list.get(i),page_no);
            } else {
                Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
            }

        }
        cat_id_list.clear();

    }

    private void CALL_product_LIST_API(String category_id1, int page_no) {
        Log.e("category_id_108", "" + category_id1);
        itemArrayList.clear();
        progressBar_library.setVisibility(View.VISIBLE);

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> get_library_list = api.get_library_list(String.valueOf(page_no), ApiClient.PER_PAGE, category_id1, ApiClient.user_status);
        page=page_no;
        Log.e("page_140", "" + page);

        get_library_list.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                Log.e("response ", "" + response.body().toString());
                progressBar_library.setVisibility(View.GONE);

                try {
                    if (response.isSuccessful()) {
                        itemArrayList.clear();
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        String status = jsonObject.getString("status");
                        String message = jsonObject.getString("msg");
                        recycler_product_list.setVisibility(View.VISIBLE);
                        tvNoDataFound.setVisibility(View.GONE);

                        Log.e("status_library", "" + status);
                        if (status.equalsIgnoreCase("success")) {
                            JSONArray jsonArray = new JSONArray(jsonObject.getString("data"));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String library_id = object.getString("library_id");
                                Log.e("library_id", "" + library_id);
                                Log.e("library_description", "" + object.getString("library_description"));
                                String library_title = object.getString("library_title");
                                String library_link = object.getString("library_link");
                                String category_id = object.getString("category_id");
                                String library_status = object.getString("library_status");

                                String date = object.getString("library_created_at_format_day") + " " +
                                        object.getString("library_created_at_format_month") + " " +
                                        object.getString("library_created_at_format_year");

                                Library_model model = new Library_model(library_id,
                                        library_title,
                                        library_link,
                                        category_id,
                                        date,
                                        library_status, object.getString("library_description"));

                                itemArrayList.add(model);
                            }

                            adapter = new Library_adapter(getActivity(), itemArrayList);
                            layoutManager=new WrapContentLinearLayoutManager(getActivity());
                            recycler_product_list.setLayoutManager(layoutManager);
                            recycler_product_list.setAdapter(adapter);
                            Log.e("model_size_200",""+itemArrayList.size());
                            if (itemArrayList.size() == 0) {
                                tvNoDataFound.setVisibility(View.VISIBLE);
                            } else {
                                tvNoDataFound.setVisibility(View.GONE);
                            }

                        } else {

                            //recyclerviewSubCategory.setVisibility(View.GONE);
                            tvNoDataFound.setText(message);
                            tvNoDataFound.setVisibility(View.VISIBLE);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    progressBar_library.setVisibility(View.GONE);
                    Log.e("exception", "" + e.getLocalizedMessage());
                  //  Toast.makeText(getActivity(), "" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    //  Utils.showErrorSnackBar(getView().getRootView(), e.getLocalizedMessage(), Snackbar.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                progressBar_library.setVisibility(View.GONE);
               // Toast.makeText(getActivity(), "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Failure", "" + t.getLocalizedMessage());
            }
        });
    }

   /* private void CALL_product_LIST_API(String s, int page_no) {

        for(int i=0;i<10;i++)
        {
            Product_List_Model model = new Product_List_Model("","","","");

            itemArrayList.add(model);
        }

    }*/

    public  void lang_arbi() {
        String languageToLoad = "ar";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());
    }

    private void ALLOCATEMEMORY(View view) {
        textView = (TextView) view.findViewById(R.id.textView);
        //recycler view
        recycler_product_list = view.findViewById(R.id.recycler_product_list);
        //progress bar
        progressBar_library = view.findViewById(R.id.progressBar_library);
        progressBar_bottom_library = view.findViewById(R.id.progressBar_bottom_library);
        nested_scroll_library =(NestedScrollView) view.findViewById(R.id.nested_scroll_library);
        //text view
        tvNoDataFound = view.findViewById(R.id.tv_data_not_found_library);
        }

}
