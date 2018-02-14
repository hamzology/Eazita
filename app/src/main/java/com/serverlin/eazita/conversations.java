package com.serverlin.eazita;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.serverlin.eazita.ChatAdapter;
import com.serverlin.eazita.ChatMessage;
import com.serverlin.eazita.CommonMethods;
import com.serverlin.eazita.R;

/**
 * Created by hamza on 4/13/17.
 */


public class conversations extends Fragment implements View.OnClickListener {

    private EditText msg_edittext;
    private String user1 = "khushi", user2 = "khushi1";
    private Random random;
    public static ArrayList<ChatMessage> chatlist;
    public static ChatAdapter chatAdapter;
    ListView msgListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View view = inflater.inflate(R.layout.conversations, container, false);
        random = new Random();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(
                "Chats");
        msg_edittext = (EditText) view.findViewById(R.id.messageEditText);
        msgListView = (ListView) view.findViewById(R.id.msgListView);
        Button sendButton = (Button) view.findViewById(R.id.sendMessageButton);
        sendButton.setOnClickListener(this);

        // ----Set autoscroll of listview when a new message arrives----//
        msgListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        msgListView.setStackFromBottom(true);

        chatlist = new ArrayList<ChatMessage>();
        chatAdapter = new ChatAdapter(getActivity(), chatlist);
        msgListView.setAdapter(chatAdapter);
        return view;

        //return inflater.inflate(R.layout.conversations, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       /* String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X"};
        //ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(),R.layout.conversations, mobileArray);
        ListView listView = (ListView) getView().findViewById(R.id.msgListView);
        listView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.chatbubble,mobileArray));
        //listView.setAdapter(adapter);*/
        //you can set the title for your toolbar here for different fragments different titles



        final ChatMessage chatMessage = new ChatMessage(user1, user2,
                "jghjgh", "" + random.nextInt(1000), true);
        chatMessage.setMsgID();
        chatMessage.body = "jghjgh";
        chatMessage.isMine = false;
        chatMessage.Date = CommonMethods.getCurrentDate();
        chatMessage.Time = CommonMethods.getCurrentTime();
        msg_edittext.setText("");
        chatAdapter.add(chatMessage);
        getActivity().setTitle("Messaging");

    }

    public void sendTextMessage(View v) {
        String message = msg_edittext.getEditableText().toString();
        if (!message.equalsIgnoreCase("")) {
            final ChatMessage chatMessage = new ChatMessage(user1, user2,
                    message, "" + random.nextInt(1000), true);
            chatMessage.setMsgID();
            chatMessage.body = message;
            chatMessage.Date = CommonMethods.getCurrentDate();
            chatMessage.Time = CommonMethods.getCurrentTime();
            msg_edittext.setText("");
            chatAdapter.add(chatMessage);
            chatAdapter.notifyDataSetChanged();
        }

        //fake resp

        final ChatMessage chatMessage = new ChatMessage(user1, user2,
                "jghjgh", "" + random.nextInt(1000), true);
        chatMessage.setMsgID();
        chatMessage.body = "jghjgh";
        chatMessage.isMine = false;
        chatMessage.Date = CommonMethods.getCurrentDate();
        chatMessage.Time = CommonMethods.getCurrentTime();
        msg_edittext.setText("");
        chatAdapter.add(chatMessage);
        chatAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendMessageButton:
                sendTextMessage(v);

        }
    }

}