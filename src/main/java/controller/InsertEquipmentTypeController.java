package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;
import view.JavaFXStarter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static controller.Controller.updatedEquipmentType;


public class InsertEquipmentTypeController implements Initializable {

    @FXML
    TextField insertNameText;
    @FXML
    TextField insertWeightText;
    @FXML
    TextField insertPurposeText;
    @FXML
    TextField insertDescriptionText;
    @FXML
    Button executeButton;
    @FXML
    Button executeUpdateButton;
    @FXML
    Label insertNameLabel;
    @FXML
    Label insertWeightLabel;
    @FXML
    Label insertPurposeLabel;
    @FXML
    Label insertDescriptionLabel;
    @FXML
    Button cancelButton;


    EquipmentType equipmentType = new EquipmentType();


    @FXML
    private void insertName() {
        insertNameLabel.setText("ОК");
        try {
            String name = String.valueOf(insertNameText.getText());
            equipmentType.setName(name);
            updatedEquipmentType.setName(name);
        }catch(Exception e){
            insertNameLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertWeight(){
        insertWeightLabel.setText("ОК");
        try {
            int weight = Integer.parseInt(insertWeightText.getText());
            equipmentType.setMaxWeight(weight);
            updatedEquipmentType.setMaxWeight(weight);
        }catch (Exception e){
            insertWeightLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertPurpose() {
        insertPurposeLabel.setText("ОК");
        try {
            String purpose = String.valueOf(insertPurposeText.getText());
            equipmentType.setPurpose(purpose);
            updatedEquipmentType.setPurpose(purpose);
        } catch (Exception e){
            insertPurposeLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertDescription(){
        insertDescriptionLabel.setText("ОК");
        try {
            String description = insertDescriptionText.getText();
            equipmentType.setDescription(description);
            updatedEquipmentType.setDescription(description);
        } catch(Exception e){
            insertDescriptionLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void execute() {

        H2EquipmentTypeDAO h2EquipmentTypeDAO = new H2EquipmentTypeDAO();
        h2EquipmentTypeDAO.insertEquipmentType(equipmentType);

        try {
            JavaFXStarter.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void executeUpdate() {

        H2EquipmentTypeDAO h2EquipmentTypeDAO = new H2EquipmentTypeDAO();
        h2EquipmentTypeDAO.updateEquipmentType(updatedEquipmentType);


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
