package com.example.savan.readwrite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



/*
 *
  * Template selection screen
  *
  *
  *
  *
  * */


public class TemplateSelection extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_selection);

        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(new Intent(getBaseContext(), StudentUser.class));
                    }
                }, 400);
             }
        });

        findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(new Intent(getBaseContext(), TargetedResume.class));
                    }
                }, 400);
           }
        });

        findViewById(R.id.viewsd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath());
                        intent.setDataAndType(uri, "application/pdf");
                        startActivity(Intent.createChooser(intent, "Open folder"));
                    }
                }, 400);
            }
        });

        findViewById(R.id.gdrive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.docs");
                        startActivity(intent);
                    }
                }, 400);
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_template_selection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit:
                this.finish();
                break;
            }
        return true;
    }



}
