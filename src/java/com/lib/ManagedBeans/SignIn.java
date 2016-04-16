/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.SessionBean;
import com.lib.util.UserCRUD;
import java.util.Date;
import javax.inject.Named;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wassim
 */
@ManagedBean
@Named(value = "signIn")

public class SignIn {
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
    private String pass ;
    private String login;
   
    /**
     * Creates a new instance of SignIn
     */
    public SignIn(){
        
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
    
    public String sign(){
        System.out.println(login);
            System.out.println(pass);
        if(UserCRUD.addUser(this)){
            HttpSession session = SessionBean.getSession();
            
            session.setAttribute("username", login);
            
            return "ok";
            
        }
        return "sign";
    }
     
    
 
    
    
}
