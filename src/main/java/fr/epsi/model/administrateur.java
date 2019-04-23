package fr.epsi.model;

import javax.persistence.Entity;

@Entity
public class administrateur extends User {

    private String surnom;

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }
}
