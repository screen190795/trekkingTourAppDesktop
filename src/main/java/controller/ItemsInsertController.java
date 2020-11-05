package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.H2ItemDAO;
import model.Item;
import org.h2.jdbc.JdbcSQLException;
import view.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ItemsInsertController implements Initializable {
    @FXML
    TextField insertNameText;
    @FXML
    TextField insertWeightText;
    @FXML
    TextField insertVolumeText;
    @FXML
    TextField insertDescriptionText;
    @FXML
    Button executeButton;
    @FXML
    Label insertNameLabel;
    @FXML
    Label insertWeightLabel;
    @FXML
    Label insertVolumeLabel;
    @FXML
    Label insertDescriptionLabel;
    @FXML
    Button cancelButton;
    @FXML
    Alert alertWindow;


    Item item = new Item();
    Throwable throwable = new Throwable();


    @FXML
    private void insertName() {
        insertNameLabel.setText("ОК");
        try {
            String name = String.valueOf(insertNameText.getText());
            item.setName(name);
        }catch(Exception e){
            insertNameLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertWeight(){
        insertWeightLabel.setText("ОК");
        try {
            float weight = Float.parseFloat(insertWeightText.getText());
            item.setWeight(weight);
        }catch (Exception e){
            insertWeightLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertVolume() {
        insertVolumeLabel.setText("ОК");
        try {
            float volume = Float.parseFloat(insertVolumeText.getText());
            item.setWeight(volume);
        } catch (Exception e){
            insertVolumeLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertDescription(){
        insertDescriptionLabel.setText("ОК");
        try {
            String description = insertDescriptionText.getText();
            item.setDescription(description);
        } catch(Exception e){
            insertDescriptionLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void execute() {
        try {
            H2ItemDAO h2ItemDAO = new H2ItemDAO();
            h2ItemDAO.insertItem(item);
            if(item.getName()==null||item.getWeight() ==0){

                throw new JdbcSQLException("u","u","u",5, throwable,"u");
            }
            App.setRoot("/trakkingAppView.fxml");
        } catch (JdbcSQLException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Заполнены не все данные. Пожалуйста, укажите необходимые данные и повторите попытку");
            alertWindow.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void cancel() {
        try {
            App.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
