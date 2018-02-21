package com.serverlin.eazita;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class msgs extends AppCompatActivity implements View.OnClickListener {

        public static ChatAdapter chatAdapter;
        public static ArrayList<ChatMessage> chatlist;
    private EditText msg_edittext;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.msgs);
        getSupportActionBar().setTitle("Hello world App");
        getSupportActionBar().setSubtitle("dfsad");
        msg_edittext = (EditText)findViewById(R.id.edittext_chatbox);
        Button sendButton=(Button)findViewById(R.id.button_chatbox_send);
        sendButton.setOnClickListener(this);


                mListView = (ListView) findViewById(R.id.list);
                ArrayList<ChatMessage> recipeList = new ArrayList<ChatMessage>();
                chatAdapter = new ChatAdapter(this, recipeList);
                mListView.setAdapter(chatAdapter);

                int sd=0;
                while (sd<=100){
                    sd=sd+1;
                    final ChatMessage chatMessage = new ChatMessage("EZSMS", "923122699633",
                            "Message number "+sd, "", "12:00", true);
                    msg_edittext.setText("");
                    chatMessage.setMsgID();
                    chatMessage.body = "Message number "+sd;
                    chatMessage.Time = CommonMethods.getCurrentTime();
                    chatAdapter.add(chatMessage);
                    chatAdapter.notifyDataSetChanged();
                }
    }


        public void sendTextMessage(View v){
            String message = msg_edittext.getEditableText().toString();
            if (!message.equalsIgnoreCase("")) {
                final ChatMessage chatMessage = new ChatMessage("EZSMS", "923122699633",
                        message, "", "12:00", true);
                msg_edittext.setText("");
                chatMessage.setMsgID();
                chatMessage.body = message;
                chatMessage.Time = CommonMethods.getCurrentTime();
                chatAdapter.add(chatMessage);
                chatAdapter.notifyDataSetChanged();
            }
        //fake res
            final ChatMessage received = new ChatMessage("EZSMS", "923122699633",
                    "jghjgh", "","12:00", false);
            received.setMsgID();
            received.body = "Thank you for your message.";
            received.Time = CommonMethods.getCurrentTime();
            chatAdapter.add(received);
            chatAdapter.notifyDataSetChanged();


            Toast.makeText(this, "Button1 clicked.", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onClick(View v) {
            sendTextMessage(v);
                }

}