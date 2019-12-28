package com.digitalbrandoptimization;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Enquiry.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        try {
            firebaseAuth = FirebaseAuth.getInstance();
            user = firebaseAuth.getCurrentUser();

            if (user == null ) {
                //login checked activity here
                finish();
                startActivity(new Intent(MainActivity.this, Login.class));

            }

            View mHeaderView;
            mHeaderView = navigationView.getHeaderView(0);
            ( (TextView) mHeaderView.findViewById(R.id.nav_header_subtitle)).setText(firebaseAuth.getCurrentUser().getEmail());

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),(firebaseAuth.getCurrentUser().getEmail()+"\n"+ex.toString()),Toast.LENGTH_SHORT).show();}
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_aboutus) {
           startActivity(new Intent(getApplicationContext(),Aboutus.class));
        } else if (id == R.id.nav_CorpoarteEvents) {
            startActivity(new Intent(getApplicationContext(),CorpoarteEvents.class));
        }
        else if (id == R.id.nav_ExhibitionsManagement) {
            startActivity(new Intent(getApplicationContext(),ExhibitionsManagement.class));
        } else if (id == R.id.nav_Branding) {
          startActivity(new Intent(getApplicationContext(),Branding.class));
        } else if (id == R.id.nav_ExhibitionConsulting) {
            startActivity(new Intent(getApplicationContext(),ExhibitionConsulting.class));
        } else if (id == R.id.nav_Partners) {
            startActivity(new Intent(getApplicationContext(),Partners.class));
        }
        else if (id == R.id. nav_Awards) {
            startActivity(new Intent(getApplicationContext(),Awards.class));
        }
       else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),Login.class));
        }
        else if(id==R.id.feedback)
        {
            startActivity(new Intent(getApplicationContext(),Feedback.class));
        }
        else if(id==R.id.profile)
        {
            startActivity(new Intent(getApplicationContext(),profile.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
