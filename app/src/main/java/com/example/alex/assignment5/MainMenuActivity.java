// Alex Mun
// Team 2
// ECE 4574
/*
MainMenuActivity.java

This activity is launched when a valid username/password
combination is entered from MainActivity.java.
 */

package com.example.alex.assignment5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.List;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.ByTypeApi;
import io.swagger.client.model.Building;
import io.swagger.client.model.Sensor;

/**
 * Created by Alex on 3/27/2016.
 */
public class MainMenuActivity extends AppCompatActivity
{
    String buildingName;
    boolean useAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Receives the username and password combination from the login activity
        Intent intent = getIntent();
        // String message = intent.getStringExtra(MainActivity.USER_INFO);


        final Spinner buildings = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.buildings, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buildings.setAdapter(adapter);

        useAPI = false;

        if(useAPI) {

            ApiClient client = new ApiClient();
            ByTypeApi byType = new ByTypeApi();

            try {

                List<Building> buildingList = byType.buildingsGet();
                adapter.clear();

                int i = buildingList.size();
                while(!buildingList.isEmpty()) {

                    i--;
                    adapter.add(buildingList.get(i).getId());
                }

            } catch(ApiException e) {

                // exception
            }

        }

        // Implements an OnClickListener to transition to the CreateBuildingActivity
        ImageButton createBuildingButton = (ImageButton)findViewById(R.id.button_create);
        createBuildingButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createBuilding(v);
            }
        });

        // Implements an OnClickListener to transition to the ActionMenuActivity
        ImageButton goToBuildingButton = (ImageButton)findViewById(R.id.button_go);
        goToBuildingButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                buildingName = buildings.getSelectedItem().toString();
                goToBuilding(v);
            }
        });

        // Implements an OnClickListener to transition to the PreferencesActivity
        ImageButton prefButton = (ImageButton)findViewById(R.id.button_pref);
        prefButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToPreferences(v);
            }
        });

        // Implements an OnClickListener to exit the main menu
        ImageButton exitButton = (ImageButton)findViewById(R.id.button_logout);
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        // The alert button implements an OnClickListener to alert the system
        ImageButton alertButton = (ImageButton)findViewById(R.id.alertButton);
        alertButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),
                        "System is now in Alert status",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void goToBuilding(View v)
    {
        Intent intent = new Intent(this, ActionMenuActivity.class);
        startActivity(intent);
    }

    public void createBuilding(View view)
    {
        Intent intent = new Intent(this, CreateBuildingActivity.class);
        startActivity(intent);
    }

    public void goToPreferences(View view)
    {
        Intent intent = new Intent(this, PreferencesActivity.class);
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