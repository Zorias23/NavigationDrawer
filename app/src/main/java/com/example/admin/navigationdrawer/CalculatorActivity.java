package com.example.admin.navigationdrawer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    EditText celcius;
    EditText kilometers;
    EditText millileter;
    EditText centimeter;

    EditText farenheight;
    EditText miles;
    EditText ounces;
    EditText inch;
    NavigationView nv;
    ActionBarDrawerToggle adt;
    DrawerLayout dl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        bindViews();
        nv.setNavigationItemSelectedListener(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_calculator);
        dl = findViewById(R.id.drawerLayoutCalculator);
        setSupportActionBar(myToolbar);
        adt = new ActionBarDrawerToggle(this, dl,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(adt);
        adt.syncState();
        adt.setDrawerIndicatorEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void bindViews()
    {
        celcius = findViewById(R.id.celcius);
        kilometers = findViewById(R.id.kilometer);
        millileter = findViewById(R.id.ml);
        centimeter = findViewById(R.id.centimeter);
        farenheight = findViewById(R.id.farenheit);
        miles = findViewById(R.id.miles);
        ounces = findViewById(R.id.ounce);
        inch = findViewById(R.id.inch);
        nv = findViewById(R.id.navigationView);
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
    private void goToStaplesActivity()
    {
        Intent intent = new Intent(this, StaplesActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void calculateInches(View view)
    {
        double cen = 0;
        double in = 0;
        cen = Double.valueOf(centimeter.getText().toString());
        in = cen * .39;
        inch.setText(String.valueOf(in));
    }
    public void calculateOunces(View view)
    {
        double mil = 0;
        double ounce = 0;
        mil = Double.valueOf(millileter.getText().toString());
        ounce = mil * .033814;
        ounces.setText(String.valueOf(ounce));
    }
    public void calculateMiles(View view)
    {
        double km = 0;
        double mil = 0;
        km = Double.valueOf(kilometers.getText().toString());
        mil = km * .62137;
        miles.setText(String.valueOf(mil));
    }
    public void calculateFarenheit(View view)
    {
        double faren = 0;
        double cel = 0;
        cel = Double.valueOf(celcius.getText().toString());
        faren = (cel * 1.8) + 32;
        farenheight.setText(String.valueOf(faren));


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
        dl.closeDrawer(GravityCompat.START);
        return false;
    }
    private void goToMainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
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
}
