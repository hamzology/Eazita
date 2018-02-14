package com.serverlin.eazita;

import android.app.Service;
import android.content.*;
import android.os.*;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.serverlin.eazita.ChatAdapter;
import com.serverlin.eazita.ChatMessage;
import com.serverlin.eazita.CommonMethods;
import com.serverlin.eazita.R;

import java.util.ArrayList;
import java.util.Random;

import com.serverlin.eazita.conversations;

/**
 * Created by hamza on 4/14/17.
 */


public class backgroundservice extends Service {

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;
    private EditText msg_edittext;


    private String user1 = "khushi", user2 = "khushi1";
    private Random random;

    public static ArrayList<ChatMessage> chatlist;
    public static ChatAdapter chatAdapter;



    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        random = new Random();


        Toast.makeText(this, "Service created!", Toast.LENGTH_LONG).show();

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {

                final ChatMessage chatMessage = new ChatMessage(user1, user2,
                        "jghjgh", "" + random.nextInt(1000), true);
                chatMessage.setMsgID();
                chatMessage.body = "jghjgh";
                chatMessage.isMine = false;
                chatMessage.Date = CommonMethods.getCurrentDate();
                chatMessage.Time = CommonMethods.getCurrentTime();
                chatAdapter.add(chatMessage);
                conversations.chatlist.add(chatMessage);
                Toast.makeText(context, "Service is still running", Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable, 10000);
            }
        };

        handler.postDelayed(runnable, 15000);
    }

    @Override
    public void onDestroy() {
        /* IF YOU WANT THIS SERVICE KILLED WITH THE APP THEN UNCOMMENT THE FOLLOWING LINE */
        //handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service started by user.", Toast.LENGTH_LONG).show();
    }
}