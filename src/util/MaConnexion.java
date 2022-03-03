/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chedi
 */
public class MaConnexion{
   
    private final String URL="jdbc:mysql://127.0.0.1:3306/gestion";
    private final String USERNAME="root";
    private final String PWD="";
    
    private Connection cnx;
    static MaConnexion instance = null;
    
    //constructeur

    private MaConnexion() {
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // GETTERS
    public Connection getCnx() {
        return cnx;
    }
    
    public static MaConnexion getInstance() {
        
        if(instance == null){
            instance = new MaConnexion();
        }
        return instance;
    }
                
            
}
