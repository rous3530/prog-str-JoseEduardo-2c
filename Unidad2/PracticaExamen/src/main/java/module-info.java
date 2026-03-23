module com.example.practicaexamen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicaexamen to javafx.fxml;
    exports com.example.practicaexamen;
}