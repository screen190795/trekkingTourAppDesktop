package org.example.view;

import org.example.controller.PrimaryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    static Stage stage;
    static Scene scene;
    static Parent root;
        @Override
        public void start(Stage primaryStage) {
            try {
                stage = primaryStage;
                int width = 7;
                int height = 7;
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("welcomeView.fxml"));
                loader.setController(new PrimaryController());
                 root = loader.load();

                scene = new Scene(root);
                primaryStage.setTitle("TrakkingTourApp");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    public static void setRoot(String fxml) throws IOException {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(App.class.getResource(fxml));


        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
    }


    public static void main(String[] args) {
        launch(args);

    }
}
