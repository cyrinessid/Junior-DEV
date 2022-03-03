/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


import java.sql.Date;

/**
 *
 * @author Haroun
 */
public class Commentaire {
    
    private int id;
    private String contenu;
    private Date date;
    private Blog id_blog;

    public Commentaire() {
    }

    public Commentaire(String contenu) {
        this.contenu = contenu;
    }

    public Commentaire(int id, String contenu) {
        this.id = id;
        this.contenu = contenu;
    }
    

    public Commentaire(int id, String contenu, Date date, Blog id_blog) {
        this.id = id;
        this.contenu = contenu;
        this.date = date;
        this.id_blog = id_blog;
    }

    public Commentaire(String contenu, Date date, Blog id_blog) {
        this.contenu = contenu;
        this.date = date;
        this.id_blog = id_blog;
    }

    public Commentaire(int id, String contenu, Date date) {
        this.id = id;
        this.contenu = contenu;
        this.date = date;
    }
    
    
    
    
    //GETTERS
    public int getId() {
        return id;
    }
    
    public String getContenu() {
        return contenu;
    }

    public Date getDate() {
        return date;
    }

    public Blog getId_blog() {
        return id_blog;
    }
    
    
    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId_blog(Blog id_blog) {
        this.id_blog = id_blog;
    }

    
    //toString

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", contenu=" + contenu + ", date=" + date + ", id_blog=" + id_blog + '}';
    }
    
    
    
    
}
