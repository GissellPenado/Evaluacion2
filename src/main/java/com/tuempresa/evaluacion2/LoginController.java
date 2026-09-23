package com.tuempresa.evaluacion2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        // 1. Alerta si AMBOS campos están vacíos
        if (usuario.isEmpty() && password.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Debe ingresar el usuario y la contraseña.");
            txtUsuario.requestFocus();
            return;
        }

        // 2. Alerta si falta SOLO el usuario
        if (usuario.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Usuario requerido", "Por favor, ingrese su nombre de usuario.");
            txtUsuario.requestFocus();
            return;
        }

        // 3. Alerta si falta SOLO la contraseña
        if (password.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Contraseña requerida", "Por favor, ingrese su contraseña.");
            txtPassword.requestFocus();
            return;
        }

        // 4. Validar credenciales correctas
        if (usuario.equals("admin") && password.equals("1234")) {
            abrirVentanaPrincipal();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de acceso", "Usuario o contraseña incorrectos.");
        }
    }

    // Método auxiliar reutilizable para lanzar alertas sencillas
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void abrirVentanaPrincipal() {
        try {
            // Asegúrate de que la ruta del FXML coincida con la estructura de tus resources
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pagina_principal.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Menú Principal");
            stage.setScene(scene);
            stage.show();

            // Cerrar la ventana de login actual
            Stage ventanaLogin = (Stage) btnLogin.getScene().getWindow();
            ventanaLogin.close();

        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta(Alert.AlertType.ERROR, "Error de carga", "No se pudo abrir la ventana principal.");
        }
    }

    private void cerrarApp() {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Salir");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Desea cerrar la aplicación?");
        if (confirmacion.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            Stage ventana = (Stage) btnSalir.getScene().getWindow();
            ventana.close();
        }
    }
}