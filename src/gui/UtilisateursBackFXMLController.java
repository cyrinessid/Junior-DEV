/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import models.Employe;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class UtilisateursBackFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Employe e;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setEmploye(Employe e)
    {
        this.e=e;
    }   
    
}
