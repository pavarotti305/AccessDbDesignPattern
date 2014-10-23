/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package access_db_design_pattern;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tordeepweb
 */
public class SingletonData {

    private static String url = "jdbc:mysql://192.168.29.10/speedymarketclass";
    private static String utilisateur = "root";
    private static String mdp = "Materobi";
    private static Connection connexion = null;
    private static SingletonData monSingletonData = null;
    private Statement statement;

    //singletondata constructeur

    private SingletonData() {

        try {
            SingletonData.connexion = DriverManager.getConnection(SingletonData.url, SingletonData.utilisateur, SingletonData.mdp);
            statement = (Statement) SingletonData.connexion.createStatement();
        } catch (SQLException ex) {

        }
    }

    public static SingletonData getSingletonData() {
        if (SingletonData.monSingletonData == null) {
            SingletonData.monSingletonData = new SingletonData();
        }
        return SingletonData.monSingletonData;
    }

    public ResultSet requeteSelection(String requete) {
        ResultSet r = null;
        try {
            r = statement.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(SingletonData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int requeteAction(String requete) {
        int r = -1;
        try {
            r = statement.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(SingletonData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
