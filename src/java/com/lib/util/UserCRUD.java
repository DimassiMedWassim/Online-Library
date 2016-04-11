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
    public static ArrayList<Users> getAllUsers() {
        ArrayList<Users> users = new ArrayList<Users>();
        try {
            Connection con = DataConnect.getConnection();
            String q = "select * from Utilisateur";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            System.out.println("2");
            while(rs.next()){
                System.out.println("1");
                System.out.println(rs.getString(1));
                Users user = new Users();
                user.setId(rs.getString(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPass(rs.getString(6));
                user.setLogin(rs.getString(7));
                user.setSanction(rs.getString(8));
                user.setValid(rs.getString(9));

                users.add(user);
            }
            return users;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }

    public static ArrayList<Users> getNVUser() {
        
        ArrayList<Users> users = new ArrayList<Users>();
        try {
            
            Connection con = DataConnect.getConnection();
            String q = "select * from Utilisateur where valid='0'";
            Statement commande = con.createStatement();
            ResultSet rs = commande.executeQuery(q);
            while(rs.next()){
                Users user = new Users();
                user.setId(rs.getString(1));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPass(rs.getString(6));
                user.setLogin(rs.getString(7));
                user.setSanction(rs.getString(8));
                user.setValid(rs.getString(9));

                users.add(user);
            }
            return users;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
}
