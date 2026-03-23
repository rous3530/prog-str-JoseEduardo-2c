package com.example.practicaexamen;

import com.example.practicaexamen.Model.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML private TextField txtNombre, txtTelefono;
    @FXML private ComboBox<String> cbParentesco;
    @FXML private ListView<Contacto> listView;
    @FXML private Label lblMsg;

    // Regla #2: Lista para guardar contactos
    private List<Contacto> listaContactos = new ArrayList<>();
    private ObservableList<Contacto> obsContactos;

    // Regla #3 y Uso obligatorio del arreglo:
    private final String[] opcionesParentesco = {
            "Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {
        // Cargar el ComboBox desde el arreglo
        cbParentesco.setItems(FXCollections.observableArrayList(opcionesParentesco));

        // Configurar el ListView
        obsContactos = FXCollections.observableArrayList(listaContactos);
        listView.setItems(obsContactos);
    }

    @FXML
    protected void onAgregarClick() {
        String nombre = txtNombre.getText().trim();
        String tel = txtTelefono.getText().trim();
        String parentesco = cbParentesco.getValue();

        if (validar(nombre, tel, parentesco)) {
            if (buscarPorNombre(nombre) != null) {
                lblMsg.setText("Error: El nombre ya existe.");
                return;
            }
            listaContactos.add(new Contacto(nombre, tel, parentesco));
            actualizarInterfaz("Contacto agregado.");
            onLimpiarClick();
        }
    }

    @FXML
    protected void onBuscarClick() {
        Contacto encontrado = buscarPorNombre(txtNombre.getText().trim());
        if (encontrado != null) {
            txtTelefono.setText(encontrado.getTelefono());
            cbParentesco.setValue(encontrado.getParentesco());
            lblMsg.setText("Contacto encontrado.");
        } else {
            lblMsg.setText("No se encontró el contacto.");
        }
    }

    @FXML
    protected void onActualizarClick() {
        Contacto c = buscarPorNombre(txtNombre.getText().trim());
        if (c != null && validar(c.getNombre(), txtTelefono.getText(), cbParentesco.getValue())) {
            c.setTelefono(txtTelefono.getText());
            c.setParentesco(cbParentesco.getValue());
            actualizarInterfaz("Contacto actualizado.");
        }
    }

    @FXML
    protected void onEliminarClick() {
        Contacto c = buscarPorNombre(txtNombre.getText().trim());
        if (c != null) {
            listaContactos.remove(c);
            actualizarInterfaz("Contacto eliminado.");
            onLimpiarClick();
        }
    }

    @FXML
    protected void onLimpiarClick() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.getSelectionModel().clearSelection();
        lblMsg.setText("");
    }

    // --- Métodos de apoyo ---

    private boolean validar(String n, String t, String p) {
        if (n.isEmpty() || t.isEmpty() || p == null) {
            lblMsg.setText("Error: Llena todos los campos.");
            return false;
        }
        if (t.length() != 10 || !t.matches("\\d+")) {
            lblMsg.setText("Error: El teléfono debe tener 10 dígitos.");
            return false;
        }
        return true;
    }

    private Contacto buscarPorNombre(String nombre) {
        return listaContactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
    }

    private void actualizarInterfaz(String mensaje) {
        obsContactos.setAll(listaContactos);
        lblMsg.setText(mensaje);
    }
}