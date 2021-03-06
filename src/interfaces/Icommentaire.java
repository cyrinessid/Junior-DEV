/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Commentaire;
import models.Vote;

/**
 *
 * @author Haroun
 */
public interface Icommentaire {
    
    //ajouter
    public boolean ajouterCommentaire(Commentaire c);
    
    //lister
    public List<Commentaire> afficherCommentaires();
    
    public boolean modifierCommentaire(Commentaire c);
    
    public boolean supprimerCommentaire(Commentaire c);
    public Commentaire RetrieveCommentaires(int id);
    public List<Commentaire> TriCommentaires();
    public List<Commentaire> SearchComment(int id_blog);
    
}
