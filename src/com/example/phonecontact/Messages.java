package com.example.phonecontact;

public class Messages {
    String message;
    Contact destination;
    Contact source;

    public Messages(String message, Contact destination) {
        this.message = message;
        this.destination = destination;
    }

    public void showMessage() {
        System.out.println("To: " + destination.getName());
        System.out.println("\t\"" + message + "\"");
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
}
