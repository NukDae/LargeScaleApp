package com.example.alex.assignment5;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.LinearLayout;
import io.swagger.client.ApiClient;

/**
 * Created by Alex on 3/27/2016.
 */
public class ListRobotsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eigth);

        Intent intent = getIntent();

        // Implements an OnClickListener for button_back
        Button button_back = (Button) findViewById(R.id.button9);
        button_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        ApiClient client = new ApiClient();

        //LinearLayout layout = (LinearLayout) findViewById(R.layout.activity_eigth);
        RadioButton robotListItem = new RadioButton(getApplicationContext());
        robotListItem.setText("Button ");
        //layout.addView(robotListItem);


        //View layout = (View) findViewById(R.layout.activity_eigth);
        for(int i=0; i < 5; i++)
        {
            //layout.addView(robotListItem);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}