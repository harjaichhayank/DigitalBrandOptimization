package com.digitalbrandoptimization;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;
import com.yarolegovich.lovelydialog.LovelyProgressDialog;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.HashMap;

public class Enquiry extends AppCompatActivity {
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuth;
    private EditText mTitleText;
    Button btnDatePicker, btnTimePicker,btnSendEnquiry;
    TextView txtDate;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private DatePickerFragment date = new DatePickerFragment();
    Spinner sLocation,sOccasion;
    private String mDate,mLocation,mOccasion;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    Globals g = Globals.getInstance();


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firebaseAuth = FirebaseAuth.getInstance();
        g.setpName(firebaseAuth.getCurrentUser().getEmail());

       txtDate=(TextView)findViewById(R.id.date_text);

        sLocation=(Spinner)findViewById(R.id.spinnerLocationname);
        sOccasion=(Spinner)findViewById(R.id.spinnerOccasionname);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        init();


    }


    public void setDate(View view) {
        // Get Current Date

      final  TextView textView = (TextView) this.findViewById(R.id.date_text);
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                    Toast.makeText(getApplicationContext(),(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year),Toast.LENGTH_SHORT).show();
                      //  txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        textView.setText((dayOfMonth + "-" + (monthOfYear + 1) + "-" + year) );

                        g.setvDate((dayOfMonth + "-" + (monthOfYear + 1) + "-" + year));

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
//Here Save Tadat
    public void saveEnquiry(View view) {


        sOccasion=this.findViewById(R.id.spinnerOccasionname);
        g.setvOccasion(sOccasion.getSelectedItem().toString());
        if("".equalsIgnoreCase(g.getvDate()))
        {
            Toast.makeText(getApplicationContext(), "Plz Provide the Venu Date \n Swap Left to set Date.", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getApplicationContext(),"sending data",Toast.LENGTH_SHORT).show();
                 HashMap<String, Object> objpayment = new HashMap<String, Object>();
                        objpayment.put("Location", g.getvLocation().toString());
                        objpayment.put("Date",g.getvDate().toString());
                        objpayment.put("Occasion",sOccasion.getSelectedItem().toString());
                        objpayment.put("Email",g.getpName());

                        addData(objpayment);
    }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position)
            {
                case 0:
                    Tab_1 objTab1=new Tab_1();
                    return objTab1;
                case 1:
                    Tab_2 objTab2=new Tab_2();
                    return objTab2;
                case 2:
                    Tab_3 objTab3=new Tab_3();
                    return objTab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:
                    return "Location";
                case 1:
                    return "date";
                case 2:
                    return "occasion";
            }
            return null;
        }
    }
//======================


LovelyProgressDialog dialogWait;
    public void addData(final HashMap object) {
        dialogWait = new LovelyProgressDialog(Enquiry.this);
        dialogWait.show();

        FirebaseDatabase.getInstance().getReference().child("Enquiry/" + firebaseAuth.getCurrentUser().getUid()).push().setValue(object)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            dialogWait.dismiss();

                           startActivity(new Intent(getApplicationContext(),Thanks.class));



//                            new LovelyInfoDialog(Enquiry.this)
//                                    .setTopColorRes(R.color.colorPrimary)
//                                    .setIcon(R.drawable.ic_feedback)
//                                    .setTitle("Success")
//                                    .setMessage("Thank you ")
//                                    .show();

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialogWait.dismiss();
                        new LovelyInfoDialog(Enquiry.this)
                                .setTopColorRes(R.color.colorAccent)
                                // .setIcon(R.drawable.ic_add_friend)
                                .setTitle("False")
                                .setMessage("False to add Data success")
                                .show();
                    }
                });
    }


    private void init() {

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        if (firebaseAuth.getCurrentUser() == null) {
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), Login.class));
            return;
        }
    }
    //This function gets called to make the date picker dialog
    public void showDatePickerDialog(View v){
        date.show(getFragmentManager(), "datePicker");
    }

}
//praveen kumar mandal
