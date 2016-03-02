package com.example.dave.counter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String count = settings.getString("saved_count","0");
        TextView myText = (TextView) findViewById(R.id.editText);
        myText.setText(count);
    }

    public void incrementNumber (View v) {
        TextView myText = (TextView) findViewById(R.id.editText);
        String str_num = myText.getText().toString();
        int num = Integer.parseInt(str_num);

        num++;
        str_num = Integer.toString(num);
        myText.setText(str_num);


    }

    public void saveCount (View v) {
        TextView myText = (TextView) findViewById(R.id.editText);
        String str_num = myText.getText().toString();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("saved_count", str_num);

        editor.commit();
    }
}
