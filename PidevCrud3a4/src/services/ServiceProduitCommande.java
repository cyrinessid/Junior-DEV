/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Iproduitcommande;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ProduitCommande;
import utils.MaConnexion;

/**
 *
 * @author ASUS
 */
public class ServiceProduitCommande implements Iproduitcommande {

     //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    
    @Override
    public boolean ajouterProduitCommande(ProduitCommande s) {
          String request = "INSERT INTO `produit_commande`(`id`,`id_commande`,`id_produit`,`quantite`) VALUES ('"+s.getId()+"','"+s.getId_commande()+"','"+s.getId_produit()+"','"+s.getQuantite()+"')";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                return true;
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ProduitCommande> afficherProduitCommande() {
         
        List<ProduitCommande> produit_commande = new ArrayList<ProduitCommande>();
    

        String req="SELECT * FROM `produit_commande`";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

           
            while(rs.next()){
                produit_commande.add(new ProduitCommande (rs.getInt("id"),rs.getInt ("id_commande"),rs.getInt("id_produit"),rs.getInt("quantite")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return produit_commande;
    }

    @Override
 
     public boolean modifierProduitCommande(ProduitCommande s) {
       String req = "UPDATE `produit_commande` SET `quantite`='"+s.getQuantite()+"' WHERE `id` = '"+s.getId()+"'";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
    }
    }

    @Override
    public boolean supprimerProduitCommande(ProduitCommande s) {
       String req = "DELETE FROM `produit_commande` WHERE `id` = "+s.getId()+"";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    
    }
    }

 
      

 
  
    
