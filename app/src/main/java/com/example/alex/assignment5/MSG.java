package com.example.alex.assignment5;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by YoussefBJ on 3/28/2016.
 */
public class MSG {
    @SerializedName("msg_type")
    @Expose
    public String msg_type;
    @SerializedName("body")
    @Expose
    public Body body;
}