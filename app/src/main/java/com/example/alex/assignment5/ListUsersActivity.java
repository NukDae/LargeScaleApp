package com.example.alex.assignment5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.List;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.ByIDApi;
import io.swagger.client.api.ByTypeApi;
import io.swagger.client.model.Sensor;
import io.swagger.client.model.User;

/**
 * Created by Alex on 3/27/2016.
 */
public class ListUsersActivity extends AppCompatActivity
{
    boolean useAPI;
    RadioButton first;
    RadioButton second;
    RadioButton third;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Intent intent = getIntent();
        useAPI = false;

        first = (RadioButton) findViewById(R.id.checkBox_s1);
        second = (RadioButton) findViewById(R.id.checkBox_s2);
        third = (RadioButton) findViewById(R.id.checkBox_s3);

        if(useAPI) {

            ApiClient client = new ApiClient();
            ByTypeApi byType = new ByTypeApi();

            try {

                List<User> userList = byType.usersGet();
                first.setText(userList.get(0).getId().toString());
                second.setText(userList.get(1).getId().toString());
                third.setText(userList.get(2).getId().toString());

            } catch(ApiException e) {

                // exception
            }

        }

        // Implements an OnClickListener for button_back
        Button button_back = (Button) findViewById(R.id.user_back);
        Button button_new = (Button) findViewById(R.id.new_user);
        Button button_edit = (Button) findViewById(R.id.edit_user);
        Button button_delete = (Button) findViewById(R.id.delete_user);

        first = (RadioButton) findViewById(R.id.checkBox_s1);

        button_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        button_new.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(useAPI) {

                    ApiClient client = new ApiClient();
                    ByIDApi byID = new ByIDApi();
                    User newUser = new User();

                    String str = "";

                    try {

                        byID.usersUserIDPut(str, newUser);

                    } catch(ApiException e) {

                        // exception
                    }
                }
            }
        });

        button_edit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(useAPI) {

                    ApiClient client = new ApiClient();
                    ByIDApi byID = new ByIDApi();
                    User newUser = new User();
                }
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (useAPI) {

                    ApiClient client = new ApiClient();
                    ByIDApi byID = new ByIDApi();

                    String str = first.getText().toString();

                    try {

                        byID.usersUserIDDelete(str);

                    } catch(ApiException e) {

                        // exception
                    }
                }
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