package org.pursuit.group_portfolio_hw_codigo;

import android.content.Intent;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolBar;
    private NavigationView navView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);
        navView.setItemTextAppearance(R.style.nav_menu_text);

        drawerLayout = findViewById(R.id.main);
        toolBar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolBar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        setupNavDrawer();
    }

    public void setupNavDrawer() {
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.option_Geo:
                        Intent intentGeo = new Intent(MainActivity.this, GeoActivity.class);

                        drawerLayout.closeDrawer(Gravity.START, true);

                        startActivity(intentGeo);
                        break;
                    case R.id.option_Jessica:
                        Intent intentJess = new Intent(MainActivity.this, JessActivity.class);

                        //drawerLayout.closeDrawer(Gravity.START, true);
                        startActivity(intentJess);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START, true);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Open The Drawer!", Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(Gravity.START, true);
                break;
            default:
                break;
        }
        return true;
    }
}
