module com.example.javafxmobileapp {

    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires okhttp3;
    requires java.sql;




//    opens com.example.javafxmobileapp to javafx.fxml, javafx.graphics;
    opens com.example.javafxmobileapp.controllers to javafx.fxml,javafx.graphics;
    opens com.example.javafxmobileapp;

    exports com.example.javafxmobileapp;
    exports com.example.javafxmobileapp.services;
    opens com.example.javafxmobileapp.services;

}