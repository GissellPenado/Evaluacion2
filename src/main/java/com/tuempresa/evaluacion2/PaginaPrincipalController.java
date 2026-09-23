package com.tuempresa.evaluacion2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class PaginaPrincipalController {

    @FXML
    private void registrar(ActionEvent event) {
        mostrarMensaje("Registrar", "Has seleccionado Registrar.");
    }

    @FXML
    private void consultar(ActionEvent event) {
        mostrarMensaje("Consultar", "Has seleccionado Consultar.");
    }

    @FXML
    private void actualizar(ActionEvent event) {
        mostrarMensaje("Actualizar", "Has seleccionado Actualizar.");
    }

    @FXML
    private void salir(ActionEvent event) {
        mostrarMensaje("Salir", "Has seleccionado Salir.");
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
