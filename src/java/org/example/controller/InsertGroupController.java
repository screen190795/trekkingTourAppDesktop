package org.example.controller;

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


public class InsertGroupController implements Initializable {
    FXMLLoader loader =new FXMLLoader();
    Controller controller= loader.getController();
   static Group group = new Group();
    static int quantity;
    static int clientId;
    static int routeTypeId;
    @FXML
    TextField insertQuantityText;
    @FXML
    ComboBox routeTypeComboBox;
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
    int selectClient(){
        Client client = (Client) itemListView.getSelectionModel().getSelectedItem();
        clientId = client.getId();
        System.out.println(clientId);
        return  clientId;
    }

    @FXML
     int selectRouteType(){
        
      RouteType routeType = (RouteType) routeTypeComboBox.getSelectionModel().getSelectedItem();
        routeTypeId = routeType.getRouteTypeId();
      System.out.println(routeTypeId);
      return  routeTypeId;
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
        for(int i = 0; i < quantity; i++) {
            H2GroupDAO h2GroupDAO = new H2GroupDAO();
            group.setClientId(clientId);
            group.setRouteTypeId(routeTypeId);
            System.out.println(group.getClientId() + " " + group.getRouteTypeId());
            h2GroupDAO.insertGroup(group);
            if (clientId == 0 || routeTypeId == 0) {
                throw new JdbcSQLException("u", "u", "u", 5, new Throwable(), "u");
            }
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
       H2ClientDAO h2ClientDAO = new H2ClientDAO();
        List<Client> list = new ArrayList<>();
        list = h2ClientDAO.findAllClients();
        ObservableList<Client> productObservableList = FXCollections.observableArrayList(list);
        itemListView.getItems().setAll(productObservableList);

        H2RouteTypeDAO h2RouteTypeDAO = new H2RouteTypeDAO();
        List<RouteType> routeTypeList = new ArrayList<>();
        routeTypeList= h2RouteTypeDAO.findAllRouteTypes();
        ObservableList<RouteType> routeTypeObservableList = FXCollections.observableArrayList(routeTypeList);
        routeTypeComboBox.getItems().removeAll(routeTypeComboBox.getItems());
        routeTypeComboBox.getItems().addAll(routeTypeObservableList);

    }

}
