package com.example.newspaper;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import static com.example.newspaper.R.id.toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_thoi_su:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ThoiSuFragment()).commit();
                break;
            case R.id.nav_startup:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new StartupFragment()).commit();
                break;
            case R.id.nav_the_gioi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_kinh_doanh:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new KinhDoanhFragment()).commit();
                break;
            case R.id.nav_giai_tri:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new GiaiTriFragment()).commit();
                break;
            case R.id.nav_the_thao:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheThaoFragment()).commit();
                break;
            case R.id.nav_phap_luat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PhapLuatFragmnet()).commit();
                break;
            case R.id.nav_giao_duc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new GiaoDuvFragment()).commit();
                break;
            case R.id.nav_suc_khoe:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_doi_song:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_du_lich:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_khoa_hoc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_so_hoa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_xe:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_y_kien:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_tam_su:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
            case R.id.nav_cuoi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TheGioiFragment()).commit();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
