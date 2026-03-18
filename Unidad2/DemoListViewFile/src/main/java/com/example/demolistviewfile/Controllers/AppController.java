package com.example.demolistviewfile.controllers;

import com.example.demolistviewfile.services.PersonService;
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
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;
    @FXML
    private ListView<String> listView;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service= new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue,newValue)-> {
                    if(newValue!=null){
                        String[] parts=newValue.split("-");
                        txtName.setText(parts[0]);
                        txtEmail.setText(parts[1]);
                        txtEdad.setText(parts[2]);
                    }

        });
        loadFromFile();
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void actualizar(){
        try{
            int index=listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();
            service.updatePerson(index, name, email, edad);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            lblMsg.setText("se actualizo el registro correctamente");
        }catch (IOException e){
            lblMsg.setText("hubo un error con el archivo");
        }catch (IllegalArgumentException e){
            lblMsg.setText("hubo un error con los datos" +e.getMessage());
        }
    }
    @FXML
    public void delete() {/// para borrar usuario
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();
            service.delatePerson(index);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            lblMsg.setText("se elimino el registro correctamente");
        } catch (IOException e) {
            lblMsg.setText("hubo un error con el archivo");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("hubo un error con los datos" + e.getMessage());
        }
    }
}
