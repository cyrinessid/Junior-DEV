/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Iutilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import models.InputValidation;
import models.Utilisateur;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author 21694
 */
public class SignUpFXMLController implements Initializable {

    Iutilisateur su = new ServiceUtilisateur();
    private Stage stage;
    private Scene scene;
    private Parent root;
    private MediaPlayer mediaPlayer;
    private Media media;
    
    @FXML
    private MediaView mediaView;
    @FXML
    private TextField loginTF;
    @FXML
    private Label signin;
    @FXML
    private Label prenomMsg;
    @FXML
    private Label nomMsg;
    @FXML
    private Label emailMsg;
    @FXML
    private Label dateMsg;
    @FXML
    private Label loginMsg;
    @FXML
    private Label mdpMsg;
    @FXML
    private Label mdpvMsg;
    @FXML
    private TextField prenomTF;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField emailTF;
    @FXML
    private DatePicker dateDP;
    @FXML
    private PasswordField mdpTF;
    @FXML
    private PasswordField mdpverifTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String path = new File("src\\gui\\elements\\video\\final2.mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(15));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
    }    

    @FXML
    private void signin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignInFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submitBT(ActionEvent event) {
        boolean testPrenom =  InputValidation.textFilledIsNull(prenomTF, prenomMsg, "Le pr??nom est requis");
      boolean testNom =  InputValidation.textFilledIsNull(nomTF, nomMsg, "Le nom est requis");
      boolean testLogin = InputValidation.textFilledIsNull(loginTF, loginMsg, "Le login est requis");
      boolean testMdp = InputValidation.textFilledIsNull(mdpTF, mdpMsg, "Le mot de passe est requis");
      boolean testMdpv = InputValidation.textFilledIsNull(mdpverifTF, mdpvMsg, "Le mot de passe est requis");
      boolean testEmail = InputValidation.textFilledIsNull(emailTF, emailMsg, "L'adresse email est requise");
      boolean testEmailFormat = InputValidation.emailFormat(emailTF, emailMsg, "Exemple: quantech@gmail.com");
      boolean testMdpFormat = InputValidation.dataLength(mdpTF, mdpMsg, "Doit contenir 8 caract??res", "8");
      boolean testMdpvFormat = InputValidation.dataLength(mdpverifTF, mdpvMsg, "Doit contenir 8 caract??res", "8");
      
      Utilisateur u;
      if(!testPrenom && !testNom && !testLogin && !testMdp && !testMdpv && !testEmail && testEmailFormat && testMdpFormat && testMdpvFormat)
      {
          u = new Utilisateur(loginTF.getText(),mdpTF.getText(),Date.valueOf(dateDP.getValue()),nomTF.getText(),prenomTF.getText(),emailTF.getText());
      
            if (mdpTF.getText().equals(mdpverifTF.getText()))
        {
            if(su.ajouterUtilisateur(u).getId()!=0)
                JOptionPane.showMessageDialog(null, "Utilisateur Ajout??");
            else
                JOptionPane.showMessageDialog(null, "Echec d'ajout");
        }       
            else
                JOptionPane.showMessageDialog(null, "V??rifiez la similarit?? des mots de passe");

      }
    }
    
}
