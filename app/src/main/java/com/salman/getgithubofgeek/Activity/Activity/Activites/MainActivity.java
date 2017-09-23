package com.salman.getgithubofgeek.Activity.Activity.Activites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.salman.getgithubofgeek.Activity.Activity.Adapters.PagerAdapter;

import com.salman.getgithubofgeek.R;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText text;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.getInfoButton);
        text= (EditText) findViewById(R.id.gitHubUserName);
        Logger.addLogAdapter(new AndroidLogAdapter());



    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (text.length() == 0){
                Toast.makeText(getApplicationContext(),"Enter userName Please",Toast.LENGTH_SHORT).show();
            }else {
                final String user = text.getText().toString();
                Intent in = new Intent(MainActivity.this, Tab.class);
                in.putExtra("SS", user);
                Logger.d(user);
                startActivity(in);
            }
        }
    });





    }
}
