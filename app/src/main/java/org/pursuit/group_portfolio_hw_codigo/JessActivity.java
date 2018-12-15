package org.pursuit.group_portfolio_hw_codigo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class JessActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolBar;
    private NavigationView navView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jess);

        View activity = findViewById(R.id.JessActivity);
        activity.setBackgroundResource(R.drawable.background_opt_1);

        navView = findViewById(R.id.jess_nav_view);
        navView.setItemTextAppearance(R.style.nav_menu_text);

        drawerLayout = findViewById(R.id.main);
        toolBar = findViewById(R.id.include);
        setSupportActionBar(toolBar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_up_action);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ImageView imageView = findViewById(R.id.jess_pic);
        Bitmap memPic = BitmapFactory.decodeResource(getResources(), R.drawable.jesspic);
        RoundedBitmapDrawable cirPic = RoundedBitmapDrawableFactory.create(getResources(), memPic);
        cirPic.setCircular(true);
        imageView.setImageDrawable(cirPic);

        setupNavDrawer();

        //Popup Menu on Tool/Actionbar:
//        final android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_toolbar_menu);
//        toolbar.setTitle(R.string.codigo);
//        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final PopupMenu proMenu = new PopupMenu(JessActivity.this, toolbar);
//                proMenu.getMenuInflater().inflate(R.menu.popup_menu, proMenu.getMenu());
//                proMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.link_one:
//                                Uri uri = Uri.parse("https://github.com/Jperv23/Wands_Up_Game");
//                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                                startActivity(intent);
//                                break;
//                            case R.id.link_two:
//                                Uri uri2 = Uri.parse("https://github.com/Jperv23/Java_Bank_Pursuit_HW_PEREZVALLE_JESSICA");
//                                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
//                                startActivity(intent2);
//                                break;
//                            case R.id.link_three:
//                                Uri uri3 = Uri.parse("https://github.com/Jperv23/Story_App_HW");
//                                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
//                                startActivity(intent3);
//                                break;
//                        }
//                        return true;
//                    }
//                });
//                proMenu.show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.story_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github_action:
                Toast.makeText(this, "GitHub", Toast.LENGTH_SHORT).show();
                dialogish().show();
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }

    public AlertDialog dialogish() {
        AlertDialog.Builder gitDialog = new AlertDialog.Builder(JessActivity.this);
        gitDialog.setTitle(R.string.git_dialog_title)
                .setItems(R.array.jess_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Uri uri = Uri.parse("https://github.com/Jperv23/Wands_Up_Game");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                break;
                            case 1:
                                Uri uri2 = Uri.parse("https://github.com/Jperv23/Java_Bank_Pursuit_HW_PEREZVALLE_JESSICA");
                                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                                startActivity(intent2);
                                break;
                            case 2:
                                Uri uri3 = Uri.parse("https://github.com/Jperv23/Story_App_HW");
                                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                                startActivity(intent3);
                                break;
                        }
                    }
                });
        return gitDialog.create();
    }

    public void setupNavDrawer() {
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.option_Geo:
                        Intent intentGeo = new Intent(JessActivity.this, GeoActivity.class);

                        drawerLayout.closeDrawer(Gravity.START, true);

                        startActivity(intentGeo);
                        break;
                    case R.id.option_Jessica:
                        Intent intentJess = new Intent(JessActivity.this, JessActivity.class);

                        drawerLayout.closeDrawer(Gravity.START, true);

                        startActivity(intentJess);
                        break;
                    case R.id.option_Luis:
                        Intent intentLuis = new Intent(JessActivity.this, LuisActivity.class);

                        drawerLayout.closeDrawer(Gravity.START, true);

                        startActivity(intentLuis);
                        break;
                    default:
                        Toast.makeText(JessActivity.this, "Feature Not Yet Implemented", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START, true);
                        break;
                }
                return true;
            }
        });
    }
}
