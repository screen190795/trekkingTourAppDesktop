package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.H2ItemDAO;
import view.JavaFXStarter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static controller.Controller.updatedItem;


public class ItemsUpdateController implements Initializable {



    @FXML
    TextField updateNameField;
    @FXML
    TextField updateWeightField;
    @FXML
    TextField updateVolumeField;
    @FXML
    TextField updateDescriptionField;
    @FXML
    Button executeButton;
    @FXML
    Label updateNameLabel;
    @FXML
    Label updateWeightLabel;
    @FXML
    Label updateVolumeLabel;
    @FXML
    Label updateDescriptionLabel;
    @FXML
    Button cancelButton;



    @FXML
    private void updateName() {
        updateNameLabel.setText("ОК");
        try {
            String name = String.valueOf(updateNameField.getText());
            updatedItem.setName(name);
        }catch(Exception e){
            updateNameLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void updateWeight(){
        updateWeightLabel.setText("ОК");
        try {
            float weight = Float.parseFloat(updateWeightField.getText());
            updatedItem.setWeight(weight);
        }catch (Exception e){
            updateWeightLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void updateVolume() {
        updateVolumeLabel.setText("ОК");
        try {
            float volume = Float.parseFloat(updateVolumeField.getText());
            updatedItem.setWeight(volume);
        } catch (Exception e){
            updateVolumeLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void updateDescription(){
        updateDescriptionLabel.setText("ОК");
        try {
            String description = updateDescriptionField.getText();
            updatedItem.setDescription(description);
        } catch(Exception e){
            updateDescriptionLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void execute() {

        H2ItemDAO h2ItemDAO = new H2ItemDAO();
        h2ItemDAO.updateItem(updatedItem);
        try {
            JavaFXStarter.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancel() {
        try {
            JavaFXStarter.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
