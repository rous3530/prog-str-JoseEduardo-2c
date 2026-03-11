package com.example.demolistviewfile.Controllers;

import com.example.demolistviewfile.Services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAge; // Nuevo campo para la edad

    private ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service = new PersonService();

    @FXML
    public void initialize() {
        listView.setItems(data);
        loadFromFile();
    }

    @FXML
    public void onReload() {
        loadFromFile();
    }

    @FXML
    public void onAddPerson() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            int age = Integer.parseInt(txtAge.getText());

            if (age < 18) {
                throw new IllegalArgumentException("No se puede: Debe ser mayor de edad.");
            }

            service.addPerson(name, email, age);

            lblMsg.setText("Usuario creado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");

            // Limpiar campos tras éxito
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            loadFromFile();

        } catch (NumberFormatException e) {
            lblMsg.setText("Error: Ingrese un número válido en edad");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException e) {
            lblMsg.setText("Error de archivo: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile() {
        try {
            List<String> items = service.loadForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error al cargar: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}