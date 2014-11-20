package com.example.student7.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends ActionBarActivity {

    TextView welcomeText;
    EditText phonenumber;

    @Override
    // tutaj nazywamy wszystkie zmienne (skąd mają się brać itp.) = cyklt życia aktywności
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcomeText = (TextView) findViewById(R.id.welcomeText);
        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        welcomeText.setText("Cześć " + username + " !");
        phonenumber = (EditText) findViewById(R.id.phonenumber);

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void CallBtn(View view) {
        String tel = phonenumber.getText().toString();
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + phonenumber));
        startActivity(i);
    }


    }

