/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tascmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Freddy
 */
public class AlertaController implements Initializable {

    @FXML //  fx:id="btnOK"
    private Button btnOK; // Value injected by FXMLLoader
    @FXML //  fx:id="panelPrincipal"
    private AnchorPane panelPrincipal; // Value injected by FXMLLoader
    @FXML //  fx:id="panelinterior"
    private AnchorPane panelinterior; // Value injected by FXMLLoader
    @FXML //  fx:id="imagen"
    private ImageView imagen; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        panelPrincipal.setStyle("-fx-background-color: #404040;");
        panelinterior.setStyle("-fx-background-color: white;");
        // imagen.setImage(imageDecline);
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                btnOK.getScene().getWindow().hide();
            }
        });
        // TODO
    }
//    @FXML
//    void clickOKs(ActionEvent event) {
//        btnOK.getScene().getWindow().hide();
//    } onAction="clickOKs" 
}
