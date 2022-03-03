/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.Catégorie;
import service.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author chedi
 */
public class categorieController implements Initializable {
    
    private Catégorie categorie;

    @FXML
    private ImageView imageLBL;
    @FXML
    private Label nomLBL;
    @FXML
    private Button supprimercategorie;
    @FXML
    private Label idLBL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       public void setData(Catégorie ct){
          
        this.categorie = ct;
        this.idLBL.setText(String.valueOf(ct.getId()));
        this.nomLBL.setText(ct.getNom());
        
       // this.imageLBL.setImage(pt.getImage());
        
    }

    @FXML
    private void supprimerBTN(ActionEvent event) {
         Catégorie c = new Catégorie();
          c.setId(Integer.parseInt(this.idLBL.getText()));
          ServiceCatégorie sc = new ServiceCatégorie();
          sc.supprimerCatégorie(c);
        
    }

    
}
