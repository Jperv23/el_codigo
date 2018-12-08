package org.pursuit.group_portfolio_hw_codigo;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View activity = findViewById(R.id.main);
        activity.setBackgroundResource(R.drawable.background_opt_1);

        navView = findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.option_Geo:
                        Intent intentGeo = new Intent(MainActivity.this, GeoActivity.class);
                        startActivity(intentGeo);
                        break;
                    case R.id.option_Jessica:
                        Intent intentJess = new Intent(MainActivity.this, JessActivity.class);
                        startActivity(intentJess);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}
