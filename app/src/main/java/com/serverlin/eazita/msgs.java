package com.serverlin.eazita;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class msgs extends AppCompatActivity implements View.OnClickListener {

        public static ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){




        super.onCreate(savedInstanceState);
        setContentView(R.layout.msgs);

        Button sendButton=(Button)findViewById(R.id.button_chatbox_send);
        sendButton.setOnClickListener(this);

                ListView mListView;
                mListView = (ListView) findViewById(R.id.list);
                ArrayList<String> recipeList = new ArrayList<String>();
                recipeList.add("F");
                recipeList.add("C");
                recipeList.add("S");
                recipeList.add("F");
                recipeList.add("F");
                recipeList.add("C");
                recipeList.add("S");
                recipeList.add("F");
                recipeList.add("F");
                recipeList.add("C");
                recipeList.add("S");
                recipeList.add("F");
                recipeList.add("F");
                recipeList.add("C");
                recipeList.add("S");
                recipeList.add("F");
                recipeList.add("F");
                recipeList.add("C");
                recipeList.add("S");
                recipeList.add("F");
                chatAdapter = new ChatAdapter(this, recipeList);
                mListView.setAdapter(chatAdapter);

    }


        public void sendTextMessage(View v){
        chatAdapter.add("fdgdfg");
        chatAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Button1 clicked.", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onClick(View v) {
            sendTextMessage(v);
                }

}