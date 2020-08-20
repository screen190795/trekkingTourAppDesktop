module main {


    requires kotlin.stdlib;

    exports view to javafx.graphics, javafx.fxml;
    opens view to javafx.fxml;
    exports controller to javafx.fxml;
    opens controller to javafx.fxml;
    requires model;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires com.h2database;
    requires appApachePoi;
}