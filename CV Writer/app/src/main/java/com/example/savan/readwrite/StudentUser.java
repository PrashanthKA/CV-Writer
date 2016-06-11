package com.example.savan.readwrite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


/*
Main activity for template one- corresponds to file operations one
 */


public class StudentUser extends ActionBarActivity {
    private static final int PICKFILE_RESULT_CODE = 1;
    EditText fname, fcontent;
    EditText fcontentphone, fcontentemail, fcontentaddress, fcontentobjective;
    EditText fcontenteducation, fcontentcoursework, fcontenttechskill, fcontentexperience, fcontentproject;
    Button write;
    TextView filecon;
    private final int ID_MENU_EXIT =1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_template_one, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
          case R.id.exit:
              this.finish();
              System.exit(0);

             break;
          case R.id.clear:
             this.finish();
             startActivity(new Intent(this,StudentUser.class));
             break;
        }
    return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_one);
        fname = (EditText) findViewById(R.id.fname);
        fcontent = (EditText) findViewById(R.id.ftext);
        write = (Button) findViewById(R.id.btnwrite);
        // edited part after modification
        fcontentphone = (EditText) findViewById(R.id.fphone);
        fcontentemail = (EditText) findViewById(R.id.femail);
        fcontentaddress = (EditText) findViewById(R.id.faddress);
        fcontentobjective = (EditText) findViewById(R.id.fobjective);

        fcontenteducation = (EditText) findViewById(R.id.feducation);
        fcontentcoursework = (EditText) findViewById(R.id.fcoursework);
        fcontenttechskill = (EditText) findViewById(R.id.ftechskill);
        fcontentexperience = (EditText) findViewById(R.id.fexperience);
        fcontentproject = (EditText) findViewById(R.id.fproject);

        //Main part of coding begins

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String filename = fname.getText().toString();

                String filecontent = fcontent.getText().toString();
                // Modified part
                String filephone = fcontentphone.getText().toString();
                String fileemail = fcontentemail.getText().toString();
                String fileaddress = fcontentaddress.getText().toString();
                String fileobjective = fcontentobjective.getText().toString();
                String fileeducation = fcontenteducation.getText().toString();
                String filecourse = fcontentcoursework.getText().toString();
                String filetechskill = fcontenttechskill.getText().toString();
                String fileexperience = fcontentexperience.getText().toString();
                String fileproject = fcontentproject.getText().toString();

                StudentPdfGenerate fop = new StudentPdfGenerate();
                fop.write(filename, filecontent, filephone, fileemail, fileaddress, fileobjective, fileeducation, filecourse, filetechskill, fileexperience, fileproject);
                if (fop.write(filename, filecontent, filephone, fileemail, fileaddress, fileobjective, fileeducation, filecourse, filetechskill, fileexperience, fileproject)) {
                    Toast.makeText(getApplicationContext(),
                            filename + ".pdf created", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(getApplicationContext(), "I/O error",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });








     Button mButton = (Button) findViewById(R.id.mailbutton);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){




                try {

                    String emailAddress=fcontentemail.getText().toString();
                    String filepath=fname.getText().toString();

                    final String path = "/sdcard/" + filepath + ".pdf";

//                    // final String path = Environment.getExternalStorageDirectory().toString()+ "/sdcard/"+ getFileStreamPath() ".pdf";

                    File file = new File(path);
                    Uri uri = Uri.fromFile(file);

                   // Uri uri = Uri.fromFile(new File(externalStorage.getAbsolutePath() + "/sdcard/" + filepath +".pdf"));

                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Text");
                    emailIntent.setType("application/pdf");
                    emailIntent.putExtra(Intent.EXTRA_STREAM, uri);

                    startActivity(Intent.createChooser(emailIntent, "Share using"));
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(),"Failed to attach",Toast.LENGTH_SHORT).show();
                }

            }
        });}




    }


