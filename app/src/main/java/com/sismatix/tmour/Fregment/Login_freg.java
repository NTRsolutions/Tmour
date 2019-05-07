package com.sismatix.tmour.Fregment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login_freg extends Fragment implements View.OnClickListener {

    View view;
    TextView tv_create_account, tv_forgot_password, tv_login, tv_already_have_an_account, tv_google;
    TextInputLayout layout_login_email, layout_login_password;
    TextInputEditText et_password_login;
    EditText et_Email_login;
    LinearLayout linear_parent,google_login;
    android.support.v7.widget.Toolbar toolbar_login;

    public Login_freg() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login_freg, container, false);

        AllocateMemory(view);
        setupUI(linear_parent);
        setHasOptionsMenu(true);

        Navigation_drawer_activity.changeToolbarFont(toolbar_login,getActivity());

        toolbar_login.setTitle(getResources().getString(R.string.login));
        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_login);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        tv_create_account.setOnClickListener(this);

        return view;
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
        google_login = (LinearLayout)view.findViewById(R.id.google_login);
        tv_create_account = (TextView) view.findViewById(R.id.tv_create_account);
        tv_google = (TextView) view.findViewById(R.id.tv_google);

        linear_parent = (LinearLayout) view.findViewById(R.id.linear_parent);
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
}
