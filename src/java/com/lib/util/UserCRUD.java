/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.util;


import com.lib.ManagedBeans.SignIn;
import com.lib.ManagedBeans.UserView;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public static ArrayList<UserView> getAllUsers() {
        ArrayList<UserView> users = new ArrayList<UserView>();
             System.out.println("2");
        try {
            Connection con = DataConnect.getConnection();
            System.out.println("-------------------------------------------------------");
            String q = "select * from Utilisateur";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            System.out.println("2");
            while(rs.next()){
                System.out.println("1");
                System.out.println(rs.getString(1));
                UserView user = new UserView();
                user.setNom(rs.getString(2));
                user.setId(rs.getInt(1));

                users.add(user);
            }
            return users;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
}
