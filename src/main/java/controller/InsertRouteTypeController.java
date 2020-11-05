package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.H2RouteTypeDAO;
import model.RouteType;
import view.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static controller.Controller.updatedRouteType;


public class InsertRouteTypeController implements Initializable {
    static RouteType routeType;

    @FXML
    TextField insertNameText;
    @FXML
    TextField insertStartXText;
    @FXML
    TextField insertStartYText;
    @FXML
    TextField insertFinishXText;
    @FXML
    TextField insertFinishYText;
    @FXML
    TextField insertDistanceText;
    @FXML
    TextField insertDescriptionText;
    @FXML
    TextField insertDurationText;
    @FXML
    TextField insertGoogleMapsURLText;
    @FXML
    Button executeButton;
    @FXML
    Button executeUpdateButton;
    @FXML
    Button smartRouteTypeInsertButton;
    @FXML
    Label insertNameLabel;
    @FXML
    Label insertStartXLabel;
    @FXML
    Label insertStartYLabel;
    @FXML
    Label insertFinishXLabel;
    @FXML
    Label insertFinishYLabel;
    @FXML
    Label insertDistanceLabel;
    @FXML
    Label insertDescriptionLabel;
    @FXML
    Label insertDurationLabel;
    @FXML
    Button cancelButton;







    @FXML
    private void insertName() {
        insertNameLabel.setText("ОК");
        try {
            String name = String.valueOf(insertNameText.getText());
            routeType.setRouteTypeName(name);
            updatedRouteType.setRouteTypeName(name);
        }catch(Exception e){
            insertNameLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertStartX(){
        insertStartXLabel.setText("ОК");
        try {
            double startX = Double.parseDouble(insertStartXText.getText());
            routeType.setRouteTypeStartX(startX);
            updatedRouteType.setRouteTypeStartX(startX);
        }catch (Exception e){
            insertStartXLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertStartY() {
        insertStartYLabel.setText("ОК");
        try {
            double startY = Double.parseDouble(insertStartYText.getText());
            routeType.setRouteTypeStartY(startY);
            updatedRouteType.setRouteTypeStartY(startY);
        } catch (Exception e){
            insertStartYLabel.setText("Некорректное значение");
        }
    }
    @FXML
    private void insertFinishX() {
        insertFinishXLabel.setText("ОК");
        try {
            double finishX = Double.parseDouble(insertFinishXText.getText());
            routeType.setRouteTypeFinishX(finishX);
            updatedRouteType.setRouteTypeFinishX(finishX);
        } catch (Exception e){
            insertFinishXLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertFinishY() {
        insertFinishYLabel.setText("ОК");
        try {
            double finishY = Double.parseDouble(insertFinishYText.getText());
            routeType.setRouteTypeFinishY(finishY);
            updatedRouteType.setRouteTypeFinishY(finishY);
        } catch (Exception e){
            insertFinishYLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertDistance() {
        insertDistanceLabel.setText("ОК");
        try {
            float distance = Float.parseFloat(insertDistanceText.getText());
            routeType.setRouteTypeDistance(distance);
            updatedRouteType.setRouteTypeDistance(distance);
        } catch (Exception e){
            insertDistanceLabel.setText("Некорректное значение");
        }
    }


    @FXML
    private void insertDescription(){
        insertDescriptionLabel.setText("ОК");
        try {
            String description = insertDescriptionText.getText();
            routeType.setRouteTypeDescription(description);
            updatedRouteType.setRouteTypeDescription(description);
        } catch(Exception e){
            insertDescriptionLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private void insertDuration() {
        insertDurationLabel.setText("ОК");
        try {
            float duration = Float.parseFloat(insertDurationText.getText());
            routeType.setRouteTypeDuration(duration);
            updatedRouteType.setRouteTypeDuration(duration);
        } catch (Exception e){
            insertDurationLabel.setText("Некорректное значение");
        }
    }


    @FXML
    private void execute() {

        H2RouteTypeDAO h2RouteTypeDAO = new H2RouteTypeDAO();
        h2RouteTypeDAO.insertRouteType(routeType);

        try {
            App.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void executeUpdate() {

        H2RouteTypeDAO h2RouteTypeDAO = new H2RouteTypeDAO();
        h2RouteTypeDAO.updateRouteType(updatedRouteType);

        try {
            App.setRoot("/trakkingAppView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void smartRouteTypeInsert(){
        try {
            App.setRoot("/insertGeoDataView.fxml");
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

    }
}
