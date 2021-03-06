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

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.alex.assignment5.Progress;

/**
 * Created by Alex on 3/27/2016.
 */
public class ActionMenuActivity extends AppCompatActivity implements Progress.ProgressInteractionListener
{
    public final static String PROG_FRAG = "PROG";
    private Progress progFrag;

    // The fragment manager inserts and removes fragments from the frame layout
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        fm = getFragmentManager();

        Fragment temp;
        temp = fm.findFragmentByTag(PROG_FRAG);
        progFrag = Progress.newInstance("a", "n");

        Intent intent = getIntent();

        // Implements an OnClickListener to transition to Progress
        ImageButton progButton = (ImageButton)findViewById(R.id.perfAction);
        progButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fm.beginTransaction().add(R.id.frag, progFrag, PROG_FRAG).commit();
            }
        });

        // Implements an OnClickListener to exit the preferences activity
        ImageButton exitButton = (ImageButton)findViewById(R.id.button_return);
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        // Implements an OnClickListener to transition to the ListUsersActivity
        ImageButton usersButton = (ImageButton)findViewById(R.id.toUsers);
        usersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToUsers(v);
            }
        });

        // Implements an OnClickListener to transition to the ListSensorsActivity
        ImageButton sensorsButton = (ImageButton)findViewById(R.id.toSensors);
        sensorsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToSensors(v);
            }
        });

        // Implements an OnClickListener to transition to the ListRobotsActivity
        ImageButton robotsButton = (ImageButton)findViewById(R.id.toRobots);
        robotsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToRobots(v);
            }
        });

    }

    public void goToNotifications(View v) {
        Intent intent = new Intent(this, NotificationDisplay.class);
        startActivity(intent);
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

    // Helper method that removes the current fragment
    private void removeFragments()
    {
        if (progFrag != null)
        {
            fm.beginTransaction().remove(progFrag).commit();
        }
    }

    public void onFragmentInteraction(Uri uri)
    {

    }

    // Receives deleted data from Progress.java
    @Override
    public void sendDeletedData(int data)
    {
        Toast.makeText(getApplicationContext(), "[From Activity] Deleted Data Entry ID: "+data, Toast.LENGTH_LONG).show();
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