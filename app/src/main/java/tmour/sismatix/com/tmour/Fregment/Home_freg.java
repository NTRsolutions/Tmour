package tmour.sismatix.com.tmour.Fregment;


import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
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

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;
import tmour.sismatix.com.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_freg extends Fragment {
    Spinner spinner_home_area;
    ImageView iv_home_location;
    LinearLayout lv_location_home,lv_home_find_store,lv_home_login;
    TextView tv_find_store,tv_home_login;

    View view;

    public Home_freg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_freg, container, false);
        setHasOptionsMenu(true);
        Navigation_drawer_activity.toolbar.setTitle("");
        Allocate_Memory(view);

        return view;
    }

    private void Allocate_Memory(View view) {

        spinner_home_area=(Spinner)view.findViewById(R.id.spinner_home_area);
        iv_home_location=(ImageView)view.findViewById(R.id.iv_home_location);
        lv_location_home=(LinearLayout)view.findViewById(R.id.lv_location_home);
        lv_home_find_store=(LinearLayout)view.findViewById(R.id.lv_home_find_store);
        lv_home_login=(LinearLayout)view.findViewById(R.id.lv_home_login);
        tv_find_store=(TextView)view.findViewById(R.id.tv_find_store);
        tv_home_login=(TextView)view.findViewById(R.id.tv_home_login);

        tv_find_store.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_home_login.setTypeface(Navigation_drawer_activity.roboto_bold);


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
    // cart menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:

                pushFragment(new Search_freg(),"Search");
                return true;

            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
