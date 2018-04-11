package com.example.djordjeblagojevic.myapplication;

import java.io.Serializable;// Parcelable

public class Contacts implements Serializable {

    //private
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

    // moze i tako a moze i kao klimenta :)
    // da se uporede ime prezime i br telefona
    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Contacts){
             Contacts item = (Contacts) obj ;
            if(((Contacts) obj).getName().equals(item.getName())){
                return true;
            }

        }

        return false;
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
