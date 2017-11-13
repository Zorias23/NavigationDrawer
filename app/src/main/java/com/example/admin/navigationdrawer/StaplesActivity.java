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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StaplesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    WebView wv;
    NavigationView nv;
    ActionBarDrawerToggle adt;
    DrawerLayout dl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staples);
        wv = findViewById(R.id.webViewStaples);
        nv = findViewById(R.id.navigationView);
        nv.setNavigationItemSelectedListener(this);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://www.staples.com/");
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_staples);
        dl = findViewById(R.id.drawerLayoutStaples);
        setSupportActionBar(myToolbar);
        adt = new ActionBarDrawerToggle(this, dl, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(adt);
        adt.syncState();
        adt.setDrawerIndicatorEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            goToMainActivity();
        }
        if (item.getItemId() == R.id.nba) {
            goToNbaActivity();
        }
        if (item.getItemId() == R.id.calculator) {
            goToCalculatorActivity();
        }
        if (item.getItemId() == R.id.depot) {
            goToDepotActivity();
        }
        if (item.getItemId() == R.id.google) {
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
