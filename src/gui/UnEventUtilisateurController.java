/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import models.Event;

/**
 * FXML Controller class
 *
 * @author SOULAYMA
 */
public class UnEventUtilisateurController implements Initializable {

    @FXML
    private ImageView imgIV;
    @FXML
    private Label nameLBL;
    @FXML
    private Label proprietaireLBL;
    @FXML
    private Label adressLBL;
    @FXML
    private Label date_ouvLBL;
    @FXML
    private Label idLBL;
    @FXML
    private Label modifierBTN;
    private Event event;
    @FXML
    private Label notezBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setData(Event pt){
        this.event = pt;
        this.idLBL.setText(String.valueOf(pt.getEvent_Id()));
        this.nameLBL.setText(pt.getTitre());
        this.proprietaireLBL.setText(String.valueOf(pt.getPrix()));
        this.date_ouvLBL.setText(pt.getDate_Event().toString());
        this.adressLBL.setText(pt.getDescription());
        
    }
    
    public Event getData(){
        return event;
    }


    @FXML
    private void notezClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rate.fxml"));
            Parent root = loader.load();
           
          ((BorderPane)imgIV.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent()).setCenter(root);
        } 
    }

