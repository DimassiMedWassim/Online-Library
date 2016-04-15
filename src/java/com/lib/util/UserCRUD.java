/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib.util;

import com.lib.ManagedBeans.Doc;
import com.lib.ManagedBeans.SignIn;
import com.lib.ManagedBeans.UserView;
import com.lib.ManagedBeans.User;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author wassim
 */
@ManagedBean

public class UserCRUD {
    
    
    public static boolean addUser(SignIn user){
        Connection con = DataConnect.getConnection();
        System.out.println(con);
        String q = "insert into Utilisateur(nom_u,prenom_u,mail_u,adresse_u,pass,login) values( '" +user.getNom() + "','" + user.getPrenom() +"','"+ user.getMail()+"','"+user.getAdresse()+"','"+user.getPass()+"','"+user.getLogin()+"')";
        System.out.println(q);
        try {
            System.out.println(con);
            Statement commande = con.createStatement();
            int rs = commande.executeUpdate(q);
            System.out.println(rs);
            System.out.println(".............signing in .............");
            return true;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }finally {
            DataConnect.close(con);
        }
    }

    public static ArrayList<Users> getAllUsers() {
        ArrayList<Users> users = new ArrayList<Users>();
        Connection con = DataConnect.getConnection();
        try {
            
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
        }finally {
            DataConnect.close(con);
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
