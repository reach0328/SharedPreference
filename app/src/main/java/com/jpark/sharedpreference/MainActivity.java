package com.jpark.sharedpreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText edit_email;
    Switch switch_suffle;
    RelativeLayout layout;
    PropertyUtil propertyUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_email = (EditText) findViewById(R.id.edit_email);
        switch_suffle = (Switch) findViewById(R.id.switch1);
        propertyUtil = PropertyUtil.getInstatace(this);
        layout = (RelativeLayout) findViewById(R.id.layout2);

        if("false".equals(propertyUtil.getProperty("firstOpen"))){
            layout.setVisibility(View.GONE);
        }
    }
    public void closeHelp(View view) {
        layout.setVisibility(View.GONE);
        propertyUtil.saveProperty("firstOpen","false");
    }

    public void saveSetting(View view) {

    }


}
