module com.example.demolistviewfile {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demolistviewfile to javafx.fxml;
    opens com.example.demolistviewfile.Services to javafx.fxml;
    opens com.example.demolistviewfile.Repositories to javafx.fxml;
    opens com.example.demolistviewfile.Controllers to javafx.fxml;
    exports com.example.demolistviewfile;
    exports com.example.demolistviewfile.Services;
    exports com.example.demolistviewfile.Controllers;
    exports com.example.demolistviewfile.Repositories;

}