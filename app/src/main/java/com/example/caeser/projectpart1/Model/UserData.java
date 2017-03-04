package com.example.caeser.projectpart1.Model;

/**
 * Created by anubhav on 5/3/17.
 */

public class UserData {

    private String Name;
    private String College;
    private String Contact;
    private String Canteen;
    private String Email;
    private String ID;

    public UserData() {
    }

    public UserData(String name, String college, String contact, String canteen, String email, String ID) {
        Name = name;
        College = college;
        Contact = contact;
        Canteen = canteen;
        Email = email;
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getCanteen() {
        return Canteen;
    }

    public void setCanteen(String canteen) {
        Canteen = canteen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}