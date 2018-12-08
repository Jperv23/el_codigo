package org.pursuit.group_portfolio_hw_codigo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class GeoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

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
        AlertDialog.Builder gitDialog = new AlertDialog.Builder(GeoActivity.this);
        gitDialog.setTitle(R.string.git_dialog_title)
                .setItems(R.array.github_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Uri uri = Uri.parse("https://github.com/Moonianne/Java_Bank_Pursuit_HW_JIMENEZ_GERARDO");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                                break;
                            case 1:
                                Uri uri2 = Uri.parse("https://github.com/Moonianne/Story_App_HW_JIMENEZ_GERARDO");
                                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                                startActivity(intent2);
                                break;
                            case 2:
                                Uri uri3 = Uri.parse("https://github.com/Moonianne/el_codigo");
                                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                                startActivity(intent3);
                                break;
                        }
                    }
                });
        return gitDialog.create();
    }
}
