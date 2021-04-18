package com.example.ca3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class chapterNavigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_navigation);
        Toolbar toolbar= findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(chapterNavigation.this,
                drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            //default open Message Fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                    new MessageFragment()).commit();
        }
    }
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Settings:
                Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Notifications:
                Toast.makeText(getApplicationContext(),"Notifications",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Subscriptions:
                Toast.makeText(getApplicationContext(),"Subscriptions",Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(getApplicationContext(),"Send",Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);//Close drawer
        return true;
    }
}