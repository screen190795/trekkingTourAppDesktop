package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import org.example.model.*;
import org.example.view.App;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class InsertProductMenuController implements Initializable {
    FXMLLoader loader =new FXMLLoader();
    Controller controller= loader.getController();
   static ProductMenu productMenu = new ProductMenu();
    static int quantity;
    static int productId;
    static int productMenuTypeId;
    @FXML
    TextField insertQuantityText;
    @FXML
    ComboBox productMenuTypeComboBox;
    @FXML
    ListView itemListView;

    @FXML
    Button executeButton;
    @FXML
    Label insertQuantityLabel;
    @FXML
    Button cancelButton;

    @FXML
    int selectProduct(){
        Product product = (Product) itemListView.getSelectionModel().getSelectedItem();
        productId = product.getId();
        System.out.println(productId + "%%%%%%%%%%%%%%%%%%");
        return  productId;
    }

    @FXML
     int selectProductMenuType(){
        
      ProductMenuType productMenuType = (ProductMenuType) productMenuTypeComboBox.getSelectionModel().getSelectedItem();
        productMenuTypeId = productMenuType.getId();
      System.out.println(productMenuTypeId);
      return  productMenuTypeId;
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

        for(int i = 0; i < quantity; i++){
          H2ProductMenuDAO h2ProductMenuDAO = new H2ProductMenuDAO();
           productMenu.setProductId(productId);
           productMenu.setProductMenuTypeId(productMenuTypeId);
           System.out.println(productMenu.getProductId() + " " + productMenu.getProductMenuTypeId());
            h2ProductMenuDAO.insertProductMenu(productMenu);
        }

        Controller controller = new Controller();
        try {
            App.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
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
        H2ProductDAO h2ProductDAO = new H2ProductDAO();
        List<Product> list = new ArrayList<>();
        list = h2ProductDAO.findAll();
        ObservableList<Product> productObservableList = FXCollections.observableArrayList(list);
        itemListView.getItems().setAll(productObservableList);

        H2ProductMenuTypeDAO h2ProductMenuTypeDAO= new H2ProductMenuTypeDAO();
        List<ProductMenuType> productMenuTypeList = new ArrayList<>();
        productMenuTypeList= h2ProductMenuTypeDAO.findAllProductMenuTypes();
        ObservableList<ProductMenuType> productMenuTypeObservableList = FXCollections.observableArrayList(productMenuTypeList);
        productMenuTypeComboBox.getItems().removeAll(productMenuTypeComboBox.getItems());
        productMenuTypeComboBox.getItems().addAll(productMenuTypeObservableList);

    }

}
