package com.ticketapp.sfmoviehouse.message;

public class FileResponseMessage {
    //notification-information about the file

    private String message;

    public FileResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
