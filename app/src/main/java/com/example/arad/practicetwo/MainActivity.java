package com.example.arad.practicetwo;

import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerView;
    EditText name;
    EditText family;
    Button butt;
    ImageView buttImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttImage = (ImageView) findViewById(R.id.buttImage);
        drawerView = (DrawerLayout) findViewById(R.id.drawerView);
        name = (EditText) findViewById(R.id.name);
        family = (EditText) findViewById(R.id.family);
        butt = (Button) findViewById(R.id.butt);


        name.setText(getShred("name", ""));
        family.setText(getShred("family", ""));


        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setShared("name", name.getText().toString());
                setShared("family", family.getText().toString());
                Toast.makeText(MainActivity.this, "has been saved", Toast.LENGTH_LONG).show();
                name.setText("");
                family.setText("");
            }
        });

        buttImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (drawerView.isDrawerOpen(Gravity.RIGHT)) {
                    drawerView.closeDrawer(Gravity.RIGHT);
                } else {
                    drawerView.openDrawer(Gravity.RIGHT);
                }

            }
        });

    }


    void setShared(String key, String value) {

        PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putString(key, value).commit();
    }

    String getShred(String key, String default_value) {
        return PreferenceManager.getDefaultSharedPreferences(this).getString(key, default_value);
    }
}







