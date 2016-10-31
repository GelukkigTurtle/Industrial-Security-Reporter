/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tascmanager.composer;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.layout.AnchorPaneBuilder;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

/**
 *
 * @author Freddy
 */
public class TASCManager extends Application {
    
 //   private final TableView<User> table = new TableView<User>();
     @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/tascmanager/view/manager.fxml"));
        } catch (Exception e) {
            e.printStackTrace();
            root = AnchorPaneBuilder.create().id("mainWindow").prefWidth(800).prefHeight(600).build();
        }
        Scene scene = new Scene(root, Color.web("#dfdfdf"));
        
        // Image ico = new Image(System.getProperty("user.dir")+ "/reporte/iconLogo.png");
       // primaryStage.getIcons().add(ico);
        primaryStage.setTitle("TASC Reports");
        
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
