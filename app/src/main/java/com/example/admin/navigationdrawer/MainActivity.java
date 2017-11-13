package com.example.admin.navigationdrawer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dl;
    NavigationView nv;
    MenuItem home;
    MenuItem nba;
    MenuItem calculator;
    MenuItem google;
    private String TAG = "MainActivity";
    ActionBarDrawerToggle adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        dl = findViewById(R.id.drawerLayout);
        nv = findViewById(R.id.navigationView);
        home = findViewById(R.id.home);
        nba = findViewById(R.id.nba);
        calculator = findViewById(R.id.calculator);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        adt = new ActionBarDrawerToggle(this, dl, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(adt);
        adt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, "onNavigationItemSelected: you hit a menu item..");
                if (item.getItemId() == R.id.home)
                {
                    goToMainActivity();
                }
                if (item.getItemId() == R.id.nba)
                {
                    goToNbaActivity();
                }
                if (item.getItemId() == R.id.calculator)
                {
                    goToCalculatorActivity();
                }
                if (item.getItemId() == R.id.depot)
                {
                    goToDepotActivity();
                }
                if (item.getItemId() == R.id.google)
                {
                    goToGoogleActivity();
                }
                return true;
            }
        });

    }
    private void goToMainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionUtil)
        {
            goToStaplesActivity();
        }
        if (item.getItemId() == R.id.actionHome)
        {
            goToWalmartActivity();
        }
        if (item.getItemId() == R.id.actionSettings)
        {
            goToThinkActivity();
        }
        if (item.getItemId() == android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
    private void goToThinkActivity()
    {
        Intent intent = new Intent(this, ThinkActivity.class);
        startActivity(intent);
    }
    private void goToWalmartActivity()
    {
        Intent intent = new Intent(this, WalmartActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void goToStaplesActivity()
    {
        Intent intent = new Intent(this, StaplesActivity.class);
        startActivity(intent);
    }
    private void goToNbaActivity()
    {
        Intent intent = new Intent(this, NbaActivity.class);
        startActivity(intent);
    }
    private void goToCalculatorActivity()
    {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }
    private void goToPhotoActivity()
    {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }
    private void goToDepotActivity()
    {
        Intent intent = new Intent(this, DepotActivity.class);
        startActivity(intent);
    }
    private void goToGoogleActivity()
    {
        Intent intent = new Intent(this, GoogleActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
