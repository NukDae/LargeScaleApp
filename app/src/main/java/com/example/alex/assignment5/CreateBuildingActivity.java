// Alex Mun
// Team 2
// ECE 4574
/*
CreateBuildingActivity.java

The Create Building screen allows the user to
select the layout and name of the new building.
 */
package com.example.alex.assignment5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Alex on 3/27/2016.
 */
public class CreateBuildingActivity extends AppCompatActivity
{
    // Creates a radioGroup for the layout options
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        // Implements an OnCheckedChangeListener for the radio buttons
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
            }
        });

        // Implements an OnClickListener for button_create
        Button button_create = (Button) findViewById(R.id.button_create);
        button_create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                finish();
            }
        });
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