package com.revature.models;

public class TradeDTO {
    public int send;
    private int sendid;
    public int recieve;
    public double amount;

    public TradeDTO() {
    }

    public TradeDTO(int send, int sendid, int recieve, double amount) {
        this.send = send;
        this.sendid = sendid;
        this.recieve = recieve;
        this.amount = amount;
    }

    public int getSend() {
        return send;
    }

    public void setSend(int send) {
        this.send = send;
    }

    public int getSendid() {
        return sendid;
    }

    public void setSendid(int sendid) {
        this.sendid = sendid;
    }

    public int getRecieve() {
        return recieve;
    }

    public void setRecieve(int recieve) {
        this.recieve = recieve;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}