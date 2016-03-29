package com.example.alex.assignment5;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YoussefBJ on 3/28/2016.
 */
public class Notifier {

    Progress.ProgressEntryAdapter adapter;

    public Notifier(String usr){
        userid = usr;
        notificationList = new ArrayList<String>();
    }

    public Notifier(String usr, Progress.ProgressEntryAdapter adapter){
        userid = usr;
        notificationList = new ArrayList<String>();
        this.adapter = adapter;
    }
    private String userid;
    private ArrayList<String> notificationList;
    public ArrayList<String> getNotificationList(){

        getNotifications();
        return notificationList;
    }
    private void getNotifications(){

        Log.d("Try", "hello");
        Retrofit client = new Retrofit.Builder().baseUrl("https://2bj29vv7f3.execute-api.us-east-1.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PushClient service = client.create(PushClient.class);
        Call<PushMessage> call = service.getData(userid);

        call.enqueue(new Callback<PushMessage>() {
                         @Override
                         public void onResponse(Call<PushMessage> call, Response<PushMessage> response) {
                             Response<PushMessage> resp = response;
                             if (response.isSuccessful()){
                                 PushMessage result = response.body();
                                 List<Message> nsg = result.getMessages();

                                 List<String> results = new ArrayList<String>();

                                 for (int h = 0; h < nsg.size(); h++) {
                                     Message mm = nsg.get(h);
                                     String id = mm.getMessageId();
                                     MSG msg = mm.getMSG();
                                     NotificationDisplay notif = new NotificationDisplay(msg);
                                     notificationList.add(notif.NotificationText);
                                     results.add(notif.NotificationText);
                                 }

                                 notifyAdapter(results);


                                 Log.d("good", "Gucci");

                             }
                             else{
                                 Log.d("bad", "fafa");
                             }
                             ArrayList<String> test = notificationList;


                         }

                         @Override
                         public void onFailure(Call<PushMessage> call, Throwable t) {
                             Log.d("bad2", "tata");

                         }

                     }
        );

        //   try{
        //      call.wait();
        // }
        // catch (InterruptedException e) {
        //    e.printStackTrace();
        // }

        ArrayList<String> test2 = notificationList;

    }

    private void notifyAdapter(List<String> results) {
        this.adapter.addAll(results);
        this.adapter.notifyDataSetChanged();
    }

}
