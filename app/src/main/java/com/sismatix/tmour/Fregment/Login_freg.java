package com.sismatix.tmour.Fregment;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.CheckNetwork;
import com.sismatix.tmour.Preference.Login_preference;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class Login_freg extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    View view;
    TextView tv_create_account,tv_login_to_title, tv_forgot_password, tv_login, tv_already_have_an_account, tv_google;
    TextInputLayout layout_login_email, layout_login_password;
    TextInputEditText et_password_login;
    EditText et_Email_login;
    LinearLayout linear_parent,google_login;
    android.support.v7.widget.Toolbar toolbar_login;
    private GoogleApiClient googleApiClient;

    public static final int SIGN_IN_CODE = 777;
    String gname, gid, gemail, gphoto;
    String googlefirstname, googlelastname, googlemiddlename, locationid_wish;
    String lang_flag;

    public Login_freg() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login_freg, container, false);
        lang_flag = Login_preference.get_Lang_flag(getContext());

        AllocateMemory(view);
        setupUI(linear_parent);
        setHasOptionsMenu(true);
        setTypface();

      //  Navigation_drawer_activity.changeToolbarFont(toolbar_login,getActivity());
        tv_login_to_title.setText(getResources().getString(R.string.login));
        // toolbar_login.setTitle(getResources().getString(R.string.login));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_login);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);




        tv_create_account.setOnClickListener(this);

        GOOGLE_LOGIN();



        return view;
    }

    private void setTypface() {
        if (lang_flag.equals("0")){
            tv_already_have_an_account.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_forgot_password.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_login.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_create_account.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_google.setTypeface(Navigation_drawer_activity.cairo_bold);
            layout_login_email.setTypeface(Navigation_drawer_activity.cairo_bold);
            layout_login_password.setTypeface(Navigation_drawer_activity.cairo_bold);
            tv_login_to_title.setTypeface(Navigation_drawer_activity.cairo_bold);

            tv_google.setGravity(Gravity.RIGHT);
        }else {
            tv_already_have_an_account.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_forgot_password.setTypeface(Navigation_drawer_activity.roboto_regular);
            tv_login.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_create_account.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_google.setTypeface(Navigation_drawer_activity.roboto_bold);
            layout_login_email.setTypeface(Navigation_drawer_activity.roboto_regular);
            layout_login_password.setTypeface(Navigation_drawer_activity.roboto_regular);
            tv_login_to_title.setTypeface(Navigation_drawer_activity.roboto_bold);
            tv_google.setGravity(Gravity.LEFT);
        }

    }

    private void GOOGLE_LOGIN() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(getActivity())
                .enableAutoManage(getActivity(), this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        google_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, SIGN_IN_CODE);
            }
        });

    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(getActivity());
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void AllocateMemory(View view) {
        toolbar_login = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar_login);
        tv_already_have_an_account = (TextView) view.findViewById(R.id.tv_already_have_an_account);
        tv_forgot_password = (TextView) view.findViewById(R.id.tv_forgot_password);
        tv_login = (TextView) view.findViewById(R.id.tv_login);
        tv_create_account = (TextView) view.findViewById(R.id.tv_create_account);
        tv_google = (TextView) view.findViewById(R.id.tv_google);
        tv_login_to_title = (TextView) view.findViewById(R.id.tv_login_to_title);

        linear_parent = (LinearLayout) view.findViewById(R.id.linear_parent);
        google_login = (LinearLayout) view.findViewById(R.id.google_login);
        layout_login_email = (TextInputLayout) view.findViewById(R.id.layout_login_email);
        layout_login_password = (TextInputLayout) view.findViewById(R.id.layout_login_password);
        et_password_login = (TextInputEditText) view.findViewById(R.id.et_password_login);
        et_Email_login = (EditText) view.findViewById(R.id.et_Email_login);

        tv_already_have_an_account.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_forgot_password.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_login.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_create_account.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_google.setTypeface(Navigation_drawer_activity.roboto_bold);
        layout_login_email.setTypeface(Navigation_drawer_activity.roboto_regular);
        layout_login_password.setTypeface(Navigation_drawer_activity.roboto_regular);


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case android.R.id.home:
                // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
                // if this doesn't work as desired, another possibility is to call `finish()` here.
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        // inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
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

    @Override
    public void onClick(View view) {
        if(view==tv_create_account)
        {
            pushFragment(new Register_freg(),"register");

        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
            Log.e("resultofgoogle", "" + result);
        }

    }

    private void handleSignInResult(GoogleSignInResult result) {

        /*if (result.isSuccess()) {
            goMainScreen();
        } else {
            Toast.makeText(getContext(), R.string.not_log_in, Toast.LENGTH_SHORT).show();
        }*/

        if (result.isSuccess()) {

            GoogleSignInAccount account = result.getSignInAccount();

            gname = account.getDisplayName();
            gemail = account.getEmail();
            gid = account.getId();
            gphoto = String.valueOf(account.getPhotoUrl());

            Log.e("gimgl", "" + gphoto);
            Log.e("gnamel", "" + gname);
            Log.e("gemaill", "" + gemail);
            Log.e("gidl", "" + gid);
            Log.e("gtokenidl", "" + account.getIdToken());
            Log.d("gname", "" + gname);

            if (gphoto.equals("null") == true || gphoto.equals(null) == true) {
                Log.e("gimgnull", "" + gphoto);
                gphoto = "";
            } else {
                Log.e("gim", "" + gphoto);
            }

            Log.d("gnameLength-->", "" + gname);

            if (gname != null) {
                Log.e("gnameLength_283", "" + gname);

                String[] parts = gname.split("\\s+");

                Log.d("Length-->", "" + parts.length);
                if (parts.length == 2) {
                    googlefirstname = parts[0];
                    googlelastname = parts[1];
                    Log.d("First-->", "" + googlefirstname);
                    Log.d("Last-->", "" + googlelastname);
                } else if (parts.length == 3) {
                    googlefirstname = parts[0];
                    googlemiddlename = parts[1];
                    googlelastname = parts[2];
                    Log.d("First-->", "" + googlefirstname);
                    Log.d("Last-->", "" + googlelastname);
                }

            } else {
                Log.e("gnameLength_283_null", "" + gname);
                googlefirstname = "";
                googlelastname = "";
                googlemiddlename = "";
            }

            pushFragment(new Home_freg(),"Home");

            /*if (CheckNetwork.isNetworkAvailable(getActivity())) {
                Login_preference.setLogin_flag(getActivity(), "1");
                Login_Api(signup_emailid, signup_passwordd);
            } else {
                Toast.makeText(getActivity(), "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
            }*/

            //Login_Api(signup_emailid,signup_passwordd);

        } else {
            Toast.makeText(getContext(), "Not Login", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        if (googleApiClient != null) {
            googleApiClient.connect();
        }
    }

    /* @Override
     public void onPause() {
         super.onPause();
         googleApiClient.stopAutoManage(getActivity());
         googleApiClient.disconnect();
     }
 */
    @Override
    public void onStop() {
        if (googleApiClient != null && googleApiClient.isConnected()) {
            googleApiClient.stopAutoManage((FragmentActivity) getContext());
            googleApiClient.disconnect();
        }
        super.onStop();
    }
}
