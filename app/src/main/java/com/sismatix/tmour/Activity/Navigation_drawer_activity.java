package com.sismatix.tmour.Activity;

import android.app.Activity;
import android.app.NativeActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import com.sismatix.tmour.CustomTypefaceSpan;
import com.sismatix.tmour.Fregment.About_date_street_freg;
import com.sismatix.tmour.Fregment.Cart_freg;
import com.sismatix.tmour.Fregment.Checkout;
import com.sismatix.tmour.Fregment.Home_freg;
import com.sismatix.tmour.Fregment.Login_freg;
import com.sismatix.tmour.Fregment.My_account_freg;
import com.sismatix.tmour.Fregment.My_order_freg;
import com.sismatix.tmour.Fregment.Offers_freg;
import com.sismatix.tmour.Fregment.OrderDetails;
import com.sismatix.tmour.Fregment.ProductDetails;
import com.sismatix.tmour.Fregment.Product_freg;
import com.sismatix.tmour.Fregment.Search_freg;
import com.sismatix.tmour.Fregment.Store_freg;
import com.sismatix.tmour.Fregment.Wishlist_freg;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;

public class Navigation_drawer_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    public static Toolbar toolbar;
    NavigationView navigationView;
    public BottomNavigationView bottom_navigation;
    public static AssetManager am;
    public static Typeface roboto_bold, roboto_black, roboto_bold_conndensed, roboto_light, roboto_regular, roboto_thin, roboto_medium, cairo_bold;
    boolean doubleBackToExitPressedOnce = false;

    ImageView iv_nav_setting, iv_nav_profile;
    TextView tv_nav_username;
    Spinner spinner;
    String[] language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Allocate_MEMORY();
        //lang_arbi();
        SET_FONT_STYLE();
        setSupportActionBar(toolbar);
        setFont_family_to_Menu();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        changeToolbarFont(toolbar, Navigation_drawer_activity.this);


        navigationView.setNavigationItemSelectedListener(this);

        Bootom_Navigation_view();

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                } else {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                }
            }
        });


        ///spinner----------------
        language = getResources().getStringArray(R.array.language_array);

        spinner = (Spinner) navigationView.getMenu().findItem(R.id.navigation_drawer_item3).getActionView();
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, language));

        spinner.setSelection(1,true);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(Navigation_drawer_activity.this, language[position], Toast.LENGTH_SHORT).show();

                String selected_value= String.valueOf(spinner.getSelectedItem());
                Log.e("selected_item",""+selected_value);

                if(selected_value.equals("English")==true){
                    lang_english();
                    Login_preference.set_Lang_flag(Navigation_drawer_activity.this,"1");

                    Intent intent = new Intent(Navigation_drawer_activity.this, Navigation_drawer_activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    drawer.closeDrawer(GravityCompat.START);

                }else if(selected_value.equals("Arabic")==true){
                    lang_arbi();
                    Login_preference.set_Lang_flag(Navigation_drawer_activity.this,"0");

                    Intent intent = new Intent(Navigation_drawer_activity.this, Navigation_drawer_activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    drawer.closeDrawer(GravityCompat.START);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void lang_arbi() {
        String languageToLoad = "ar";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());
    }

    private void lang_english() {
        String languageToLoad = "en";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());
    }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "RobotoBold.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    private void setFont_family_to_Menu() {

        Menu menu = navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem mi = menu.getItem(i);
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }
//the method we have create in activity
            applyFontToMenuItem(mi);
        }
    }

    public static void changeToolbarFont(Toolbar toolbar, Activity context) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View view = toolbar.getChildAt(i);
            if (view instanceof TextView) {
                TextView tv = (TextView) view;
                if (tv.getText().equals(toolbar.getTitle())) {
                    applyFont(tv, context);
                    break;
                }
            }
        }
    }

    public static void applyFont(TextView tv, Activity context) {
        tv.setTypeface(Navigation_drawer_activity.roboto_bold);
        //tv.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/customFont"));
    }

    private void Allocate_MEMORY() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        bottom_navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        View header = navigationView.getHeaderView(0);
        iv_nav_setting = (ImageView) header.findViewById(R.id.iv_nav_setting);
        iv_nav_profile = (ImageView) header.findViewById(R.id.iv_nav_profile);
        tv_nav_username = (TextView) header.findViewById(R.id.tv_nav_username);

        tv_nav_username.setTypeface(Navigation_drawer_activity.roboto_bold);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    private void SET_FONT_STYLE() {
        am = getApplicationContext().getAssets();

        roboto_bold = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "RobotoBold.ttf"));
        roboto_black = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "RobotoBlack.ttf"));
        roboto_bold_conndensed = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "RobotoCondensed.ttf"));
        roboto_thin = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "RobotoThin.ttf"));
        roboto_medium = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "RobotoMedium.ttf"));
        roboto_light = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "RobotoLight.ttf"));
        roboto_regular = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "RobotoRegular.ttf"));
        cairo_bold = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "cairobold.ttf"));

    }

    private void Bootom_Navigation_view() {

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        BottomNavigationViewHelper.disableShiftMode(bottom_navigation);

        Menu menu = bottom_navigation.getMenu();
        selectFragment(menu.getItem(0));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectFragment(item);
            return false;
        }
    };

    private void selectFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.bottom_nav_home:
                Home_freg fragment = new Home_freg();

                if (fragment == null)
                    return;
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (fragmentManager != null) {
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    if (ft != null) {
                        ft.replace(R.id.main_fram_layout, fragment);
                        ft.commit();
                    }
                }

                break;
            case R.id.bottom_nav_product:
                pushFragment(new Product_freg(), "product");//OrderDetails()
                break;
            case R.id.bottom_nav_cart:
                pushFragment(new Cart_freg(), "cart");
                break;

            case R.id.bottom_nav_favourite:
                pushFragment(new Wishlist_freg(), "wishlist");//Wishlist_freg()

                break;
            case R.id.bottom_nav_myaccount:
                pushFragment(new Login_freg(), "My Account");
              /*  if(Login_preference.getLogin_flag(Navigation_activity.this).equalsIgnoreCase("1")) {
                    pushFragment(new Edit_premium_lawyer_profile(),"Edit_profile");

                }else {
                    pushFragment(new Login_freg(),"login");
                }
*/

        }
    }

    private void pushFragment(Fragment fragment, String add_to_backstack) {
        if (fragment == null)
            return;
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.main_fram_layout, fragment);
                ft.addToBackStack(add_to_backstack);
                ft.commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //   menu.clear();
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.search:
                pushFragment(new Search_freg(), "Search");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            pushFragment(new Home_freg(), "home");

        } else if (id == R.id.nav_my_order) {
            pushFragment(new My_order_freg(), "My order");

        } else if (id == R.id.nav_offers) {
            pushFragment(new Offers_freg(), "offer");

        } else if (id == R.id.nav_stores) {
            pushFragment(new Store_freg(), "store");

        } else if (id == R.id.nav_about_datestreet) {
            pushFragment(new About_date_street_freg(), "about");

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int count = fragmentManager.getBackStackEntryCount();
        if (count == 1) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                super.finish();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            String title = fragmentManager.getBackStackEntryAt(count - 2).getName();
            super.onBackPressed();
            Log.e("onBackPressetitle", "" + title);
        }
    }


}
