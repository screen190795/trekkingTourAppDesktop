package org.example.controller;
import javafx.event.ActionEvent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.model.*;
import org.h2.jdbc.JdbcSQLException;
import org.example.view.App;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class InsertEquipmentController implements Initializable {
    FXMLLoader loader =new FXMLLoader();
    Controller controller= loader.getController();
   static Equipment equipment = new Equipment();
    static int quantity;
    static int itemId;
    static int equipmentTypeId;
    @FXML
    TextField insertQuantityText;
    @FXML
    ComboBox equipmentTypeComboBox;
    @FXML
    ListView itemListView;

    @FXML
    Button executeButton;
    @FXML
    Button executeUpdateButton;
    @FXML
    Label insertQuantityLabel;
    @FXML
    Button cancelButton;
    private Alert alertWindow;

    @FXML
    int selectItem(){
        Item item = (Item) itemListView.getSelectionModel().getSelectedItem();
        itemId = item.getId();
        System.out.println(itemId);
        return  itemId;
    }

    @FXML
     int selectEquipmentType(){
        EquipmentType equipmentType = (EquipmentType) equipmentTypeComboBox.getSelectionModel().getSelectedItem();
      equipmentTypeId = equipmentType.getId();
      System.out.println(equipmentTypeId);
      return  equipmentTypeId;
    }



    @FXML
    int  selectQuantity(){
        insertQuantityLabel.setText("ОК");
        try {
            quantity= Integer.parseInt(insertQuantityText.getText());

        }catch (Exception e){
            insertQuantityLabel.setText("Некорректное значение");
        }

        return quantity;
    }


    @FXML
    void execute() {
        try {
        for(int i = 0; i < quantity; i++){
            H2EquipmentDAO h2EquipmentDAO = new H2EquipmentDAO();
           equipment.setItemId(itemId);
           equipment.setEquipmentTypeId(equipmentTypeId);
           if(equipment.getItemId()==0|| equipment.getEquipmentTypeId() ==0){
               throw new JdbcSQLException("u","u","u",5,  new Throwable(),"u");
           }
           System.out.println(equipment.getItemId() + " " + equipment.getEquipmentTypeId());
            h2EquipmentDAO.insertEquipment(equipment);
        }
        Controller controller = new Controller();
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
        Controller controller = new Controller();
        try {
            App.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        H2ItemDAO h2ItemDAO = new H2ItemDAO();
        List<Item> list = new ArrayList<>();
        list = h2ItemDAO.findAll();
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList(list);
        itemListView.getItems().setAll(itemObservableList);

        H2EquipmentTypeDAO h2EquipmentTypeDAO= new H2EquipmentTypeDAO();
        List<EquipmentType> equipmentTypeList = new ArrayList<>();
        equipmentTypeList = h2EquipmentTypeDAO.findAll();
        ObservableList<EquipmentType> equipmentTypeObservableList = FXCollections.observableArrayList(equipmentTypeList);
        equipmentTypeComboBox.getItems().removeAll(equipmentTypeComboBox.getItems());
        equipmentTypeComboBox.getItems().addAll(equipmentTypeObservableList);

    }

}
