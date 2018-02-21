package com.serverlin.eazita;

import java.util.Random;

/**
 * Created by hamza on 2/21/18.
 */

public class Conversations {
    public String body, sender, receiver, Status, Time, msgid;
    public boolean isMine;

    public Conversations(String Sender, String Receiver, String Body,
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
