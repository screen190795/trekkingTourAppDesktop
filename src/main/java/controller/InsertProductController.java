package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.H2ProductDAO;
import model.Product;
import view.JavaFXStarter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static controller.Controller.updatedProduct;

public class InsertProductController implements Initializable {



    @FXML
    TextField insertNameText;
    @FXML
    TextField insertWeightText;
    @FXML
    TextField insertCaloriesText;
    @FXML
    TextField insertProteinsText;
    @FXML
    TextField insertFatsText;
    @FXML
    TextField insertCarbohydratesText;
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
    Label insertCaloriesLabel;
    @FXML
    Label insertProteinsLabel;
    @FXML
    Label insertFatsLabel;
    @FXML
    Label insertCarbohydratesLabel;
    @FXML
    Label insertDescriptionLabel;
    @FXML
    Button cancelButton;


    Product product = new Product();


    @FXML
    private void insertName() {
        insertNameLabel.setText("ОК");
        try {
            String name = String.valueOf(insertNameText.getText());
            product.setName(name);
            updatedProduct.setName(name);
        }catch(Exception e){
            insertNameLabel.setText("Некорректное значение");

        }
    }
    @FXML
    private void insertWeight(){
        insertWeightLabel.setText("ОК");
        try {
            float weight = Float.parseFloat(insertWeightText.getText());
            product.setWeight(weight);
            updatedProduct.setWeight(weight);
        }catch (Exception e){
            insertWeightLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertCalories() {
        insertCaloriesLabel.setText("ОК");
        try {
            float calories = Float.parseFloat(insertCaloriesText.getText());
            product.setCalories(calories);
            updatedProduct.setCalories(calories);
        } catch (Exception e){
            insertCaloriesLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertProteins() {
        insertProteinsLabel.setText("ОК");
        try {
            float proteins = Float.parseFloat(insertProteinsText.getText());
            product.setProteins(proteins);
            updatedProduct.setProteins(proteins);
        } catch (Exception e){
            insertProteinsLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertFats() {
        insertFatsLabel.setText("ОК");
        try {
            float fats = Float.parseFloat(insertFatsText.getText());
            product.setFats(fats);
            updatedProduct.setFats(fats);
        } catch (Exception e){
            insertFatsLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertCarbohydrates() {
        insertCarbohydratesLabel.setText("ОК");
        try {
            float carbohydrates = Float.parseFloat(insertCarbohydratesText.getText());
            product.setCarbohydrates(carbohydrates);
            updatedProduct.setCarbohydrates(carbohydrates);
        } catch (Exception e){
            insertCarbohydratesLabel.setText("Некорректное значение");
        }
    }


    @FXML
    private void insertDescription(){
        insertDescriptionLabel.setText("ОК");
        try {
            String description = insertDescriptionText.getText();
            product.setDescription(description);
            updatedProduct.setDescription(description);
        } catch(Exception e){
            insertDescriptionLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void execute() {
        Alert alertWindow;
        try {
            if(product.getName().isEmpty() || product.getWeight() == 0){
                throw new NullPointerException();
            }
        H2ProductDAO h2ProductDAO = new H2ProductDAO();
        h2ProductDAO.insertProduct(product);
            JavaFXStarter.setRoot("/trakkingAppView.fxml");
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

        H2ProductDAO h2ProductDAO = new H2ProductDAO();
        h2ProductDAO.updateProduct(updatedProduct);

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
