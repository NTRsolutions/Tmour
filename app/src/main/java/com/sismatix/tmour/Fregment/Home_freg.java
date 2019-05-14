package com.sismatix.tmour.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class Home_freg extends Fragment implements View.OnClickListener {
    Spinner spinner_home_area;
    ImageView iv_home_location;
    LinearLayout lv_location_home,lv_home_find_store,lv_home_login;
    TextView tv_find_store,tv_home_login;
    String lang_flag;

    View view;

    public Home_freg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_freg, container, false);
        lang_flag=Login_preference.get_Lang_flag(getActivity());
        Allocate_Memory(view);
        Navigation_drawer_activity.toolbar.setTitle("");
        Navigation_drawer_activity.tv_nav_title.setVisibility(View.GONE);
        Log.e("login_51 ",""+lang_flag);

        setTypeface();
        lv_home_login.setOnClickListener(this);


        return view;
    }

    private void setTypeface() {
        if (lang_flag.equals("0")){
            tv_find_store.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_home_login.setTypeface(Navigation_drawer_activity.cairo_bold);
        }else {
            tv_find_store.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_home_login.setTypeface(Navigation_drawer_activity.roboto_bold);
        }

    }

    private void Allocate_Memory(View view) {

        spinner_home_area=(Spinner)view.findViewById(R.id.spinner_home_area);
        iv_home_location=(ImageView)view.findViewById(R.id.iv_home_location);
        lv_location_home=(LinearLayout)view.findViewById(R.id.lv_location_home);
        lv_home_find_store=(LinearLayout)view.findViewById(R.id.lv_home_find_store);
        lv_home_login=(LinearLayout)view.findViewById(R.id.lv_home_login);
        tv_find_store=(TextView)view.findViewById(R.id.tv_find_store);
        tv_home_login=(TextView)view.findViewById(R.id.tv_home_login);

        String[] countries=getResources().getStringArray(R.array.theme_array);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.spinner_layout,R.id.text, countries);
        spinner_home_area.setAdapter(adapter);

    }


    private void pushFragment(Fragment fragment, String add_to_backstack) {
        if (fragment == null)
            return;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.main_fram_layout, fragment);
                ft.addToBackStack(add_to_backstack);
                ft.commit();
            }
        }
    }
   /* public void onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        menu.findItem(R.id.search).setEnabled(true);
        super.onCreateOptionsMenu(menu,inflater);
    }
*/


   /* @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.search);
        if(item!=null)
            item.setVisible(true);
    }
    *//*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
         inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }*//*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                pushFragment(new Search_freg(),"Search");
                //Toast.makeText(getActivity(), "cart Icon Click", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
    @Override
    public void onClick(View view) {
        if(view==lv_home_login)
        {
            pushFragment(new Login_freg(),"login");

        }
    }
}
