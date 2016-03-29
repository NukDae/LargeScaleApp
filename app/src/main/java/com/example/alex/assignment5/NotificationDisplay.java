package com.example.alex.assignment5;

/**
 * Created by YoussefBJ on 3/29/2016.
 */
public class NotificationDisplay {
    public NotificationDisplay(MSG msg){
        NotificationText = "Alert: "+msg.msg_type+" in room: "+msg.body.room+" in floor: "+msg.body.floor+". Details: "+msg.body.description;
    }
    public String NotificationText;
}
