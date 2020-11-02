package org.example.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import org.example.model.*;
import org.example.view.App;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    FXMLLoader loader = new FXMLLoader();
    Controller controller = loader.getController();
    static Item updatedItem = new Item();
    static Product updatedProduct = new Product();
    static EquipmentType updatedEquipmentType = new EquipmentType();
    static ProductMenuType updatedProductMenuType = new ProductMenuType();
    static Client updatedClient = new Client();
    static RouteType updatedRouteType = new RouteType();
    static TourProject updatedTourProject = new TourProject();

    @FXML
    Button insertButton;

    @FXML
    Button deleteButton;

    @FXML
    Button updateButton;

    @FXML
    Button insertProductButton;

    @FXML
    Button deleteProductButton;

    @FXML
    Button updateProductButton;

    @FXML
    TitledPane itemsTitlePane;

    @FXML
    TitledPane productsTitlePane;

    @FXML
    ListView itemsListView;

    @FXML
    TitledPane equipmentTypeTitledPane;

    @FXML
    Button insertEquipmentTypeButton;

    @FXML
    Button updateEquipmentTypeButton;

    @FXML
    Button deleteEquipmentTypeButton;

    @FXML
    TitledPane equipmentTitledPane;

    @FXML
    Button showEquipmentButton;

    @FXML
    ListView additionalListView;

    @FXML
    Button deleteEquipmentButton;

    @FXML
    TitledPane productMenuTypesTitledPane;

    @FXML
    Button insertProductMenuTypeButton;

    @FXML
    Button updateProductMenuTypeButton;

    @FXML
    Button deleteProductMenuTypeButton;

    @FXML
    TitledPane productMenuTitledPane;

    @FXML
    Button showProductMenuButton;

    @FXML
    Button deleteProductMenuButton;

    @FXML
    TitledPane clientsTitledPane;

    @FXML
    Button insertClientButton;

    @FXML
    Button updateClientButton;

    @FXML
    Button deleteClientButton;

    @FXML
    Label alertClientLabel;

    @FXML
    TitledPane routeTypeTitledPane;

    @FXML
    Button insertRouteTypeButton;

    @FXML
    Button updateRouteTypeButton;

    @FXML
    Button deleteRouteTypeButton;

    @FXML
    Alert alertWindow;

    @FXML
    TitledPane groupTitledPane;

    @FXML
    Button showGroupButton;

    @FXML
    Button deleteGroupButton;

    @FXML
    Button insertGroupButton;

    @FXML
    TitledPane tourProjectTitledPane;

    @FXML
    Button insertTourProjectButton;

    @FXML
    Button updateTourProjectButton;

    @FXML
    Button deleteTourProjectButton;

    @FXML
    Button exportTourProjectButton;

    @FXML
    private void insert() {

        ItemsInsertController itemsInsertController = new ItemsInsertController();
        try {
            App.setRoot("/insertView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void delete() {
        try {
            Item item = (Item) itemsListView.getSelectionModel().getSelectedItem();
            H2ItemDAO h2ItemDAO = new H2ItemDAO();
            h2ItemDAO.deleteItem(item.getId());
            List<Item> list;
            list = h2ItemDAO.findAll();
            ObservableList<Item> itemObservableList = FXCollections.observableArrayList(list);
            itemsListView.getItems().setAll(itemObservableList);
        if(item == null){
            throw new NullPointerException();
        }
    } catch (NullPointerException e) {
        e.printStackTrace();
        alertWindow = new Alert(Alert.AlertType.WARNING);
        alertWindow.setHeaderText("Не выбран элемент'");
        alertWindow.showAndWait();


    } catch (Exception e) {
        e.printStackTrace();
        alertWindow = new Alert(Alert.AlertType.ERROR);
        alertWindow.setHeaderText("Неизвестная ошибка");
        alertWindow.showAndWait();
    }
    }

    @FXML
    private void update() {
        try {
        updatedItem = (Item) itemsListView.getSelectionModel().getSelectedItem();
        ItemsUpdateController itemsUpdateController = new ItemsUpdateController();
        if(updatedItem == null){
            throw new NullPointerException();
        }
            App.setRoot("/updateView.fxml");
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }

    }

    @FXML
    private void updateProduct() {
        try {
        updatedProduct = (Product) itemsListView.getSelectionModel().getSelectedItem();
        InsertProductController itemsInsertController = new InsertProductController();
        if(updatedProduct == null){
            throw new NullPointerException();
        }
            App.setRoot("/insertProductView.fxml");
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void findAllItems() {
        H2ItemDAO h2ItemDAO = new H2ItemDAO();
        List<Item> list = new ArrayList<>();
        list = h2ItemDAO.findAll();
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList(list);
        itemsListView.getItems().setAll(itemObservableList);
    }

    @FXML
    private void findAllProducts() {
        H2ProductDAO h2ProductDAO = new H2ProductDAO();
        List<Product> list2 = new ArrayList<>();
        list2 = h2ProductDAO.findAll();
        ObservableList<Product> productObservableList = FXCollections.observableArrayList(list2);
        itemsListView.getItems().setAll(productObservableList);
    }



    @FXML
    private void insertProduct() {
        InsertProductController insertProductController = new InsertProductController();
        try {
            App.setRoot("/insertProductView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }


    @FXML
    private void deleteProduct() {
        try{
        Product product = (Product) itemsListView.getSelectionModel().getSelectedItem();
        H2ProductDAO h2ProductDAO = new H2ProductDAO();
        h2ProductDAO.deleteProduct(product.getId());
        List<Product> list = new ArrayList<>();
        list = h2ProductDAO.findAll();
        ObservableList<Product> productObservableList = FXCollections.observableArrayList(list);
        itemsListView.getItems().setAll(productObservableList);
            if(product == null){
                 throw new NullPointerException();
             }
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void findAllEquipmentTypes() {
        H2EquipmentTypeDAO h2EquipmentTypeDAO = new H2EquipmentTypeDAO();
        List<EquipmentType> list3 = new ArrayList<>();
        list3 = h2EquipmentTypeDAO.findAll();
        ObservableList<EquipmentType> equipmentTypeObservableList = FXCollections.observableArrayList(list3);
        itemsListView.getItems().setAll(equipmentTypeObservableList);
    }


    @FXML
    private void insertEquipmentType() {

        InsertEquipmentTypeController insertEquipmentTypeController = new InsertEquipmentTypeController();
        try {
            App.setRoot("/insertEquipmentTypeView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void updateEquipmentType() {
        try {
        updatedEquipmentType = (EquipmentType) itemsListView.getSelectionModel().getSelectedItem();
        InsertEquipmentTypeController insertEquipmentTypeController = new InsertEquipmentTypeController();
        if(updatedEquipmentType == null){
            throw new NullPointerException();
        }
            App.setRoot("/insertEquipmentTypeView.fxml");
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void deleteEquipmentType() {
        try{
        EquipmentType equipmentType = (EquipmentType) itemsListView.getSelectionModel().getSelectedItem();
        H2EquipmentTypeDAO h2EquipmentTypeDAO = new H2EquipmentTypeDAO();
        h2EquipmentTypeDAO.deleteEquipmentType(equipmentType.getId());
        List<EquipmentType> list = new ArrayList<>();
        list = h2EquipmentTypeDAO.findAll();
        ObservableList<EquipmentType> equipmentTypeObservableList = FXCollections.observableArrayList(list);
        itemsListView.getItems().setAll(equipmentTypeObservableList);
        if(equipmentType == null){
            throw new NullPointerException();
        }
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();
        }catch (SQLException e) {
            Alert confirmation = new Alert(Alert.AlertType.WARNING);
            confirmation.setHeaderText("Данный элемент присутствует в других таблицах");
            confirmation.showAndWait();

    } catch (Exception e) {
        e.printStackTrace();
        alertWindow = new Alert(Alert.AlertType.ERROR);
        alertWindow.setHeaderText("Неизвестная ошибка");
        alertWindow.showAndWait();
    }
    }

    @FXML
    private void insertEquipment() {
        InsertEquipmentController insertEquipmentController = new InsertEquipmentController();
        try {
            App.setRoot("/insertEquipmentView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void showEquipment() {

        updatedEquipmentType = (EquipmentType) itemsListView.getSelectionModel().getSelectedItem();
        List<Equipment> list4;
        H2EquipmentDAO h2EquipmentDAO = new H2EquipmentDAO();
        list4 = h2EquipmentDAO.findEquipmentByType(updatedEquipmentType.getId());
        List<Item> items = new ArrayList<>();
        for(int i = 0; i < list4.size(); i++){
            try {
                int itemId = list4.get(i).getItemId();
                H2ItemDAO h2ItemDAO = new H2ItemDAO();
                Item item = h2ItemDAO.findItemById(itemId);
                items.add(item);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList(items);
        additionalListView.getItems().setAll(itemObservableList);

    }

    @FXML
    private void deleteEquipment() {

        try {
            Item item = (Item)additionalListView.getSelectionModel().getSelectedItem();
            H2EquipmentDAO h2EquipmentDAO = new H2EquipmentDAO();
            H2ItemDAO h2ItemDAO = new H2ItemDAO();
            h2EquipmentDAO.deleteEquipment(item.getId(), updatedEquipmentType.getId());
            this.showEquipment();
            if(item == null){
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
        e.printStackTrace();
        alertWindow = new Alert(Alert.AlertType.WARNING);
        alertWindow.setHeaderText("Не выбран элемент'");
        alertWindow.showAndWait();


    } catch (Exception e) {
        e.printStackTrace();
        alertWindow = new Alert(Alert.AlertType.ERROR);
        alertWindow.setHeaderText("Неизвестная ошибка");
        alertWindow.showAndWait();
    }

    }



    @FXML
    private void insertProductMenuType() {

        InsertProductMenuTypeController insertProductMenuTypeController = new InsertProductMenuTypeController();
        try {
            App.setRoot("/insertProductMenuTypeView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void findAllProductMenuTypes()
    {
        H2ProductMenuTypeDAO h2ProductMenuTypeDAO = new H2ProductMenuTypeDAO();
        List<ProductMenuType> productMenuTypeList = new ArrayList<>();
        productMenuTypeList = h2ProductMenuTypeDAO.findAllProductMenuTypes();
        ObservableList<ProductMenuType> productMenuTypeObservableList = FXCollections.observableArrayList(productMenuTypeList);
        itemsListView.getItems().setAll(productMenuTypeObservableList);
    }

    @FXML
    private void updateProductMenuType() {
        try {
        updatedProductMenuType = (ProductMenuType) itemsListView.getSelectionModel().getSelectedItem();
        InsertProductMenuTypeController insertProductMenuTypeController = new InsertProductMenuTypeController();
        if(updatedEquipmentType == null){
            throw new NullPointerException();
        }
            App.setRoot("/insertProductMenuTypeView.fxml");
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void deleteProductMenuType() {
        try {
            ProductMenuType productMenuType = (ProductMenuType) itemsListView.getSelectionModel().getSelectedItem();
            H2ProductMenuTypeDAO h2ProductMenuTypeDAO = new H2ProductMenuTypeDAO();
            h2ProductMenuTypeDAO.deleteProductMenuType(productMenuType.getId());
            List<ProductMenuType> list;
            list = h2ProductMenuTypeDAO.findAllProductMenuTypes();
            ObservableList<ProductMenuType> productMenuTypeObservableList = FXCollections.observableArrayList(list);
            itemsListView.getItems().setAll(productMenuTypeObservableList);
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void insertProductMenu() {
        InsertProductMenuController insertProductMenuController = new InsertProductMenuController();
        try {
            App.setRoot("/insertProductMenuView.fxml");

        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void showProductMenu() {
        updatedProductMenuType = (ProductMenuType) itemsListView.getSelectionModel().getSelectedItem();
        List<ProductMenu> list4;
        H2ProductMenuDAO h2ProductMenuDAO = new H2ProductMenuDAO();
        list4 = h2ProductMenuDAO.findProductMenuByType(updatedProductMenuType.getId());
        ObservableList<ProductMenu> productMenuObservableList = FXCollections.observableArrayList(list4);
        additionalListView.getItems().setAll(productMenuObservableList);

    }

    @FXML
    private void deleteProductMenu() {
        try{
        ProductMenu productMenu = (ProductMenu) additionalListView.getSelectionModel().getSelectedItem();
        H2ProductMenuDAO h2ProductMenuDAO = new H2ProductMenuDAO();
        h2ProductMenuDAO.deleteProductMenu(productMenu.getProductId(), productMenu.getProductMenuTypeId());
        List<ProductMenu> productMenuList;
        productMenuList = h2ProductMenuDAO.findAllProductMenu();
        ObservableList<ProductMenu> productMenuObservableList = FXCollections.observableArrayList(productMenuList);
        additionalListView.getItems().setAll(productMenuObservableList);
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void insertClient() {
       InsertClientController insertClientController = new InsertClientController();
        try {
            App.setRoot("/insertClientView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void updateClient() {
        try {
        updatedClient = (Client) itemsListView.getSelectionModel().getSelectedItem();
        InsertClientController insertClientController = new InsertClientController();
            if(updatedClient == null){
                throw new NullPointerException();
            }
            App.setRoot("/insertClientView.fxml");

        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }

    }

    @FXML
    private void deleteClient() {
        try {
            Client client = (Client) itemsListView.getSelectionModel().getSelectedItem();
            H2ClientDAO h2ClientDAO = new H2ClientDAO();
            h2ClientDAO.deleteClient(client.getId());
            List<Client> list = new ArrayList<>();
            list = h2ClientDAO.findAllClients();
            ObservableList<Client> clientObservableList = FXCollections.observableArrayList(list);
            itemsListView.getItems().setAll(clientObservableList);

        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void findAllClients() {
        H2ClientDAO h2ClientDAO = new H2ClientDAO();
        List<Client> list = new ArrayList<>();
        list = h2ClientDAO.findAllClients();
        ObservableList<Client> clientObservableList = FXCollections.observableArrayList(list);
        itemsListView.getItems().setAll(clientObservableList);
    }

    @FXML
    private void insertRouteType() {
        InsertRouteTypeController insertRouteTypeController = new InsertRouteTypeController();
        try {
            App.setRoot("/insertRouteTypeView.fxml");

        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void updateRouteType() {
        try{
        updatedRouteType = (RouteType) itemsListView.getSelectionModel().getSelectedItem();
        InsertRouteTypeController insertRouteTypeController = new InsertRouteTypeController();
        if(updatedRouteType == null){
            throw new NullPointerException();
        }
            App.setRoot("/insertRouteTypeView.fxml");
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void deleteRouteType() {
        try{
        RouteType routeType = (RouteType) itemsListView.getSelectionModel().getSelectedItem();
        H2RouteTypeDAO h2RouteTypeDAO = new H2RouteTypeDAO();
        h2RouteTypeDAO.deleteRouteType(routeType.getRouteTypeId());
        List<RouteType> list = new ArrayList<>();
        list = h2RouteTypeDAO.findAllRouteTypes();
        ObservableList<RouteType> routeTypeObservableList = FXCollections.observableArrayList(list);
        itemsListView.getItems().setAll(routeTypeObservableList);
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void findAllRouteTypes() {
        H2RouteTypeDAO h2RouteTypeDAO = new H2RouteTypeDAO();
        List<RouteType> list = new ArrayList<>();
        list = h2RouteTypeDAO.findAllRouteTypes();
        ObservableList<RouteType> routeTypeObservableList = FXCollections.observableArrayList(list);
        itemsListView.getItems().setAll(routeTypeObservableList);
    }

    @FXML
    private void insertGroup() {
        InsertGroupController insertGroupController = new InsertGroupController();
        try {
            App.setRoot("/insertGroupView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private void showGroup() {
        updatedRouteType = (RouteType) itemsListView.getSelectionModel().getSelectedItem();
        List<Group> list4;
        H2GroupDAO h2GroupDAO = new H2GroupDAO();
        list4 = h2GroupDAO.findGroupByType(updatedRouteType.getRouteTypeId());
        ObservableList<Group> groupObservableList = FXCollections.observableArrayList(list4);
        additionalListView.getItems().setAll(groupObservableList);

    }

    @FXML
    private void deleteGroup() {
        try{
        Group group = (Group) additionalListView.getSelectionModel().getSelectedItem();
        H2GroupDAO h2GroupDAO = new H2GroupDAO();
        h2GroupDAO.deleteGroup(group.getClientId(), group.getRouteTypeId());
        List<Group> groupList;
        groupList = h2GroupDAO.findAllGroups();
        ObservableList<Group> groupObservableList = FXCollections.observableArrayList(groupList);
        additionalListView.getItems().setAll(groupObservableList);
        } catch (NullPointerException e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.WARNING);
            alertWindow.setHeaderText("Не выбран элемент'");
            alertWindow.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }


    @FXML
    private void findAllTourProjects(){

    }

    @FXML
    private void insertTourProject(){
        InsertTourProjectController insertTourProjectController = new InsertTourProjectController();
        try {
            App.setRoot("/insertTourProjectView.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            alertWindow = new Alert(Alert.AlertType.ERROR);
            alertWindow.setHeaderText("Неизвестная ошибка");
            alertWindow.showAndWait();
        }
    }

    @FXML
    private  void updateTourProject(){

    }

    @FXML
    private  void deleteTourProject(){

    }

    @FXML
    private void exportTourProject(){

    }

    @FXML
    private void loadTourProjects() throws  IOException, ClassNotFoundException{
        FileInputStream fiStream = new FileInputStream("tourPrijects.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object object = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        List<TourProject> tourProjectList = (List<TourProject>) object;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

}




