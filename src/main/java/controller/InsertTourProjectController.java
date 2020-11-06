package controller;


import appApachePoi.SetColumnValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import model.*;
import view.JavaFXStarter;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import static controller.Controller.updatedTourProject;

@SuppressWarnings("ALL")
public class InsertTourProjectController implements Initializable {
    TourProject tourProject = new TourProject();
    H2ProductDAO h2ProductDAO = new H2ProductDAO();
    H2ItemDAO h2ItemDAO = new H2ItemDAO();
    H2EquipmentDAO h2EquipmentDAO = new H2EquipmentDAO();
    H2GroupDAO h2GroupDAO = new H2GroupDAO();
    H2ClientDAO h2ClientDAO = new H2ClientDAO();
    List<Item> itemList;
    EquipmentType equipmentType;
    List<Product> productList;
    ProductMenuType productMenuType;
    List<Client> clientList;
    RouteType routeType;


    @FXML
    ComboBox routeTypeComboBox;
    @FXML
    ComboBox productMenuTypeComboBox;
    @FXML
    ComboBox equipmentTypeComboBox;
    @FXML
    Button executeButton;
    @FXML
    Button executeUpdateButton;
    @FXML
    TextField insertTourProjectNameText;
    @FXML
    Label insertTourProjectNameLabel;
    @FXML
    TextArea resultTextArea;
    @FXML
    Button cancelButton;
    @FXML
    Button exportToMCHSButton;

    @FXML
    private void insertName() {
        insertTourProjectNameLabel.setText("ОК");
        try {
            String name = String.valueOf(insertTourProjectNameText.getText());
            tourProject.setName(name);
            updatedTourProject.setName(name);
            resultTextArea.appendText(name);

        }catch(Exception e){
            insertTourProjectNameLabel.setText("Некорректное значение");

        }
    }


    @FXML
    void selectEquipmentType(){
        equipmentType = (EquipmentType) equipmentTypeComboBox.getSelectionModel().getSelectedItem();
        resultTextArea.appendText(equipmentType.toString());
    }

    private void selectItems() {
        List<Equipment> equipmentList;

        equipmentList = h2EquipmentDAO.findEquipmentByType(equipmentType.getId());
        for(int i = 0; i < equipmentList.size(); i++){
            int itemId = equipmentList.get(i).getItemId();
            Item item = h2ItemDAO.findItemById(itemId);
            itemList.add(item);
            resultTextArea.appendText(item.toString());
        }
    }

    @FXML
    void selectProductMenuType(){
        productMenuType = (ProductMenuType) productMenuTypeComboBox.getSelectionModel().getSelectedItem();
        resultTextArea.appendText(productMenuType.toString());
    }

    private void selectProducts() {
        List<ProductMenu> productMenuList;
        H2ProductMenuDAO h2ProductMenuDAO = new H2ProductMenuDAO();
        productMenuList = h2ProductMenuDAO.findProductMenuByType(productMenuType.getId());
        for(int i = 0; i < productMenuList.size(); i++){
            int productId = productMenuList.get(i).getProductId();
            Product product = h2ProductDAO.selectProductById(productId);
            productList.add(product);
            resultTextArea.appendText(product.toString());
        }
    }


    @FXML
    void selectRouteType(){
        routeType = (RouteType) routeTypeComboBox.getSelectionModel().getSelectedItem();
        resultTextArea.appendText(routeType.toString());
    }

    private List<Client> selectClients() {
        List<Group> groupList;
        groupList = h2GroupDAO.findGroupByType(routeType.getRouteTypeId());
        for(int i = 0; i < groupList.size(); i++){
            int clientId = groupList.get(i).getClientId();
            Client client = h2ClientDAO.selectClientById(clientId);
            clientList.add(client);
            resultTextArea.appendText(client.toString());
        }
        return clientList;
    }

    @FXML
    void saveTourProject(TourProject tourProject) throws  IOException{
        FileOutputStream fileOutput = new FileOutputStream("tourProjects.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(tourProject);
        fileOutput.close();
        outputStream.close();
    }





    @FXML
    void execute() {
        TourProject tourProject = new TourProject();
        tourProject.setEquipmentType(equipmentType);
        tourProject.setItemList(itemList);
        tourProject.setProductMenuType(productMenuType);
        tourProject.setProductList(productList);
        tourProject.setRouteType(routeType);
        tourProject.setClientList(clientList);

    }


    @FXML
    private void hndlOpenFile(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Save Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(null);//Указываем текущую сцену CodeNote.mainStage
        if (file != null) {
            //Save
            System.out.println("Процесс открытия файла");
            StringBuilder stringBuilder = new StringBuilder();
            String string = resultTextArea.getText();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(fileOutputStream, "windows-1251"));
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    @FXML
    private void cancel() {
        Controller controller = new Controller();
        try {
            JavaFXStarter.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* @FXML
    private void exportToMCHSDoc(){
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Open Source");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("docx files (*.docx)", "*.docx");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File source = fileChooser.showOpenDialog(null);


        *//*FileChooser fileChooser2 = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser2.setTitle("Open output");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter2 =
                new FileChooser.ExtensionFilter("docx files (*.docx)", "*.docx");//Расширение
        fileChooser2.getExtensionFilters().add(extFilter2);
        File output = fileChooser2.showOpenDialog(null);
        Client teamleader = new Client();
        teamleader.setSurname("Иванов");
        teamleader.setName("Григорий");
        teamleader.setPatronimic("Викторович");
        teamleader.setAge(45);
        teamleader.setPhone("9-869-643-86-75");
        String companyName = "турклуб Пик";
        String companyAddress = "ул. Шереметьевская д. 15, г. Москва";
        String companyPhoneNumber = "8-915-869-85-39";
        String date = String.valueOf(LocalDate.now());*//*

        SetColumnValue setColumnValue = new SetColumnValue();
        try {
            setColumnValue.setMCHSColumnValue(source,output,date, teamleader,companyName, companyAddress, companyPhoneNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        H2RouteTypeDAO h2RouteTypeDAO = new H2RouteTypeDAO();
        List<RouteType> routeTypeList = new ArrayList<>();
        routeTypeList= h2RouteTypeDAO.findAllRouteTypes();
        ObservableList<RouteType> routeTypeObservableList = FXCollections.observableArrayList(routeTypeList);
        routeTypeComboBox.getItems().removeAll(routeTypeComboBox.getItems());
        routeTypeComboBox.getItems().addAll(routeTypeObservableList);

        H2ProductMenuTypeDAO h2ProductMenuTypeDAO = new H2ProductMenuTypeDAO();
        List<ProductMenuType> productMenuTypeList = new ArrayList<>();
        productMenuTypeList= h2ProductMenuTypeDAO.findAllProductMenuTypes();
        ObservableList<ProductMenuType> productMenuTypeObservableList = FXCollections.observableArrayList(productMenuTypeList);
        productMenuTypeComboBox.getItems().removeAll(productMenuTypeComboBox.getItems());
        productMenuTypeComboBox.getItems().addAll(productMenuTypeObservableList);

        H2EquipmentTypeDAO h2EquipmentTypeDAO = new H2EquipmentTypeDAO();
        List<EquipmentType> equipmentTypeList = new ArrayList<>();
        equipmentTypeList= h2EquipmentTypeDAO.findAll();
        ObservableList<EquipmentType> equipmentTypeObservableList = FXCollections.observableArrayList(equipmentTypeList);
        equipmentTypeComboBox.getItems().removeAll(equipmentTypeComboBox.getItems());
        equipmentTypeComboBox.getItems().addAll(equipmentTypeObservableList);


    }
}
