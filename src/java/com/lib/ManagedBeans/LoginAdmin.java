/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.LoginVal;
import com.lib.util.SessionBean;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hidro
 */
@ManagedBean
@RequestScoped
public class LoginAdmin implements Serializable{

    /**
     * Creates a new instance of LoginAdmin
     */
    public LoginAdmin() {
    }
    private String username;
     
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    public String login() {
        boolean valid = LoginVal.validate(username, password,"Administrateur");
        if (valid) {
            HttpSession session = SessionBean.getSession();
            System.out.println(username);
            System.out.println(password);
            session.setAttribute("username", username);
            return "admin";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }
 
    //logout event, invalidate session
    public String logout() {
       System.out.println("logout");
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login";
    }
    
}
