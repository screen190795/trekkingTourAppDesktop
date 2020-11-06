package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import model.H2Script;
import view.JavaFXStarter;

import java.io.File;
import java.io.IOException;


public class PrimaryController {

    @FXML
    Button welcomeButton;
    @FXML
    Button scriptButton;

    @FXML
    private void switchToSecondary() throws IOException {
        JavaFXStarter.setRoot("/trakkingAppView.fxml");
    }

    @FXML
    private void initialize() {
        welcomeButton.setOnAction((event) -> {
            try {
                this.switchToSecondary();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void executeScript(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Open Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("sql files (*.sql)", "*.sql");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(null);

        H2Script h2Script = new H2Script();
        try {
            h2Script.executeScript(file);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("База данных уже выгружена");
            alertWindow.showAndWait();
        }
        Alert notification = new Alert(Alert.AlertType.INFORMATION);
        notification.setHeaderText("База данных успешно выгружена.");
        notification.showAndWait();
    }
}
