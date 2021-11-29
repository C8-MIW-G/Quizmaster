module QuizMaster {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;
    requires lightcouch;
    requires com.google.gson;

    opens view to javafx.graphics, javafx.fxml;
    opens controller to javafx.fxml;
    opens model to gson;
}