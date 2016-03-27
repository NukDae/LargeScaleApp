// Alex Mun
// Team 2
// ECE 4574
/*
ActionMenuActivity.java

Implements the Action Menu screen where the
user can modify settings for robots and
sensors in addition to performing specific
building tasks and operations.
 */
package com.example.alex.assignment5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Alex on 3/27/2016.
 */
public class ActionMenuActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent intent = getIntent();

        // Implements an OnClickListener for button_back
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        Button usersButton = (Button) findViewById(R.id.toUsers);
        usersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToUsers(v);
            }
        });

        Button sensorsButton = (Button) findViewById(R.id.toSensors);
        sensorsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToSensors(v);
            }
        });

        Button robotsButton = (Button) findViewById(R.id.toRobots);
        robotsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToRobots(v);
            }
        });
    }

    public void goToUsers(View v)
    {
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }

    public void goToSensors(View v)
    {
        Intent intent = new Intent(this, ListSensorsActivity.class);
        startActivity(intent);
    }

    public void goToRobots(View v)
    {
        Intent intent = new Intent(this, ListRobotsActivity.class);
        startActivity(intent);
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