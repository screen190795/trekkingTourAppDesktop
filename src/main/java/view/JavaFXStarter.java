package view;

import controller.PrimaryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Класс настраивает первичную JavaFX конфигурацию и открывает окно приветствия
 */
public class JavaFXStarter extends Application {
    static Stage stage;
    static Scene scene;
    static Parent root;


    /**
     * Статический метод перехода между окнами
     */
    public static void setRoot(String fxml) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(JavaFXStarter.class.getResource(fxml));


        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/welcomeView.fxml"));
            loader.setController(new PrimaryController());
            root = loader.load();

            scene = new Scene(root);
            primaryStage.setTitle("TrekkingTourApp");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
