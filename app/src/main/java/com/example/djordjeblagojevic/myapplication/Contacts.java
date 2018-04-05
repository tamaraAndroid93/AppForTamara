package com.example.djordjeblagojevic.myapplication;

public class Contacts {

    public String name,surname;
    public String number;
    public String photoUri;






    public Contacts() {


    }



    public Contacts(String name, String surname, String number, String photoUrl) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.photoUri = photoUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }
}
