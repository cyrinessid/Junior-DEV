/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interfaces.Iproduits;
import models.Produit;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chedi
 */
public class ServiceProduit implements Iproduits{
    
     Connection cnx = utils.MaConnexion.getInstance().getCnx();
     ServiceCatégorie serviceCatégorie = new ServiceCatégorie();

    @Override
    public boolean ajouterProduit(Produit p) {
            String request = "INSERT INTO `produits`(`id_catégorie`,`nom`, `prix`, `image`, `promotion`) VALUES ("+p.getCatégorie().getId()+",'"+p.getNom()+"',"+p.getPrix()+",'"+p.getImage()+"',"+p.getPromotion()+")";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                    return true;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        
    }

    @Override
    public List<Produit> afficherProduit() {
        List<Produit> produits = new ArrayList<Produit>();
           String req="SELECT * FROM produits";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                produits.add(new Produit(rs.getInt("id"),serviceCatégorie.retrivecatégorie(rs.getInt("id_catégorie")),rs.getString("nom"),rs.getInt("prix"),rs.getString("image"),rs.getDouble("promotion")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return produits;
    }
    

    @Override
    public boolean modifierProduit(Produit p) {
       String req = "UPDATE `produits` SET `nom`='"+p.getNom()+"',`prix`="+p.getPrix()+",`image`='"+p.getImage()+"' ,`id_catégorie`="+p.getCatégorie().getId()+" WHERE id = "+p.getId()+" ";
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
    public boolean supprimerProduit(Produit p) {
       String req = "DELETE FROM `produits` WHERE id = "+p.getId()+" ";

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
    public List<Produit> rechercherProduit(String nom) {
        List<Produit> produits = new ArrayList<Produit>();
           String req="SELECT * FROM produits WHERE nom = '"+nom+"' ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                produits.add(new Produit(rs.getInt("id"),serviceCatégorie.retrivecatégorie(rs.getInt("id_catégorie")),rs.getString("nom"),rs.getInt("prix"),rs.getString("image"),rs.getDouble("promotion")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return produits;
    }

    @Override
    public List<Produit> filtrageproduit(int price1, int price2) {
           List<Produit> produits = new ArrayList<Produit>();
           String req="SELECT * FROM produits WHERE prix BETWEEN "+price1+" AND "+price2+" ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                produits.add(new Produit(rs.getInt("id"),serviceCatégorie.retrivecatégorie(rs.getInt("id_catégorie")),rs.getString("nom"),rs.getInt("prix"),rs.getString("image"),rs.getDouble("promotion")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return produits;
        
    }

    @Override
    public List<Produit> triproduit() {
             List<Produit> produits = new ArrayList<Produit>();
           String req="SELECT * FROM produits ORDER BY prix ASC ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                produits.add(new Produit(rs.getInt("id"),serviceCatégorie.retrivecatégorie(rs.getInt("id_catégorie")),rs.getString("nom"),rs.getInt("prix"),rs.getString("image"),rs.getDouble("promotion")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return produits;
       
    }

    @Override
    public Produit retriveproduit(int id) {
        Produit produit =  null;
           String req="SELECT * FROM produits WHERE id = '"+id+"' ";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while(rs.next()){
                produit=new Produit(rs.getInt("id"),serviceCatégorie.retrivecatégorie(rs.getInt("id_catégorie")),rs.getString("nom"),rs.getInt("prix"),rs.getString("image"),rs.getDouble("promotion"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return produit;
        
    }

    @Override
    public Produit calculerPromotion(Produit p) {
         if (p.getPromotion() != 0) {
            p.setPrix((int) (p.getPrix() - (p.getPrix() * (p.getPromotion() / 100))));
            System.out.println(" Le prix final aprés promotion est : " + p.getPrix());
            String req = "UPDATE `produits` SET `prix`='"+p.getPrix()+"'WHERE id = "+p.getId()+" " ;
             try {
                 Statement st = cnx.createStatement();
                boolean prix = st.executeUpdate(req) == 1;
             } catch (SQLException e) {

             }
        }
        
         
         
   
        return p;
    
    
    }

   


    
}