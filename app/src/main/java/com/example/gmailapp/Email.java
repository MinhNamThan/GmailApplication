package com.example.gmailapp;

public class Email {
    private int id;
    private String from;
    private String subject;
    private String message;
    private String timestamp;
    private String picture;
    private boolean isImportant;
    private boolean isRead;
    private boolean isSelected;

    public Email(int id, String from, String subject, String message, String timestamp, boolean isImportant) {
        this.id = id;
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.timestamp = timestamp;
        this.isImportant = isImportant;
    }

    public Email(String from, String subject, String message, String timestamp, String picture) {
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.timestamp = timestamp;
        this.picture = picture;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public boolean isRead() {
        return isRead;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
