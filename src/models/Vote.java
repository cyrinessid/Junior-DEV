/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Haroun
 */
public class Vote {
    private int id;
    private int type;
    private Commentaire id_source;
    //deault constructor
    public Vote() {
    }
    //full comment constructor

    public Vote(int id, int type, Commentaire id_source) {
        this.id = id;
        this.type = type;
        this.id_source = id_source;
    }

    
    
    
    //comment constructor no id
    public Vote(int type, Commentaire id_source) {
        this.type = type;
        this.id_source = id_source;
    }

       
    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public Commentaire getId_source() {
        return id_source;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId_source(Commentaire id_source) {
        this.id_source = id_source;
    }

    @Override
    public String toString() {
        return "Vote{" + "id=" + id + ", type=" + type + ", id_source=" + id_source + '}';
    }

    

    
    
    
    
    
    
    
}
