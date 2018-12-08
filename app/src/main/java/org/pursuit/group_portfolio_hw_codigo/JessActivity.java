package org.pursuit.group_portfolio_hw_codigo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class JessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jess);

     //Set Activity Background:
        View activity = findViewById(R.id.jActivity);
        activity.setBackgroundResource(R.drawable.background_opt_1);

     //Insert Member picture:
        ImageView imageView = findViewById(R.id.jess_pic);
        Bitmap memPic = BitmapFactory.decodeResource(getResources(), R.drawable.jesspic);
        RoundedBitmapDrawable cirPic = RoundedBitmapDrawableFactory.create(getResources(), memPic);
        cirPic.setCircular(true);
        imageView.setImageDrawable(cirPic);

    //Popup Menu on Tool/Actionbar:
//        final  toolbar = findViewById(R.drawable.ic_toolbar_menu);
////        toolbar.setNavigationIcon(R.drawable.ic_toolbar_menu);
////        toolbar.setTitle(R.string.codigo);
////        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
//        toolbar.setOnClickListener(new View.OnClickListener() {
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



}
