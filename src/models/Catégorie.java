/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author chedi
 */
public class Catégorie {
    private int id ;
    private String nom;

    public Catégorie() {
    }

    public Catégorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

  //auto

    public Catégorie(String nom) {
        this.nom = nom;
    }
    


  
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Cat\u00e9gorie{" + "id=" + id + ", nom=" + nom + '}';
    }

    
    

  

   
    
    
    
    
    
    
    
    
    
    
    
}
