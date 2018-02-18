package com.serverlin.eazita;

/**
 * Created by hamza on 4/14/17.
 */

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChatAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ChatMessage> mDataSource;

    public ChatAdapter(Context context, ArrayList<ChatMessage> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //1
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }
    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        ChatMessage message = (ChatMessage) mDataSource.get(position);
        View rowView = convertView;
        if (message.isMine){
            rowView = mInflater.inflate(R.layout.sentrow, parent, false);
            TextView type = (TextView) rowView.findViewById(R.id.msgcnt);
            TextView name = (TextView) rowView.findViewById(R.id.text_message_name);
            TextView ttime = (TextView) rowView.findViewById(R.id.text_message_time);
            ttime.setText(message.Time);
            name.setText("SENDER: " + String.format("%02d", new Random().nextInt(100)));
            type.setText(message.body);
        } else {
            rowView = mInflater.inflate(R.layout.row_item, parent, false);
            TextView type = (TextView) rowView.findViewById(R.id.msgcnt);
            TextView name = (TextView) rowView.findViewById(R.id.text_message_name);
            TextView ttime = (TextView) rowView.findViewById(R.id.text_message_time);
            ttime.setText(message.Time);
            name.setText("SENDER: " + String.format("%02d", new Random().nextInt(100)));
            type.setText("This is a test message with Hello world.");
        }
        return rowView;
    }
    public void add(ChatMessage object){
        mDataSource.add(object);
    }
}