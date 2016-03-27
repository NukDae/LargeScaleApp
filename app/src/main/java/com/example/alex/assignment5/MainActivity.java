// Alex Mun
// Team 2
// ECE 4574
/*
MainActivity.java

Client-side implementation of a simple user login interface.
Upon a successful login, transitions to the second activity.

Username: john
Password: abc

 */
package com.example.alex.assignment5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity
{
    // The string value that is transmitted by the Intent upon user verification
    public final static String USER_INFO = "com.example.alex.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The login button implements an OnClickListener to verify user credentials
        ImageButton loginButton = (ImageButton)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Retrieves the username string
                EditText nameField = (EditText) findViewById(R.id.nameField);
                String userName = nameField.getText().toString();
                userName = userName.trim();

                // Retrieves the password string
                EditText passwordField = (EditText) findViewById(R.id.passwordField);
                String passWord = passwordField.getText().toString();

                // Login requires a valid username and password combination
                // For client-side testing, username is john and password is abc
                if((!userName.isEmpty()) && (!passWord.isEmpty()))
                {
                    if((userName.equals("john")) && (passWord.equals("abc")))
                    {
                        login(v);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),
                                "Error: invalid username or password",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Error: invalid username or password",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        // The exit button implements an OnClickListener to exit the program
        ImageButton exitButton = (ImageButton)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
                // System.exit(0);
            }
        });
    }

    // This function is called when the user inputs a valid username and password combination
    public void login(View view)
    {
        // Uses an Intent to transmit user credentials between activities
        Intent intent = new Intent(this, MainMenuActivity.class);

        // Retrieves the username string
        EditText nameField = (EditText) findViewById(R.id.nameField);
        String userName = nameField.getText().toString();
        userName = userName.trim();

        // Retrieves the password string
        EditText passwordField = (EditText) findViewById(R.id.passwordField);
        String passWord = passwordField.getText().toString();

        // Concatenates the username and password into a single string for the Intent
        String userInfo = (userName + " " + passWord);
        intent.putExtra(USER_INFO, userInfo);
        startActivity(intent);

        // Reset username and password fields
        nameField.setText("");
        passwordField.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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