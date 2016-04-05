/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.util;

import com.lib.ManagedBeans.SignIn;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author wassim
 */
public class UserCRUD {
    
    
    public static boolean addUser(SignIn user){
        Connection con = DataConnect.getConnection();
        String q = "insert into Utilisateur(nom_u,prenom_u,mail_u,adresse_u,pass,login) values( '" +user.getNom() + "','" + user.getPrenom() +"','"+ user.getMail()+"','"+user.getAdresse()+"','"+user.getPass()+"','"+user.getLogin()+"')";
        try {
            Statement commande = con.createStatement();
            int rs = commande.executeUpdate(q);
            return true;
            
            
        } catch (SQLException ex) {
            return false;
        }finally {
            DataConnect.close(con);
        }
    }
}
