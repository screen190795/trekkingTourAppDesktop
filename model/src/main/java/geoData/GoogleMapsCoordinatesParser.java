package geoData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleMapsCoordinatesParser implements CoordinatesParser {
    @Override
    public List<GeoPoint> parseURL(String url) {
        final String regex = "[0-9]+\\.[0-9]+";
        final String string = url;
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        List<GeoPoint> geoPointList = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
                doubles.add(Double.parseDouble(matcher.group(0)));
            }
        for (int i = 0; i < doubles.size() - 3; i+=2) {
            geoPointList.add(new GeoPoint(doubles.get(i), doubles.get(i + 1)));
        }
        for (GeoPoint geoPoint: geoPointList){
            System.out.println(geoPoint);
        }
        return geoPointList;
    }



    @Override
    public double distanceTo(GeoPoint gp1, GeoPoint gp2) {


        {
            double x1 = Math.toRadians(gp1.latitude);
            double y1 = Math.toRadians(gp1.longitude);
            double x2 = Math.toRadians(gp2.latitude);
            double y2 = Math.toRadians(gp2.longitude);

            /*************************************************************************
             * Compute using law of cosines
             *************************************************************************/
            // great circle distance in radians
            double angle1 = Math.acos(Math.sin(x1) * Math.sin(x2)
                    + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

            // convert back to degrees
            angle1 = Math.toDegrees(angle1);

            // each degree on a great circle of Earth is 60 nautical miles
            double distance1 = 60 * angle1*1.852;

            System.out.println(distance1 + "^^^^^^^^");
         return distance1;
        }


    }

    @Override
    public double wholeDistance(List geoPointList) {
        double wholeDistance = 0;
        for (int i = 0; i < geoPointList.size() - 1; i++) {
            GeoPoint geoPoint = (GeoPoint) geoPointList.get(i);
            GeoPoint geoPoint1 = (GeoPoint) geoPointList.get(i+1);
            wholeDistance += distanceTo(geoPoint,geoPoint1);
            System.out.println(wholeDistance);
        }
        return wholeDistance;
    }


    public static void main(String[] args) {
        GoogleMapsCoordinatesParser googleMapsCoordinatesParser = new GoogleMapsCoordinatesParser();
        String URL = "https://www.google.com/maps/dir/55.9814053,36.9101512/55.9967683,36.7041575/56.001376,36.5029704/56.1217495,36.2338053/56.2016625,36.1404216/@56.0968623,36.2351786,11z/data=!4m2!4m1!3e2";
        new ArrayList<>();
        List<GeoPoint> geoPoints = googleMapsCoordinatesParser.parseURL(URL);
        float distance = (float) googleMapsCoordinatesParser.wholeDistance(geoPoints);
        System.out.println(distance+"((((((((((((");

    }
}
