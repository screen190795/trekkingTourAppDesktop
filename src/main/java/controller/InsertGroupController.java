package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;
import org.h2.jdbc.JdbcSQLException;
import view.App;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class InsertGroupController implements Initializable {
    static Group group = new Group();
    static int quantity;
    static int clientId;
    static int routeTypeId;
    @FXML
    TextField insertQuantityText;
    @FXML
    ComboBox<RouteType> routeTypeComboBox;
    @FXML
    ListView<Client> itemListView;

    @FXML
    Button executeButton;
    @FXML
    Button executeUpdateButton;
    @FXML
    Label insertQuantityLabel;
    @FXML
    Button cancelButton;

    @FXML
    int selectClient(){
        Client client = itemListView.getSelectionModel().getSelectedItem();
        clientId = client.getId();
        System.out.println(clientId);
        return  clientId;
    }

    @FXML
    int selectRouteType(){

        RouteType routeType = routeTypeComboBox.getSelectionModel().getSelectedItem();
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
        Alert alertWindow;
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
        H2ClientDAO h2ClientDAO = new H2ClientDAO();
        List<Client> list = h2ClientDAO.findAllClients();
        ObservableList<Client> productObservableList = FXCollections.observableArrayList(list);
        itemListView.getItems().setAll(productObservableList);

        H2RouteTypeDAO h2RouteTypeDAO = new H2RouteTypeDAO();
        List<RouteType> routeTypeList = h2RouteTypeDAO.findAllRouteTypes();
        ObservableList<RouteType> routeTypeObservableList = FXCollections.observableArrayList(routeTypeList);
        routeTypeComboBox.getItems().removeAll(routeTypeComboBox.getItems());
        routeTypeComboBox.getItems().addAll(routeTypeObservableList);

    }

}
