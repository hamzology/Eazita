package com.serverlin.eazita;

/**
 * Created by hamza on 4/14/17.
 */

import java.util.Random;

public class ChatMessage {
    public String body, sender, receiver, Status, Time, msgid;
    public boolean isMine;

    public ChatMessage(String Sender, String Receiver, String Body,
                       String mid, String TIME, boolean isMINE){
        body = Body;
        isMine = isMINE;
        Time = TIME;
        sender = Sender;
        msgid = mid;
        receiver = Receiver;
    }

    public void setMsgID() {

        msgid += "-" + String.format("%02d", new Random().nextInt(100));
        ;
    }
}