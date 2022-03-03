/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Event;
import models.Reservation;

/**
 *
 * @author SOULAYMA
 * @param <T>
 */
public interface IService<T> {
    
    public void ajout(T t);
    public void modifier(T t);
    public void supprimer(int t);
    public List<T> afficher();
    public T retrieve(int id);
    
}
