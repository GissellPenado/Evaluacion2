package com.tuempresa.evaluacion2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class LoginController {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSalir;

    @FXML
    private void initialize() {
        txtPassword.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER -> validarLogin();
                case ESCAPE -> cerrarApp();
            }
        });
    }

    @FXML
    private void onLogin(ActionEvent event) {
        validarLogin();
    }

    @FXML
    private void onSalir(ActionEvent event) {
        cerrarApp();
    }

    private void validarLogin() {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos vacíos");
            alerta.setHeaderText(null);
            alerta.setContentText("Debe ingresar usuario y contraseña.");
            alerta.showAndWait();
        } else {
            if (usuario.equals("admin") && password.equals("1234")) {
                abrirVentanaPrincipal();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error de acceso");
                alerta.setHeaderText(null);
                alerta.setContentText("Usuario o contraseña incorrectos.");
                alerta.showAndWait();
            }
        }
    }

    private void abrirVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tuempresa/fxml/principal.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Menú Principal");
            stage.setScene(scene);
            stage.show();


            Stage ventanaLogin = (Stage) btnLogin.getScene().getWindow();
            ventanaLogin.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cerrarApp() {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Salir");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Desea cerrar la aplicación?");
        if (confirmacion.showAndWait().get() == ButtonType.OK) {
            Stage ventana = (Stage) btnSalir.getScene().getWindow();
            ventana.close();
        }
    }
}

