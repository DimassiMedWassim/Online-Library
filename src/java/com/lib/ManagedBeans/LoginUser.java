/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.ManagedBeans;

import com.lib.util.LoginVal;
import com.lib.util.SessionBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wassim
 */
@ManagedBean
@RequestScoped
public class LoginUser {

    private String username;
    private String password;

    /**
     * Creates a new instance of LoginUser
     */
    public LoginUser() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        boolean valid = LoginVal.validate(username, password, "Utilisateur");
        if (valid) {
            HttpSession session = SessionBean.getSession();
            System.out.println(username);
            System.out.println(password);
            session.setAttribute("username", username);
            return "user";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

}
