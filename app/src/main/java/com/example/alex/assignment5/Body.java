package com.example.alex.assignment5;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Body
{
    @SerializedName("room")
    @Expose
    public int room;
    @SerializedName("floor")
    @Expose
    public int floor;
    @SerializedName("description")
    @Expose
    public String description;
}