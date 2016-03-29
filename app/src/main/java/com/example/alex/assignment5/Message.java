package com.example.alex.assignment5;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("messageId")
    @Expose
    private String messageId;
    @SerializedName("message")
    @Expose
    private MSG msg;

    /**
     *
     * @return
     * The messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     *
     * @param messageId
     * The messageId
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     *
     * @return
     * The Unique Message
     */
    public MSG getMSG() {
        return msg;
    }

    /**
     *
     * @param msg
     * The Unique msg
     */
    public void setMSG(MSG msg) {
        this.msg = msg;
    }

}