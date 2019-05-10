package com.sismatix.tmour.Fregment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sismatix.tmour.Activity.Navigation_drawer_activity;
import com.sismatix.tmour.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class Register_freg extends Fragment {
    TextInputLayout layout_email_reg,layout_reg_password,layout_reg_confirm_password,layout_firstname_reg,layout_lastname_reg,layout_date_reg;
    EditText edt_reg_email,edt_reg_lastname,edt_reg_firstname,edt_reg_date;
    TextInputEditText edt_reg_password,edt_reg_confirm_password;
    LinearLayout lv_datepicker,lv_register;
    ImageView iv_calender;
    TextView tv_gender,tv_receive_update,tv_subscribe,tv_privacy_policy,tv_register;
    RadioGroup radioGroup;
    RadioButton radio_male,radio_female;
    CheckBox ck_default;
    View view;
    Toolbar toolbar_register;
    int mYear, mMonth, mDay, mHour, mMinute;
    String notime = "", vibrateonoff = "",date_time = "",weekday = "",timeee = "";

    public Register_freg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_register_freg, container, false);
        Allocate_Memory(view);
        setHasOptionsMenu(true);

        Navigation_drawer_activity.changeToolbarFont(toolbar_register,getActivity());

        toolbar_register.setTitle(getResources().getString(R.string.createaccount_small));

        ((Navigation_drawer_activity) getActivity()).setSupportActionBar(toolbar_register);
        ((Navigation_drawer_activity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);


        iv_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker();
            }
        });
      /*  String first = getResources().getString(R.string.By_creating);
        String privacy_policy=getResources().getString(R.string.privacy);
        String next = "<font color='#004ca0'></font>";
        String n = " and ";
        String last = "<font color='#004ca0'>Privacy policy</font>";
*/
        return view;
    }
    private void datePicker() {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        int h = c.get(Calendar.HOUR);
        int m = c.get(Calendar.MINUTE);
        int alertTime = 5;
        m = m + alertTime;


        //  dayofweek=c.get(Calendar.DAY_OF_WEEK);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
                        Date date = new Date(year, monthOfYear, dayOfMonth - 1);
                        weekday = simpledateformat.format(date);
                        weekday = weekday.substring(0, 3);

                        String WholeDay = "" + dayOfMonth;
                        if (WholeDay.length() == 1) {
                            WholeDay = "0" + WholeDay;
                        }

                        String WholeMonth = "" + (monthOfYear + 1);
                        if (WholeMonth.length() == 1)
                            WholeMonth = "0" + WholeMonth;


                        date_time = year + "/" + (WholeMonth) + "/" + WholeDay;
                        Log.e("dateee", "" + date_time);

                        edt_reg_date.setText(date_time);
                        //*************Call Time Picker Here ********************
                        //tiemPicker(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void Allocate_Memory(View view) {

        toolbar_register=(Toolbar)view.findViewById(R.id.toolbar_register);
        layout_email_reg=(TextInputLayout)view.findViewById(R.id.layout_email_reg);
        layout_reg_password=(TextInputLayout)view.findViewById(R.id.layout_reg_password);
        layout_reg_confirm_password=(TextInputLayout)view.findViewById(R.id.layout_reg_confirm_password);
        layout_firstname_reg=(TextInputLayout)view.findViewById(R.id.layout_firstname_reg);
        layout_lastname_reg=(TextInputLayout)view.findViewById(R.id.layout_lastname_reg);
        layout_date_reg=(TextInputLayout)view.findViewById(R.id.layout_date_reg);

        edt_reg_password=(TextInputEditText)view.findViewById(R.id.edt_reg_password);
        edt_reg_confirm_password=(TextInputEditText)view.findViewById(R.id.edt_reg_confirm_password);
        edt_reg_email=(EditText)view.findViewById(R.id.edt_reg_email);
        edt_reg_firstname=(EditText)view.findViewById(R.id.edt_reg_firstname);
        edt_reg_date=(EditText)view.findViewById(R.id.edt_reg_date);
        lv_datepicker=(LinearLayout)view.findViewById(R.id.lv_datepicker);
        lv_register=(LinearLayout)view.findViewById(R.id.lv_register);
        iv_calender=(ImageView)view.findViewById(R.id.iv_calender);

        tv_gender=(TextView)view.findViewById(R.id.tv_gender);
        tv_receive_update=(TextView)view.findViewById(R.id.tv_receive_update);
        tv_subscribe=(TextView)view.findViewById(R.id.tv_subscribe);
        tv_privacy_policy=(TextView)view.findViewById(R.id.tv_privacy_policy);
        tv_register=(TextView)view.findViewById(R.id.tv_register);
        radioGroup=(RadioGroup)view.findViewById(R.id.radioGroup);
        radio_male=(RadioButton)view.findViewById(R.id.radio_male);
        radio_female=(RadioButton)view.findViewById(R.id.radio_female);
        ck_default=(CheckBox)view.findViewById(R.id.ck_default);

        layout_email_reg.setTypeface(Navigation_drawer_activity.roboto_regular);
        layout_reg_password.setTypeface(Navigation_drawer_activity.roboto_regular);
        layout_reg_confirm_password.setTypeface(Navigation_drawer_activity.roboto_regular);
        layout_firstname_reg.setTypeface(Navigation_drawer_activity.roboto_regular);
        layout_lastname_reg.setTypeface(Navigation_drawer_activity.roboto_regular);
        layout_date_reg.setTypeface(Navigation_drawer_activity.roboto_regular);
        edt_reg_password.setTypeface(Navigation_drawer_activity.roboto_regular);
        edt_reg_confirm_password.setTypeface(Navigation_drawer_activity.roboto_regular);
        edt_reg_firstname.setTypeface(Navigation_drawer_activity.roboto_regular);
        edt_reg_date.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_gender.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_subscribe.setTypeface(Navigation_drawer_activity.roboto_regular);
        tv_receive_update.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_privacy_policy.setTypeface(Navigation_drawer_activity.roboto_bold);
        tv_register.setTypeface(Navigation_drawer_activity.roboto_bold);



    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        // inflater.inflate(R.menu.menu_search, menu);
        super.onCreateOptionsMenu(menu, inflater);
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

}
