package controller;

import geoData.GSONWeather;
import geoData.GeoPoint;
import geoData.GoogleMapsCoordinatesParser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.RouteType;
import view.JavaFXStarter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static controller.InsertRouteTypeController.routeType;



public class GeoDataController implements Initializable  {

    static String googleMapsURL;
    static int daysOff;
    static List<GeoPoint> geoPointList;
    static GeoPoint startGeoPoint;
    static GeoPoint finishGeoPoint;
    static double distance;
    static float duration;
    static int normalGroupSpeed = 4;
    static int slowGroupSpeed = 2;
    static int sportGroupSpeed = 6;
    static  int hikingHours;
    @FXML
    TextField insertGoogleMapsURLText;
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
    TextField insertDurationText;
    @FXML
    TextField insertDaysOffText;
    @FXML
    TextField insertHikingHoursText;
    @FXML
    Button insertGeoPointsButton;
    @FXML
    Button insertWeatherForecastButton;
    @FXML
    Button insertDistanceButton;
    @FXML
    Button insertDurationButton;
    @FXML
    Label insertDaysOffLabel;
    @FXML
    Label insertHikingHoursLabel;
    @FXML
    TextArea insertWeatherForecastText;
    @FXML
    Button executeGeoDataButton;
    @FXML
    CheckBox isBigGroupCheckBox;
    @FXML
    CheckBox areChildrenOrElderlyCheckBox;
    @FXML
    CheckBox isSportGroupCheckBox;
    @FXML
    Button cancelButton;

    @FXML
    private  void  smartGeoDataInsert(){
    }

    @FXML
    private  void  insertDaysOff(){
        insertDaysOffLabel.setText("ОК");
        try {
            daysOff = Integer.parseInt(insertDaysOffText.getText());
        } catch (Exception e){
            insertDaysOffLabel.setText("Некорректное значение");
        }
    }

    @FXML
    private  void  insertHikingHours(){
        insertHikingHoursLabel.setText("ОК");
        try {
            hikingHours = Integer.parseInt(insertHikingHoursText.getText());
        } catch (Exception e){
            insertHikingHoursLabel.setText("Некорректное значение");
        }
    }

    @FXML
    public void insertWeatherForecast() throws IOException {
        GSONWeather gsonWeather = new GSONWeather();
        gsonWeather = gsonWeather.getForecastByCoordinates(startGeoPoint);
        insertWeatherForecastText.setText(
                "Температура - " + gsonWeather.getMain().getTemp()
                        +  "; Ощущается как " + gsonWeather.getMain().getFeelsLike()
                        + "; Влажность - " + gsonWeather.getMain().getHumidity()
                        + "; Осадки: " + gsonWeather.getWeather()
                        + "; Скорость ветра: " + gsonWeather.getWind().getSpeed()
        );
    }

    @FXML
    private void insertDistance(){
        GoogleMapsCoordinatesParser googleMapsCoordinatesParser = new GoogleMapsCoordinatesParser();
        googleMapsURL = String.valueOf(insertGoogleMapsURLText.getText());
        geoPointList = new ArrayList<>();
        geoPointList = googleMapsCoordinatesParser.parseURL(googleMapsURL);
        distance = googleMapsCoordinatesParser.wholeDistance(geoPointList);
        insertDistanceText.setText(String.valueOf(distance));
    }

    @FXML
    private  void insertGeoPoints(){
        GoogleMapsCoordinatesParser googleMapsCoordinatesParser = new GoogleMapsCoordinatesParser();
        googleMapsURL = String.valueOf(insertGoogleMapsURLText.getText());
        geoPointList = new ArrayList<>();
        geoPointList = googleMapsCoordinatesParser.parseURL(googleMapsURL);
        startGeoPoint = geoPointList.get(0);
        finishGeoPoint = geoPointList.get(geoPointList.size()-1);
        insertStartXText.setText(String.valueOf(startGeoPoint.getLatitude()));
        insertStartYText.setText(String.valueOf(startGeoPoint.getLongitude()));
        insertFinishXText.setText(String.valueOf(finishGeoPoint.getLatitude()));
        insertFinishYText.setText(String.valueOf(finishGeoPoint.getLongitude()));
    }

    @FXML
    private void insertDuration(){
        int groupSpeed;

        if(isBigGroupCheckBox.isSelected()|| areChildrenOrElderlyCheckBox.isSelected()){
            groupSpeed = slowGroupSpeed;
        } else if(isSportGroupCheckBox.isSelected()){
            groupSpeed = sportGroupSpeed;
        } else groupSpeed = normalGroupSpeed;

        int distancePerDay = groupSpeed*hikingHours;
        duration = (float) (distance/distancePerDay);
        duration += daysOff;
        insertDurationText.setText(String.valueOf(duration));

    }

    @FXML
    private void execute(){

        routeType = new RouteType();
        routeType.setRouteTypeStartX(Double.parseDouble(insertStartXText.getText()));
        routeType.setRouteTypeStartY(Double.parseDouble(insertStartYText.getText()));
        routeType.setRouteTypeFinishX(Double.parseDouble(insertFinishXText.getText()));
        routeType.setRouteTypeFinishY(Double.parseDouble(insertFinishYText.getText()));
        routeType.setRouteTypeDistance(Float.parseFloat(insertDistanceText.getText()));
        routeType.setRouteTypeDuration(Float.parseFloat(insertDurationText.getText()));
        try {
            JavaFXStarter.setRoot("/insertRouteTypeView.fxml");
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
