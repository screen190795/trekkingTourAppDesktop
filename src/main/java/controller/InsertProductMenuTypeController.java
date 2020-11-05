package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.H2ProductDAO;
import model.H2ProductMenuTypeDAO;
import model.Product;
import model.ProductMenuType;
import view.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static controller.Controller.updatedProduct;
import static controller.Controller.updatedProductMenuType;

public class InsertProductMenuTypeController implements Initializable {
    FXMLLoader loader =new FXMLLoader();
    Controller controller= loader.getController();


    @FXML
    TextField insertProductMenuTypeNameText;
    @FXML
    TextField insertProductMenuTypeWeightText;
    @FXML
    TextField insertProductMenuTypeCaloriesText;
    @FXML
    TextField insertProductMenuTypeProteinsText;
    @FXML
    TextField insertProductMenuTypeFatsText;
    @FXML
    TextField insertProductMenuTypeCarbohydratesText;
    @FXML
    TextField insertProductMenuTypeDescriptionText;
    @FXML
    Button executeButton;
    @FXML
    Button executeUpdateButton;
    @FXML
    Label insertProductMenuTypeNameLabel;
    @FXML
    Label insertProductMenuTypeWeightLabel;
    @FXML
    Label insertProductMenuTypeCaloriesLabel;
    @FXML
    Label insertProductMenuTypeProteinsLabel;
    @FXML
    Label insertProductMenuTypeFatsLabel;
    @FXML
    Label insertProductMenuTypeCarbohydratesLabel;
    @FXML
    Label insertProductMenuTypeDescriptionLabel;
    @FXML
    Button cancelButton;


    ProductMenuType productMenuType = new ProductMenuType();



    @FXML
    private void insertName() {
        insertProductMenuTypeNameLabel.setText("ОК");
        try {
            String name = String.valueOf(insertProductMenuTypeNameText.getText());
            productMenuType.setName(name);

            updatedProductMenuType.setName(name);
        }catch(Exception e){
            insertProductMenuTypeNameLabel.setText("Некорректное значение");

        }
    }
    @FXML
    private void insertWeight(){
        insertProductMenuTypeWeightLabel.setText("ОК");
        try {
            int weight = Integer.parseInt(insertProductMenuTypeWeightText.getText());
            productMenuType.setWeight(weight);
            updatedProductMenuType.setWeight(weight);
        }catch (Exception e){
            insertProductMenuTypeWeightLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertCalories() {
        insertProductMenuTypeCaloriesLabel.setText("ОК");
        try {
            int calories = Integer.parseInt(insertProductMenuTypeCaloriesText.getText());
            productMenuType.setCalories(calories);
            updatedProductMenuType.setCalories(calories);
        } catch (Exception e){
            insertProductMenuTypeCaloriesLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertProteins() {
        insertProductMenuTypeProteinsLabel.setText("ОК");
        try {
            float proteins = Float.parseFloat(insertProductMenuTypeProteinsText.getText());
            productMenuType.setProteins(proteins);
            updatedProductMenuType.setProteins(proteins);
        } catch (Exception e){
            insertProductMenuTypeProteinsLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertFats() {
        insertProductMenuTypeFatsLabel.setText("ОК");
        try {
            float fats = Float.parseFloat(insertProductMenuTypeFatsText.getText());
            productMenuType.setFats(fats);
            updatedProductMenuType.setFats(fats);

        } catch (Exception e){
            insertProductMenuTypeFatsLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertCarbohydrates() {
        insertProductMenuTypeCarbohydratesLabel.setText("ОК");
        try {
            float carbohydrates = Float.parseFloat(insertProductMenuTypeCarbohydratesText.getText());
            productMenuType.setCarbohydrates(carbohydrates);
           updatedProductMenuType.setCarbohydrates(carbohydrates);
        } catch (Exception e){
            insertProductMenuTypeCarbohydratesLabel.setText("Некорректное значение");
        }
    }


    @FXML
    private void insertDescription(){
        insertProductMenuTypeDescriptionLabel.setText("ОК");
        try {
            String description = insertProductMenuTypeDescriptionText.getText();
            productMenuType.setDescription(description);
            updatedProductMenuType.setDescription(description);
        } catch(Exception e){
            insertProductMenuTypeDescriptionLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void execute() {

        H2ProductMenuTypeDAO h2ProductMenuTypeDAO = new H2ProductMenuTypeDAO();
        h2ProductMenuTypeDAO.insertProductMenuType(productMenuType);
        Controller controller = new Controller();
        try {
            App.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void executeUpdate() {

        H2ProductMenuTypeDAO h2ProductMenuTypeDAO = new H2ProductMenuTypeDAO();
        h2ProductMenuTypeDAO.updateProductMenuType(updatedProductMenuType);

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
