/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.util;

import com.lib.ManagedBeans.Doc;
import com.lib.ManagedBeans.SignIn;
import com.lib.ManagedBeans.User;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
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
    
    public static User getUserInfo(String login){
        Connection con = DataConnect.getConnection();
        String q = "select * from Utilisateur where login='"+login+"'";
        User user=null ;
        try {
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            
            while(rs.next()){
                user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
            }
            
            
        } catch (SQLException ex) {
            
        }finally {
            DataConnect.close(con);
            return user;
        }
    }
    
}
