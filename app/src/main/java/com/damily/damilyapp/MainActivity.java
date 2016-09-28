package com.damily.damilyapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.damily.damilyapp.fragment.HomeFragment;
import com.damily.damilyapp.fragment.SecondTabFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mDrawerLayout;
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;
    private GridView gv_main;
    //private MainUIAdapter adapter;
    private static String title;
    Toolbar toolbar;
    private static final String TAG = "MainActivity";
    private TabLayout tb_layout;
    private ViewPager viewPager;
    private String[] titles;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment homeFragment = new HomeFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container_content, homeFragment).commit();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                Toast.makeText(MainActivity.this, R.string.navigation_drawer_close, Toast.LENGTH_SHORT)
                        .show();
            }
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(MainActivity.this, R.string.navigation_drawer_open, Toast.LENGTH_SHORT)
                        .show();
            }
        };
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                  /*  case R.id.action_edit:
                        Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                       Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        break;*/
                }
                return true;
            }
        });
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        switch (id) {
            //noinspection SimplifiableIfStatement
            case R.id.action_settings:
               Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
              //  super.onBackPressed();
                break;
            case android.R.id.home:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
                break;
        /*if (id == R.id.action_settings) {
            //点击右上角settings触发的事件
            return true;
        }*/
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.nav_camera:
                toolbar.setTitle("首页");
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment homeFragment = new HomeFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.container_content, homeFragment).commit();
                break;

            case R.id.nav_gallery:
                toolbar.setTitle("Gallery");
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                Fragment secondFragment = new SecondTabFragment();
                fragmentManager1.beginTransaction()
                        .replace(R.id.container_content, secondFragment).commit();
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
