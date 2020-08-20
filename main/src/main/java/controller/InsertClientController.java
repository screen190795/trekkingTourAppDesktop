package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Client;
import model.H2ClientDAO;
import model.H2ProductDAO;
import model.Client;
import org.h2.jdbc.JdbcSQLException;
import view.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static controller.Controller.updatedClient;

public class InsertClientController implements Initializable {
    FXMLLoader loader =new FXMLLoader();
    Controller controller= loader.getController();

    @FXML
    TextField insertSurnameText;

    @FXML
    TextField insertNameText;
    @FXML
    TextField insertPatronimicText;
    @FXML
    TextField insertAgeText;
    @FXML
    TextField insertPassportSerialText;
    @FXML
    TextField insertPassportNumberText;
    @FXML
    TextField insertPhoneText;
    @FXML
    TextField insertEmailText;
    @FXML
    TextField insertDescriptionText;
    @FXML
    Button executeButton;
    @FXML
    Button executeUpdateButton;
    @FXML
    Label insertSurnameLabel;
    @FXML
    Label insertNameLabel;
    @FXML
    Label insertPatronimicLabel;
    @FXML
    Label insertAgeLabel;
    @FXML
    Label insertPassportSerialLabel;
    @FXML
    Label insertPassportNumberLabel;
    @FXML
    Label insertPhoneLabel;
    @FXML
    Label insertEmailLabel;
    @FXML
    Label insertDescriptionLabel;
    @FXML
            Button cancelButton;

    Client client = new Client();
    private Alert alertWindow;


    @FXML
    private void insertSurname() {
        insertSurnameLabel.setText("ОК");
        try {
            String surname = String.valueOf(insertSurnameText.getText());
            client.setSurname(surname);

            updatedClient.setSurname(surname);
        }catch(Exception e){
            insertSurnameLabel.setText("Некорректное значение");

        }
    }
    @FXML
    private void insertName(){
        insertNameLabel.setText("ОК");
        try {
            String name = String.valueOf(insertSurnameText.getText());
            client.setName(name);
            updatedClient.setName(name);
        }catch (Exception e){
            insertNameLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertPatronimic() {
        insertPatronimicLabel.setText("ОК");
        try {
            String patronimic = String.valueOf(insertPatronimicText.getText());
            client.setPatronimic(patronimic);
            updatedClient.setPatronimic(patronimic);
        } catch (Exception e){
            insertPatronimicLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertAge() {
        insertAgeLabel.setText("ОК");
        try {
            int age = Integer.parseInt(insertAgeText.getText());
            client.setAge(age);
            updatedClient.setAge(age);
        } catch (Exception e){
           insertAgeLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertPassportSerial() {
        insertPassportSerialLabel.setText("ОК");
        try {
            int passportSerial = Integer.parseInt(insertPassportSerialText.getText());
            client.setPassportSerial(passportSerial);
            updatedClient.setPassportSerial(passportSerial);
        } catch (Exception e){
            insertPassportSerialLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertPassportNumber() {
        insertPassportNumberLabel.setText("ОК");
        try {
            double passportNumber = Double.parseDouble(insertPassportNumberText.getText());
            client.setPassportNumber(passportNumber);
            updatedClient.setPassportNumber(passportNumber);
        } catch (Exception e) {
            insertPassportNumberLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertPhone() {
        insertPhoneLabel.setText("ОК");
        try {
            String phone = String.valueOf(insertPhoneText.getText());
            client.setPhone(phone);
            updatedClient.setPhone(phone);
        } catch (Exception e) {
            insertSurnameLabel.setText("Некорректное значение");
        }
    }


    @FXML
    private void insertEmail() {
        insertEmailLabel.setText("ОК");
        try {
            String email = String.valueOf(insertEmailText.getText());
            client.setEmail(email);
            updatedClient.setSurname(email);
        } catch (Exception e) {
            insertEmailLabel.setText("Некорректное значение");
        }
    }


    @FXML
    private void insertDescription() {
        insertDescriptionLabel.setText("ОК");
        try {
            String description = insertDescriptionText.getText();
            client.setDescription(description);
            updatedClient.setDescription(description);
        } catch (Exception e) {
            insertDescriptionLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void execute() {
try{
    if(client.getName() ==null|| client.getSurname()==null){
        Throwable throwable;
        throw new NullPointerException();
    }
        H2ClientDAO h2ClientDAO = new H2ClientDAO();
        h2ClientDAO.insertClient(client);

        Controller controller = new Controller();
        App.setRoot("/trakkingAppView.fxml");
    } catch (NullPointerException e) {
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
    private void executeUpdate() {

        H2ClientDAO h2ClientDAO = new H2ClientDAO();
        h2ClientDAO.updateClient(updatedClient);

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

    }
}
