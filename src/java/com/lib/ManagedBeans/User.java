/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

/**
 *
 * @author wassim
 */
public class User {

    /**
     * Creates a new instance of User
     */
    private String id ;
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
    private String pass;
    private String login;
    private String sanction;
    private String valid;
    
    public User() {
    }

    public User(String id, String nom, String prenom, String mail, String adresse, String pass, String login, String sanction, String valid) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.pass = pass;
        this.login = login;
        this.sanction = sanction;
        this.valid = valid;
    }
    
    

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSanction(String sanction) {
        this.sanction = sanction;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPass() {
        return pass;
    }

    public String getLogin() {
        return login;
    }

    public String getSanction() {
        return sanction;
    }

    public String getValid() {
        return valid;
    }
    
}
