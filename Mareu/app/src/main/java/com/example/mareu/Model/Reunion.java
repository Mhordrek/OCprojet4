package com.example.mareu.Model;

public class Reunion {

private int id;

private String date;

private String location;

private String subject;

private String attendees;


    public Reunion(int id, String date, String location, String subject, String attendees) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.subject = subject;
        this.attendees = attendees;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getSubject() {
        return subject;
    }

    public String getUsermail() {
        return attendees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.date = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setUsermail(String usermail) {
        this.attendees = usermail;
    }
}
