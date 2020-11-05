package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;
import view.App;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class InsertProductMenuController implements Initializable {

    static ProductMenu productMenu = new ProductMenu();
    static int quantity;
    static int productId;
    static int productMenuTypeId;
    @FXML
    TextField insertQuantityText;
    @FXML
    ComboBox<ProductMenuType> productMenuTypeComboBox;
    @FXML
    ListView<Product> itemListView;

    @FXML
    Button executeButton;
    @FXML
    Label insertQuantityLabel;
    @FXML
    Button cancelButton;

    @FXML
    int selectProduct(){
        Product product = itemListView.getSelectionModel().getSelectedItem();
        productId = product.getId();
        System.out.println(productId + "%%%%%%%%%%%%%%%%%%");
        return  productId;
    }

    @FXML
    int selectProductMenuType(){

        ProductMenuType productMenuType = productMenuTypeComboBox.getSelectionModel().getSelectedItem();
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

        try {
            App.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
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
        H2ProductDAO h2ProductDAO = new H2ProductDAO();
        List<Product> list = h2ProductDAO.findAll();
        ObservableList<Product> productObservableList = FXCollections.observableArrayList(list);
        itemListView.getItems().setAll(productObservableList);

        H2ProductMenuTypeDAO h2ProductMenuTypeDAO= new H2ProductMenuTypeDAO();
        List<ProductMenuType> productMenuTypeList = h2ProductMenuTypeDAO.findAllProductMenuTypes();
        ObservableList<ProductMenuType> productMenuTypeObservableList = FXCollections.observableArrayList(productMenuTypeList);
        productMenuTypeComboBox.getItems().removeAll(productMenuTypeComboBox.getItems());
        productMenuTypeComboBox.getItems().addAll(productMenuTypeObservableList);

    }

}
