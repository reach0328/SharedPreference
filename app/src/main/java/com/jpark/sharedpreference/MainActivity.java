package com.jpark.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
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
        //세팅된 값을 가져와서 화면에 뿌린다.
        loadSetting();
    }
    public void closeHelp(View view) {
        layout.setVisibility(View.GONE);
        propertyUtil.saveProperty("firstOpen","false");
    }

    public void saveSetting(View view) {
        // Preference 생성
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        // editor를 가져와서 추가(값을 입력하기위해서는 editor로 가져와야한다)
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("email",edit_email.getText().toString());
        editor.putBoolean("suffle",switch_suffle.isChecked());
        editor.commit();
    }
    public void loadSetting() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String email = sharedPref.getString("email",null);
        boolean check = sharedPref.getBoolean("suffle", false);
        edit_email.setText(email);
        switch_suffle.setChecked(check);
    }
}
