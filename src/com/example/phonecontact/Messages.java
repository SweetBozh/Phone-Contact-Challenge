package com.example.phonecontact;

public class Messages {
    String message;
    Contact destination;
    Contact source;

    public Messages(String message, Contact destination, Contact source) {
        this.message = message;
        this.destination = destination;
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Contact getDestination() {
        return destination;
    }

    public void setDestination(Contact destination) {
        this.destination = destination;
    }

    public Contact getSource() {
        return source;
    }

    public void setSource(Contact source) {
        this.source = source;
    }
}
