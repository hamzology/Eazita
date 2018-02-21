package com.serverlin.eazita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class conversation extends AppCompatActivity {

    public static ConvAdapter chatAdapter;
    private EditText msg_edittext;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);

        getSupportActionBar().setTitle("Hello world App");
        getSupportActionBar().setSubtitle("dfsad");
        msg_edittext = (EditText)findViewById(R.id.edittext_chatbox);

        mListView = (ListView) findViewById(R.id.list);
        ArrayList<Conversations> recipeList = new ArrayList<Conversations>();
        chatAdapter = new ConvAdapter(this, recipeList);
        mListView.setAdapter(chatAdapter);

        int sd=0;
        while (sd<=100){
            sd=sd+1;
            final Conversations chatMessage = new Conversations("EZSMS", "923122699633",
                    "Message number "+sd, "", "12:00", true);
            msg_edittext.setText("");
            chatMessage.setMsgID();
            chatMessage.body = "Message number "+sd;
            chatMessage.Time = CommonMethods.getCurrentTime();
            chatAdapter.add(chatMessage);
            chatAdapter.notifyDataSetChanged();
        }
    }
}
