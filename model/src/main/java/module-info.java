module model {
    requires java.sql;
    exports model;
    requires kotlin.stdlib;
    requires com.google.gson;
    requires commons.lang;
    requires com.h2database;


    exports geoData to com.google.gson, main;
    opens  geoData to com.google.gson;



}
